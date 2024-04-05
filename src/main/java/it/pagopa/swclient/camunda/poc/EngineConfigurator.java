package it.pagopa.swclient.camunda.poc;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.script.ScriptEngineManager;

import org.camunda.bpm.engine.impl.cfg.ProcessEnginePlugin;
import org.camunda.bpm.quarkus.engine.extension.QuarkusProcessEngineConfiguration;
import org.camunda.connect.plugin.impl.ConnectProcessEnginePlugin;
import org.camunda.spin.plugin.impl.SpinProcessEnginePlugin;

import io.quarkus.logging.Log;

@ApplicationScoped
public class EngineConfigurator extends QuarkusProcessEngineConfiguration {
	/**
	 * 
	 */
	public EngineConfigurator() {
		Log.info(">>> EngineConfigurator");
		List<ProcessEnginePlugin> plugins = getProcessEnginePlugins();

		/*
		 * 
		 */
		plugins.add(new ConnectProcessEnginePlugin());
		plugins.add(new SpinProcessEnginePlugin());
		setScriptEngineResolver(new ScriptEngineResolver(new ScriptEngineManager()));

		/*
		 * https://forum.camunda.io/t/create-execution-listener-in-spring-modified/1650/5
		 */
		// plugins.add(new ProcessApplicationEventListenerPlugin());
		plugins.add(new MyParseListenerPlugin());
	}
}
