package coursework_server;

import com.google.gson.Gson;
import org.eclipse.persistence.oxm.JSONWithPadding;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.*;
import java.util.ArrayList;
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
    public Response getAllFaculties(@QueryParam("callback") String callback) {
        DBWorker worker=new DBWorker();
        List<Faculty> list=worker.getFaculties();
        worker.closeConnection();
        return sendList(list);
    }

    @GET
    @Path("faculties/bygroupid/get")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getFacultiesByGroupId(@Context UriInfo info){
        int groupId=Integer.parseInt(info.getQueryParameters().getFirst("id"));
        DBWorker worker=new DBWorker();
        List<Faculty> list=worker.getFacultiesByGroupId(groupId);
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
    @Path("groups/byfacid/get")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getGroupsByFacId(@Context UriInfo info){
        int facultyId=Integer.parseInt(info.getQueryParameters().getFirst("id"));
        DBWorker worker=new DBWorker();
        List<Group> list=worker.getGroupsByFacId(facultyId);
        worker.closeConnection();
        return sendList(list);
    }

    @GET
    @Path("groups/bycafid/get")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getGroupsByCafId(@Context UriInfo info){
        int cafedraId=Integer.parseInt(info.getQueryParameters().getFirst("id"));
        DBWorker worker=new DBWorker();
        List<Group> list=worker.getGroupsByCafId(cafedraId);
        worker.closeConnection();
        return sendList(list);
    }

    @GET
    @Path("groups/byspecid/get")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getGroupsBySpecId(@Context UriInfo info){
        int specialityId=Integer.parseInt(info.getQueryParameters().getFirst("id"));
        DBWorker worker=new DBWorker();
        List<Group> list=worker.getGroupsBySpecId(specialityId);
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
    @Path("subjects/teacher/getall")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getAllSubjectsWithTeach(@Context UriInfo info){
        DBWorker worker=new DBWorker();
        List<SubjectWithTeachId> list=worker.getAllSubjectsWithTeachId();
        worker.closeConnection();
        return sendList(list);
    }

    @GET
    @Path("subjects/teacher/bygroupid/get")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getAllSubjectsWithTeacherByGroupId(@Context UriInfo info){
        int groupId=Integer.parseInt(info.getQueryParameters().getFirst("id"));
        DBWorker worker=new DBWorker();
        List<SubjectWithTeacher> list=worker.getAllSubjectsWithTeacherByGroupId(groupId);
        worker.closeConnection();
        return sendList(list);
    }

    @GET
    @Path("subjects/byfacid/get")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getSubjectsByFacId(@Context UriInfo info){
        int facultyId=Integer.parseInt(info.getQueryParameters().getFirst("id"));
        DBWorker worker=new DBWorker();
        List<Subject> list=worker.getAllSubjectsByFacId(facultyId);
        worker.closeConnection();
        return sendList(list);
    }

    @GET
    @Path("subjects/bygroupid/get")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getSubjectsByGroupId(@Context UriInfo info){
        int groupId=Integer.parseInt(info.getQueryParameters().getFirst("id"));
        DBWorker worker=new DBWorker();
        List<Subject> list=worker.getAllSubjectsByGroupId(groupId);
        worker.closeConnection();
        return sendList(list);
    }

    @GET
    @Path("subjects/bycafid/get")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getSubjectsByCafId(@Context UriInfo info){
        int groupId=Integer.parseInt(info.getQueryParameters().getFirst("id"));
        DBWorker worker=new DBWorker();
        List<Subject> list=worker.getAllSubjectsByCafId(groupId);
        worker.closeConnection();
        return sendList(list);
    }

    @GET
    @Path("subjects/byspecid/get")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getSubjectsBySpecId(@Context UriInfo info){
        int groupId=Integer.parseInt(info.getQueryParameters().getFirst("id"));
        DBWorker worker=new DBWorker();
        List<Subject> list=worker.getAllSubjectsBySpecId(groupId);
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
    @Path("cafedras/byfacid/get")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getCafedrasbyFacId(@Context UriInfo info){
        int facultyId=Integer.parseInt(info.getQueryParameters().getFirst("id"));
        DBWorker worker=new DBWorker();
        List<Cafedra> list=worker.getCafedrasbyFacId(facultyId);
        worker.closeConnection();
        return sendList(list);
    }

    @GET
    @Path("cafedras/bygroupid/get")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getCafedrasbygroupId(@Context UriInfo info){
        int groupId=Integer.parseInt(info.getQueryParameters().getFirst("id"));
        DBWorker worker=new DBWorker();
        List<Cafedra> list=worker.getCafedrasbyGroupId(groupId);
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
    @Path("specialitites/bycafid/get")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getSpecialitites(@Context UriInfo info){
        int cafedraId=Integer.parseInt(info.getQueryParameters().getFirst("id"));
        DBWorker worker=new DBWorker();
        List<Speciality> list=worker.getSpecialitites(cafedraId);
        worker.closeConnection();
        return sendList(list);
    }

    @GET
    @Path("specialitites/bygroupid/get")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getSpecialititesByGroupId(@Context UriInfo info){
        int groupId=Integer.parseInt(info.getQueryParameters().getFirst("id"));
        DBWorker worker=new DBWorker();
        List<Speciality> list=worker.getSpecialititesByGroupId(groupId);
        worker.closeConnection();
        return sendList(list);
    }

    @GET
    @Path("teachers/bysubname/get")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getTeachersBySubName(@Context UriInfo info){
        String subName=info.getQueryParameters().getFirst("name");
        DBWorker worker=new DBWorker();
        List<Teacher> list=worker.getTeachersBySubName(subName);
        worker.closeConnection();
        return sendList(list);
    }

    @GET
    @Path("teachers/bysubnameandfacid/get")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getTeachersBySubNameAndFacId(@Context UriInfo info){
        String subName=info.getQueryParameters().getFirst("name");
        int facultyId=Integer.parseInt(info.getQueryParameters().getFirst("id"));
        DBWorker worker=new DBWorker();
        List<Teacher> list=worker.getTeachersBySubNameAndFacId(subName,facultyId);
        worker.closeConnection();
        return  sendList(list);
    }
    @GET
    @Path("teachers/bysubnameandgroupid/get")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getTeachersBySubNameAndGroupId(@Context UriInfo info){
        String subName=info.getQueryParameters().getFirst("name");
        int groupId=Integer.parseInt(info.getQueryParameters().getFirst("id"));
        DBWorker worker=new DBWorker();
        List<Teacher> list=worker.getTeachersBySubNameAndGroupId(subName,groupId);
        worker.closeConnection();
        return  sendList(list);
    }

    @GET
    @Path("students/bysubidandgroupid/getall")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getSrudentsBySubIdAndGroupId(@Context UriInfo info){
        int groupId=Integer.parseInt(info.getQueryParameters().getFirst("idG"));
        int subId=Integer.parseInt(info.getQueryParameters().getFirst("idS"));
        DBWorker worker=new DBWorker();
        List<Student> list=worker.getStudentsBySubAndGroup(subId,groupId);
        worker.closeConnection();
        return sendList(list);
    }

    private Response sendList(List list){
        if(list!=null){
            Gson gson=new Gson();
            String json=gson.toJson(list);
            return Response.status(200).entity(json)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                    .allow("OPTIONS").build();
        } else
            return Response.status(400).header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                    .allow("OPTIONS").build();
    }
}
