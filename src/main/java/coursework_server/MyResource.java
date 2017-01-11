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
    public Response getAllGroups(@Context UriInfo info){
        DBWorker worker=new DBWorker();
        List<Group> list=worker.getAllGroups();
        worker.closeConnection();
        return sendList(list);
    }

    @GET
    @Path("groups/get")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getGroups(@Context UriInfo info){
        int specialityId=Integer.parseInt(info.getQueryParameters().getFirst("id"));
        DBWorker worker=new DBWorker();
        List<Group> list=worker.getGroups(specialityId);
        worker.closeConnection();
        return sendList(list);
    }

    @GET
    @Path("subjects/getall")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getAllSubjects(@Context UriInfo info){
        DBWorker worker=new DBWorker();
        List<Subject> list=worker.getAllSubjects();
        worker.closeConnection();
        return sendList(list);
    }

    @GET
    @Path("cafedras/getall")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getAllCafedras(@Context UriInfo info){
        DBWorker worker=new DBWorker();
        List<Cafedra> list=worker.getAllCafedras();
        worker.closeConnection();
        return sendList(list);
    }

    @GET
    @Path("cafedras/get")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getCafedras(@Context UriInfo info){
        int facultyId=Integer.parseInt(info.getQueryParameters().getFirst("id"));
        DBWorker worker=new DBWorker();
        List<Cafedra> list=worker.getCafedras(facultyId);
        worker.closeConnection();
        return sendList(list);
    }

    @GET
    @Path("specialitites/getall")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getAllSpecialitites(@Context UriInfo info){
        DBWorker worker=new DBWorker();
        List<Speciality> list=worker.getAllSpecialitites();
        worker.closeConnection();
        return sendList(list);
    }

    @GET
    @Path("specialitites/get")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getSpecialitites(@Context UriInfo info){
        int cafedraId=Integer.parseInt(info.getQueryParameters().getFirst("id"));
        DBWorker worker=new DBWorker();
        List<Speciality> list=worker.getSpecialitites(cafedraId);
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
