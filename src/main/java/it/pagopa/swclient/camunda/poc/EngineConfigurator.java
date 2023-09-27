package it.pagopa.swclient.camunda.poc;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.script.ScriptEngineManager;

import org.camunda.bpm.engine.impl.cfg.ProcessEnginePlugin;
import org.camunda.bpm.quarkus.engine.extension.QuarkusProcessEngineConfiguration;
import org.camunda.connect.plugin.impl.ConnectProcessEnginePlugin;
import org.camunda.spin.plugin.impl.SpinProcessEnginePlugin;

@ApplicationScoped
public class EngineConfigurator extends QuarkusProcessEngineConfiguration {
	public EngineConfigurator() {
	    List<ProcessEnginePlugin> plugins = new ArrayList<>();
	    plugins.add(new ConnectProcessEnginePlugin());
	    plugins.add(new SpinProcessEnginePlugin());
	    setProcessEnginePlugins(plugins);
	    
	    setScriptEngineResolver(new ScriptEngineResolver(new ScriptEngineManager()));
	  }
}
