package de.poro.todo;

import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/todo")
@Transactional
public class TodoResource {

	@GET
	@Path("/tasks")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Task> listTasks() {
		return Task.listAll();
	}

	@GET
	@Path("/tasks/{taskId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Task getTask(@PathParam("taskId") long taskId) {
		return Task.findById(taskId);
	}

	@POST
	@Path("/tasks")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Task addTask(Task task) {
		task.persist();
		return task;
	}

	@DELETE
	@Path("/tasks/{taskId}")
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject deleteTask(@PathParam("taskId") long taskId) {
		Task.deleteById(Long.valueOf(taskId));
		return Json.createObjectBuilder().add("response", Response.Status.OK.name()).build();
	}
}