package it.pagopa.swclient.camunda.poc;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.camunda.bpm.engine.impl.scripting.engine.DefaultScriptEngineResolver;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Engine;

import com.oracle.truffle.js.scriptengine.GraalJSScriptEngine;

import io.quarkus.logging.Log;

public class ScriptEngineResolver extends DefaultScriptEngineResolver {
	public ScriptEngineResolver(ScriptEngineManager scriptEngineManager) {
		super(scriptEngineManager);
		Log.info(">>> ScriptEngineResolver");
	}

	@Override
	protected ScriptEngine getJavaScriptScriptEngine(String language) {
		Log.info(">>> getJavaScriptScriptEngine");
		return GraalJSScriptEngine.create(
			Engine.newBuilder()
				.allowExperimentalOptions(true)
				.option("engine.WarnInterpreterOnly", "false")
				.build(),
			Context.newBuilder("js"));
	}
}
