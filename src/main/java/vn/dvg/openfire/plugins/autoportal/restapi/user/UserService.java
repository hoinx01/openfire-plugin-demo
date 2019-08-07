package vn.dvg.openfire.plugins.autoportal.restapi.user;

import lombok.val;
import vn.dvg.openfire.plugins.autoportal.restapi.user.models.UserModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class UserService {
    @GET
    @Path("/users/{id}")
    public UserModel GetUserById(@PathParam("id") String id){
        val user = new UserModel();
        user.setName("Nguyễn Xuân Hồi");
        user.setPhoneNumber("01234343434");
        user.setAvatarUrl("http://google.com.vn");
        return user;
    }

    @GET
    @Path("/users")
    public UserModel GetUser(){
        val user = new UserModel();
        user.setName("Nguyễn Xuân Hồi");
        user.setPhoneNumber("01234343434");
        user.setAvatarUrl("http://google.com.vn");
        return user;
    }
}
