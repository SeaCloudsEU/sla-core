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
package eu.atos.sla.evaluation;

import java.util.List;
import java.util.Map;

import eu.atos.sla.datamodel.IAgreement;
import eu.atos.sla.datamodel.IGuaranteeTerm;
import eu.atos.sla.evaluation.constraint.IConstraintEvaluator;
import eu.atos.sla.evaluation.guarantee.IBusinessValuesEvaluator;
import eu.atos.sla.evaluation.guarantee.IGuaranteeTermEvaluator;
import eu.atos.sla.evaluation.guarantee.IServiceLevelEvaluator;
import eu.atos.sla.evaluation.guarantee.IGuaranteeTermEvaluator.GuaranteeTermEvaluationResult;
import eu.atos.sla.monitoring.IMonitoringMetric;

/**
 * Executes an in-memory evaluation of the metrics of an agreement.
 * 
 * The process:
 * <ul>
 * <li>Check what metrics do not fulfill the service levels (breaches).
 * <li>Check and raise the violations according to the found breaches and policies (if any) of service levels.
 * <li>Check and raise the compensations (business violations) that are derived from the raised violations.
 * </ul>
 * 
 * The result is a map that contains for each guarantee term, the list of violations and compensations that were
 * detected.
 * 
 * @see IConstraintEvaluator
 * @see IGuaranteeTermEvaluator
 * @see IServiceLevelEvaluator
 * @see IBusinessValuesEvaluator
 * 
 * @author rsosa
 */
public interface IAgreementEvaluator {
	
	/**
	 * Evaluate if the metrics fulfill the agreement's service levels.
	 * @param agreement Agreement to evaluate.
	 * @param metricsMap Contains the list of metrics to check for each guarantee term. 
	 * @return list of violations and compensations detected.
	 */
	Map<IGuaranteeTerm, GuaranteeTermEvaluationResult> evaluate(
			IAgreement agreement, Map<IGuaranteeTerm, List<IMonitoringMetric>> metricsMap);
}

