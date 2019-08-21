package vn.dvg.openfire.plugins.autoportal.restapi.controllers;

import lombok.val;
import vn.dvg.openfire.plugins.autoportal.restapi.models.user.UserModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/dvg-autoportal/api/v1/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserController {
    @GET
    @Path("/{id}")
    public UserModel GetUserById(@PathParam("id") String id){
        val user = new UserModel();
        user.setName("Nguyễn Xuân Hồi 02");
        user.setPhoneNumber("01234343434");
        user.setAvatarUrl("http://google.com.vn");
        return user;
    }

    @GET
    @Path("/")
    public UserModel GetUser(){
        val user = new UserModel();
        user.setName("Nguyễn Xuân Hồi");
        user.setPhoneNumber("01234343434");
        user.setAvatarUrl("http://google.com.vn");
        return user;
    }
}
