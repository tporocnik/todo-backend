package de.poro.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.util.List;

import javax.json.JsonObject;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("IntegrationTest")
class TodoResourceTest {

	static TodoResourceTestClient client = null;

	static long taskIdUnderTest;

	@BeforeAll
	public static void init() {
		URI baseURI = URI.create("http://localhost:8088");
		client = RestClientBuilder.newBuilder().baseUri(baseURI).build(TodoResourceTestClient.class);
		assertNotNull(client, "Couldn't init client");
	}

	@Test
	@Order(1)
	void testAdd() {
		// add
		Task t = new Task(0, "Test task");
		Task result = client.addTask(t);
		assertNotNull(result, "Result is null");
		taskIdUnderTest = result.getId();
		assertTrue(taskIdUnderTest > 0L, "Wrong id");
	}

	@Test
	@Order(2)
	void testList() {
		// list
		List<Task> resultList = client.listTasks();
		assertNotNull(resultList, "Result is null");
		assertTrue(resultList.size() > 0, "Result is empty");
	}

	@Test
	@Order(3)
	void testGet() {
		// get
		Task result = client.getTask(taskIdUnderTest);
		assertNotNull(result, "Result is null");
	}

	@Test
	@Order(4)
	void testDelete() {
		// delete
		JsonObject resultStatus = client.deleteTask(taskIdUnderTest);
		assertEquals(Response.Status.OK.name(), resultStatus.getString("response"), "Wrong status");
	}

}
