package by.epamlab.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ElementNotFoundException extends Exception implements ExceptionMapper<ElementNotFoundException> {

    private static final long serialVersionUID = 1L;

    public static final String TEXT_NOT_FOUND_OBJECT = "Service can`t find object for this operatin";

    public ElementNotFoundException() {
        super(TEXT_NOT_FOUND_OBJECT);
    }

    public ElementNotFoundException(String string) {
        super(string);
    }

    @Override
    public Response toResponse(ElementNotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND).entity(exception.getMessage()).type("text/plain").build();
    }

}
