package it.pagopa.swclient.camunda.poc.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import io.quarkus.logging.Log;

@Named
@Dependent
public class SuccessLog implements JavaDelegate {
	@Override
	public void execute(DelegateExecution execution) {
		Log.info(">>> SUCCESS");
		execution.getVariables().forEach((k, v) -> Log.info(k + " = " + v + " -- v class = " + (v != null ? v.getClass() : "null")));
	}
}