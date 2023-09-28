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
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/process")
public class ProcessResource {
	@Inject
	RuntimeService runtimeService;

	@ConfigProperty(name = "client.id")
	String clientId;

	@ConfigProperty(name = "client.secret")
	String clientSecret;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String payment() {
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

		String processInstanceId = runtimeService.startProcessInstanceByKey("payment", variables).getId();
		return "Process instance with id " + processInstanceId + " started!";
	}
}