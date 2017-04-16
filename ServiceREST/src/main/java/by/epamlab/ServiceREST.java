package by.epamlab;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.model.wadl.Description;

import by.epamlab.beans.Document;

import by.epamlab.exception.ElementNotFoundException;

@Path(value = "/")
@WebService
public interface ServiceREST {

    @GET
    @Path("documents")
    @Produces(MediaType.APPLICATION_XML)
    @Description("Method return all documents from repository as list.")
    @WebMethod
    public Response getDocuments();

    @GET
    @Path("documents/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Description("Method return one document by identificator (id) from repository.")
    @WebMethod
    public Response getDocument(@PathParam("id") int id) throws ElementNotFoundException;

    @POST
    @Path("documents")
    @Consumes(MediaType.APPLICATION_JSON)
    @Description("Method for create document in repository.")
    @WebMethod
    public Response documentCreate(Document document);

    @PUT
    @Path("documents")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    @Description("Method for update document in repository.")
    @WebMethod
    public Response getDocumentUpdate(Document document) throws ElementNotFoundException;

    @DELETE
    @Path("documents/{id}")
    @Description("Method for delete one document by identificator (id) from repository.")
    @WebMethod
    public Response getDocumentDelete(@PathParam("id") int id);

    @GET
    @Path("documents/chapters/shortest")
    @Description("Method for getting  documents shortest chapters list from repository.")
    @WebMethod
    public Response getDocumentsWithShortestChapters();
}
