package it.pagopa.swclient.camunda.poc.service;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import io.quarkus.logging.Log;

@Named
@Dependent
public class ErrorLog implements JavaDelegate {
	@Override
	public void execute(DelegateExecution execution) {
		Log.info("\n\nERROR");
		execution.getVariables().forEach((k, v) -> Log.info(k + " = " + v + " -- v class = " + (v != null ? v.getClass() : "null")));
	}
}