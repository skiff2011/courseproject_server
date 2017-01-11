package coursework_server;

import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("database")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("faculties/getall")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getAllFaculties() {
        DBWorker worker=new DBWorker();
        List<Faculty> list=worker.getFaculties();
        worker.closeConnection();
        return sendList(list);
    }

    @GET
    @Path("groups/getall")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getGroups(@Context UriInfo info){
        DBWorker worker=new DBWorker();
        List<Group> list=worker.getAllGroups();
        worker.closeConnection();
        return sendList(list);
    }

    private Response sendList(List list){
        if(list!=null){
            Gson gson=new Gson();
            String json=gson.toJson(list);
            return Response.status(200).entity(json).build();
        } else
            return Response.status(400).build();
    }
}
