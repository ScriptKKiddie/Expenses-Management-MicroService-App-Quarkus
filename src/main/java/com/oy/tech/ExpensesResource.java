package com.oy.tech;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Set;
import java.util.UUID;

@Path("/expenses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExpensesResource {

    @Inject
    ExpensesService expensesService;

    @GET
    public Set<Expenses> myList() {
        return expensesService.list();
    }

    @POST
    public Expenses myCreate(Expenses expense) {
        return expensesService.create(expense);
    }

    @DELETE
    @Path("{uuid}")
    public boolean myDelete(@PathParam("uuid") UUID uuid) {
        return expensesService.delete(uuid);
    }

    @PUT
    public void myUpdate(Expenses expense) {
        expensesService.update(expense);
    }



}
