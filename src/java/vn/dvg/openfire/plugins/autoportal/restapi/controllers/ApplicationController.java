package vn.dvg.openfire.plugins.autoportal.restapi.controllers;

import vn.dvg.openfire.plugins.autoportal.data.dao.ApplicationDao;
import vn.dvg.openfire.plugins.autoportal.restapi.models.application.ApplicationResponse;
import vn.dvg.openfire.plugins.autoportal.restapi.services.ApplicationService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/dvg-autoportal/api/v1/applications")
@Produces(MediaType.APPLICATION_JSON)
public class ApplicationController {
    @GET
    public List<ApplicationResponse> getAllApplication() throws SQLException, IllegalAccessException {
        return ApplicationService.getAllApplications();
    }

    @GET
    @Path("/filter")
    public List<ApplicationResponse> filter() throws SQLException, IllegalAccessException {
        return ApplicationService.filter();
    }

    @POST

    public int add() throws Exception{
        return ApplicationDao.add();
    }
}
