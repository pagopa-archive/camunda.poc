package it.pagopa.swclient.camunda.poc;

import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.quarkus.engine.extension.event.CamundaEngineStartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class ProcessDeployer {
	@Inject
	public RepositoryService repositoryService;

	public void deployProcess(@Observes CamundaEngineStartupEvent startupEvent) {
		repositoryService.createDeployment()
			.addClasspathResource("paymentFlow.bpmn")
			.enableDuplicateFiltering(true)
			.deploy();
	}
}