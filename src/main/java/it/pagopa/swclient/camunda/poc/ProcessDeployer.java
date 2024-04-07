package it.pagopa.swclient.camunda.poc;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.quarkus.engine.extension.event.CamundaEngineStartupEvent;

import io.quarkus.logging.Log;

@ApplicationScoped
public class ProcessDeployer {
	@Inject
	public RepositoryService repositoryService;

	public void deployProcess(@Observes CamundaEngineStartupEvent startupEvent) {
		Log.info(">>> deployProcess");
		repositoryService.createDeployment()
			.addClasspathResource("paymentFlow.bpmn")
			.addClasspathResource("listenersTest.bpmn")
			.addClasspathResource("diagram_1.bpmn")
			.enableDuplicateFiltering(true)
			.deploy();
	}
}