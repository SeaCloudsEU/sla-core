/**
 * Copyright 2014 Atos
 * Contact: Atos <roman.sosa@atos.net>
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package eu.atos.sla.service.rest;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.FormDataMultiPart;

import eu.atos.sla.dao.IProviderDAO;
import eu.atos.sla.datamodel.IProvider;
import eu.atos.sla.datamodel.bean.Provider;
import eu.atos.sla.parser.IParser;
import eu.atos.sla.parser.ParserException;
import eu.atos.sla.parser.data.wsag.Agreement;
import eu.atos.sla.service.rest.exception.InternalException;
import eu.atos.sla.service.rest.helpers.AgreementHelperE;
import eu.atos.sla.service.rest.helpers.exception.DBExistsHelperException;
import eu.atos.sla.service.rest.helpers.exception.DBMissingHelperException;
import eu.atos.sla.service.rest.helpers.exception.InternalHelperException;
import eu.atos.sla.service.rest.helpers.exception.ParserHelperException;

@Path("seaclouds")
@Component
@Transactional
public class SeacloudsRest extends AbstractSLARest {

	private static Logger logger = LoggerFactory.getLogger(SeacloudsRest.class);
	
	@Autowired
	private AgreementHelperE agreementHelper;
	
	@Autowired
	public IProviderDAO providerDAO;

	@Resource(name="agreementXmlParser")
	IParser<Agreement> xmlParser;
	
	@POST
	@Path("agreements")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response createAgreement(@Context UriInfo uriInfo, FormDataMultiPart form) 
			throws ParserException, InternalException {
		
		FormDataBodyPart slaPart = form.getField("sla");
		String slaPayload = slaPart.getValueAs(String.class);

		FormDataBodyPart rulesPart = form.getField("rules");
		
		String id;
		String location = null;
		Agreement a = xmlParser.getWsagObject(slaPayload);
		try {
			String providerUuid = a.getContext().getAgreementResponder();
			IProvider provider = providerDAO.getByUUID(providerUuid);
			if (provider == null) {
				provider = new Provider();
				provider.setUuid(providerUuid);
				provider.setName(providerUuid);
				provider = providerDAO.save(provider);
			}
			id = agreementHelper.createAgreement(a, slaPayload);
			location = buildResourceLocation(uriInfo.getAbsolutePath().toString() ,id);
		} catch (DBMissingHelperException e) {
			throw new InternalException(e.getMessage());
		} catch (DBExistsHelperException e) {
			throw new InternalException(e.getMessage());
		} catch (InternalHelperException e) {
			throw new InternalException(e.getMessage());
		} catch (ParserHelperException e) {
			throw new InternalException(e.getMessage());
		}
		logger.debug("EndOf createAgreement");
		return buildResponsePOST(
				HttpStatus.CREATED,
				createMessage(HttpStatus.CREATED, id, 
						"The agreement has been stored successfully in the SLA Repository Database. "
						+ "It has location " + location), location);
	}
	
}
