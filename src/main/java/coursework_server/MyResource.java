package coursework_server;

import com.google.gson.Gson;
import org.eclipse.persistence.oxm.JSONWithPadding;

import javax.ws.rs.*;
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
    @Path("groups/byteachid/get")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getGroupsByTeachId(@Context UriInfo info){
        int specialityId=Integer.parseInt(info.getQueryParameters().getFirst("idT"));
        DBWorker worker=new DBWorker();
        List<Group> list=worker.getGroupsByTeachId(specialityId);
        worker.closeConnection();
        return sendList(list);
    }

    @GET
    @Path("groups/byteachidandsubid/get")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getGroupsByTeachIdAndSubId(@Context UriInfo info){
        int subId=Integer.parseInt(info.getQueryParameters().getFirst("idS"));
        int teachId=Integer.parseInt(info.getQueryParameters().getFirst("idT"));
        DBWorker worker=new DBWorker();
        List<Group> list=worker.getGroupsByTeachIdAndSubId(teachId,subId);
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
    @Path("subjects/bygroupidandteachid/get")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getSubjectsByGroupIdAndTeacherId(@Context UriInfo info){
        int groupId=Integer.parseInt(info.getQueryParameters().getFirst("idG"));
        int teachId=Integer.parseInt(info.getQueryParameters().getFirst("idT"));
        DBWorker worker=new DBWorker();
        List<Subject> list=worker.getAllSubjectsByGroupIdAndTeachId(groupId,teachId);
        worker.closeConnection();
        return sendList(list);
    }

    @GET
    @Path("subjects/byteachid/get")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getSubjectsByTeacherId(@Context UriInfo info){
        int teachId=Integer.parseInt(info.getQueryParameters().getFirst("idT"));
        DBWorker worker=new DBWorker();
        List<Subject> list=worker.getAllSubjectsByTeachId(teachId);
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
    @Path("teachers/byid/get")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getTeachersById(@Context UriInfo info){
        int id=Integer.valueOf(info.getQueryParameters().getFirst("idT"));
        DBWorker worker=new DBWorker();
        List<Teacher> list=worker.getTeachersId(id);
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

    @PUT
    @Path("students/putattest")
    @Produces(MediaType.TEXT_PLAIN)
    public Response putAttest(@Context UriInfo info){
        int attest=Integer.parseInt(info.getQueryParameters().getFirst("attest"));
        int groupId=Integer.parseInt(info.getQueryParameters().getFirst("idG"));
        int subId=Integer.parseInt(info.getQueryParameters().getFirst("idS"));
        int marks=Integer.parseInt(info.getQueryParameters().getFirst("marks"));
        int lection=Integer.parseInt(info.getQueryParameters().getFirst("lections"));
        int works=Integer.parseInt(info.getQueryParameters().getFirst("works"));
        DBWorker worker=new DBWorker();
        worker.putAttest(subId,groupId,marks,lection,works,attest);
        worker.closeConnection();
        return Response.status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                .allow("OPTIONS").build();
    }

    @POST
    @Path("auth")
    @Produces(MediaType.TEXT_PLAIN)
    public Response auth(@Context UriInfo info){
        String login=info.getQueryParameters().getFirst("l");
        String pass=info.getQueryParameters().getFirst("p");
        DBWorker worker=new DBWorker();
        List<Status> statuses=worker.auth(login,pass);
        worker.closeConnection();
        return sendList(statuses);
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
