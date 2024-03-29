package com.fly2gether.jetty_jersey.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/example")
public class ExampleResource {

	public static class ExampleClass {
		public String field;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/aircraft")
	public ExampleClass getExample() {
		ExampleClass instance = new ExampleClass();
		instance.field = "Test";

		return instance;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/aircraft")
	public void retrieveExample(ExampleClass instance) {
		System.out.println(instance.field);
	}
	
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/aircraft")
	public void putExample(ExampleClass instance) {
		instance.field = "Test";
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/aircraft")
	public void deleteExample(ExampleClass instance) {
		System.out.println("Example was deleted");
	}
}
