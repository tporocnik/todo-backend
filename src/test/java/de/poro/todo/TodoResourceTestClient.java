package de.poro.todo;

import java.util.List;

import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/todo/")
public interface TodoResourceTestClient {

	@Path("/tasks")
	@GET
	@Produces("application/json")
	List<Task> listTasks();

	@GET
	@Path("/tasks/{taskId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Task getTask(@PathParam("taskId") long taskId);

	@POST
	@Path("/tasks")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Task addTask(Task task);

	@DELETE
	@Path("/tasks/{taskId}")
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject deleteTask(@PathParam("taskId") long taskId);
}
