/*
 * OnCompleteTaskListener.java
 *
 * 5 apr 2024
 */
package it.pagopa.swclient.camunda.poc.listener;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;

import io.quarkus.logging.Log;

/**
 * 
 * @author antonio.tarricone
 */
public class OnCompleteTaskListener implements TaskListener {
	/**
	 * 
	 */
	@Override
	public void notify(DelegateTask delegateTask) {
		Log.infof(">>> OnCompleteTaskListener: [%s] [%s]", delegateTask.getEventName(), delegateTask.getName());
	}
}