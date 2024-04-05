/*
 * MyParseListener.java
 *
 * 5 apr 2024
 */
package it.pagopa.swclient.camunda.poc;

import org.camunda.bpm.application.impl.event.ProcessApplicationEventParseListener;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.impl.pvm.process.ActivityImpl;
import org.camunda.bpm.engine.impl.pvm.process.ScopeImpl;
import org.camunda.bpm.engine.impl.util.xml.Element;

import io.quarkus.logging.Log;
import it.pagopa.swclient.camunda.poc.listener.MyExecutionListener;

/**
 * 
 * @author antonio.tarricone
 */
public class MyParseListener extends ProcessApplicationEventParseListener {
	private ExecutionListener executionListener;

	public MyParseListener() {
		executionListener = new MyExecutionListener();
	}

	private void parseSomething(Element element, ScopeImpl scope, ActivityImpl activity) {
		Log.info(">>> parseSomething");
		activity.addListener(ExecutionListener.EVENTNAME_END, executionListener);
		activity.addListener(ExecutionListener.EVENTNAME_START, executionListener);
		activity.addListener(ExecutionListener.EVENTNAME_TAKE, executionListener);
	}

	@Override
	public void parseStartEvent(Element element, ScopeImpl scope, ActivityImpl activity) {
		super.parseStartEvent(element, scope, activity);
		parseSomething(element, scope, activity);
	}

	@Override
	public void parseExclusiveGateway(Element element, ScopeImpl scope, ActivityImpl activity) {
		super.parseExclusiveGateway(element, scope, activity);
		parseSomething(element, scope, activity);
	}

	@Override
	public void parseInclusiveGateway(Element element, ScopeImpl scope, ActivityImpl activity) {
		super.parseInclusiveGateway(element, scope, activity);
		parseSomething(element, scope, activity);
	}

	@Override
	public void parseParallelGateway(Element element, ScopeImpl scope, ActivityImpl activity) {
		super.parseParallelGateway(element, scope, activity);
		parseSomething(element, scope, activity);
	}

	@Override
	public void parseScriptTask(Element element, ScopeImpl scope, ActivityImpl activity) {
		super.parseScriptTask(element, scope, activity);
		parseSomething(element, scope, activity);
	}

	@Override
	public void parseServiceTask(Element element, ScopeImpl scope, ActivityImpl activity) {
		super.parseServiceTask(element, scope, activity);
		parseSomething(element, scope, activity);
	}

	@Override
	public void parseBusinessRuleTask(Element element, ScopeImpl scope, ActivityImpl activity) {
		super.parseBusinessRuleTask(element, scope, activity);
		parseSomething(element, scope, activity);
	}

	@Override
	public void parseTask(Element element, ScopeImpl scope, ActivityImpl activity) {
		super.parseTask(element, scope, activity);
		parseSomething(element, scope, activity);
	}

	@Override
	public void parseManualTask(Element element, ScopeImpl scope, ActivityImpl activity) {
		super.parseManualTask(element, scope, activity);
		parseSomething(element, scope, activity);
	}

	@Override
	public void parseUserTask(Element element, ScopeImpl scope, ActivityImpl activity) {
		super.parseUserTask(element, scope, activity);
		parseSomething(element, scope, activity);
	}

	@Override
	public void parseEndEvent(Element element, ScopeImpl scope, ActivityImpl activity) {
		super.parseEndEvent(element, scope, activity);
		parseSomething(element, scope, activity);
	}

	@Override
	public void parseSubProcess(Element element, ScopeImpl scope, ActivityImpl activity) {
		super.parseSubProcess(element, scope, activity);
		parseSomething(element, scope, activity);
	}

	@Override
	public void parseSendTask(Element element, ScopeImpl scope, ActivityImpl activity) {
		super.parseSendTask(element, scope, activity);
		parseSomething(element, scope, activity);
	}

	@Override
	public void parseReceiveTask(Element element, ScopeImpl scope, ActivityImpl activity) {
		super.parseReceiveTask(element, scope, activity);
		parseSomething(element, scope, activity);
	}

	@Override
	public void parseEventBasedGateway(Element element, ScopeImpl scope, ActivityImpl activity) {
		super.parseEventBasedGateway(element, scope, activity);
		parseSomething(element, scope, activity);
	}

	@Override
	public void parseTransaction(Element element, ScopeImpl scope, ActivityImpl activity) {
		super.parseTransaction(element, scope, activity);
		parseSomething(element, scope, activity);
	}

	@Override
	public void parseIntermediateThrowEvent(Element element, ScopeImpl scope, ActivityImpl activity) {
		super.parseIntermediateThrowEvent(element, scope, activity);
		parseSomething(element, scope, activity);
	}

	@Override
	public void parseIntermediateCatchEvent(Element element, ScopeImpl scope, ActivityImpl activity) {
		super.parseIntermediateCatchEvent(element, scope, activity);
		parseSomething(element, scope, activity);
	}

	@Override
	public void parseBoundaryEvent(Element element, ScopeImpl scope, ActivityImpl activity) {
		super.parseBoundaryEvent(element, scope, activity);
		parseSomething(element, scope, activity);
	}
	
	
}
