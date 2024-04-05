/*
 * MyParseListenerPlugin.java
 *
 * 5 apr 2024
 */
package it.pagopa.swclient.camunda.poc;

import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.engine.impl.bpmn.parser.BpmnParseListener;
import org.camunda.bpm.engine.impl.cfg.AbstractProcessEnginePlugin;
import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;

import io.quarkus.logging.Log;

/**
 * 
 * @author antonio.tarricone
 */
public class MyParseListenerPlugin extends AbstractProcessEnginePlugin {
	/**
	 * 
	 */
	@Override
	public void preInit(ProcessEngineConfigurationImpl processEngineConfiguration) {
		Log.info(">>> preInit");
		List<BpmnParseListener> preParseListeners = processEngineConfiguration.getCustomPostBPMNParseListeners();
		if (preParseListeners == null) {
			preParseListeners = new ArrayList<>();
		}
		preParseListeners.add(new MyParseListener());
		processEngineConfiguration.setCustomPostBPMNParseListeners(preParseListeners);
	}
}
