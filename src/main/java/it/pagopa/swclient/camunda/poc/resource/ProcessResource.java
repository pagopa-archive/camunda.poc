package it.pagopa.swclient.camunda.poc.resource;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/process")
public class ProcessResource {
	@Inject
	RuntimeService runtimeService;

	@ConfigProperty(name = "client.id")
	String clientId;

	@ConfigProperty(name = "client.secret")
	String clientSecret;

	@Path("/one")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String one() {
		Map<String, Object> variables = new HashMap<>();
		variables.put("authUrl", "https://mil-d-apim.azure-api.net/mil-auth/token");
		variables.put("requestId", UUID.randomUUID().toString());
		variables.put("acquirerId", "06789");
		variables.put("terminalId", "64874412");
		variables.put("channel", "ATM");
		variables.put("clientId", clientId);
		variables.put("clientSecret", clientSecret);

		variables.put("paymentNoticeUrl", "https://mil-d-apim.azure-api.net/mil-payment-notice");
		variables.put("paTaxCode", "00000000201");
		variables.put("noticeNumber", "123456789012345678");

		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("payment", variables);
		String processInstanceId = processInstance.getId();

		return "Process instance with id " + processInstanceId + " started!";
	}
	
	@Path("/two")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String two() {
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("listenersTest");
		String processInstanceId = processInstance.getId();

		return "Process instance with id " + processInstanceId + " started!";
	}
	
	@Path("/three")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String three() {
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("Process_10q8fbq");
		String processInstanceId = processInstance.getId();

		return "Process instance with id " + processInstanceId + " started!";
	}
}