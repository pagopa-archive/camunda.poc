package it.pagopa.swclient.camunda.poc;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.camunda.bpm.engine.impl.scripting.engine.DefaultScriptEngineResolver;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Engine;

import com.oracle.truffle.js.scriptengine.GraalJSScriptEngine;

public class ScriptEngineResolver extends DefaultScriptEngineResolver {
	public ScriptEngineResolver(ScriptEngineManager scriptEngineManager) {
		super(scriptEngineManager);
	}

	@Override
    protected ScriptEngine getJavaScriptScriptEngine(String language) {
        Engine graalEngine = Engine.newBuilder()
                .allowExperimentalOptions(true)
                .option("engine.WarnInterpreterOnly", "false")
                .build();

        return GraalJSScriptEngine.create(graalEngine, Context.newBuilder("js"));
    }
}
