package by.epamlab.exception;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class CustomInternalServerError extends Exception implements ExceptionMapper<InternalServerErrorException> {

    private static final long serialVersionUID = 1L;

    public static final String TEXT_CUSTOM_INTERNAL_SERVER_ERROR = "Hi!  Sorry for the error, but it's a custom server error!";

    public CustomInternalServerError() {
        super(TEXT_CUSTOM_INTERNAL_SERVER_ERROR);
    }

    public CustomInternalServerError(String string) {
        super(string);
    }

    @Override
    public Response toResponse(InternalServerErrorException exception) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(TEXT_CUSTOM_INTERNAL_SERVER_ERROR + "\t=>\t" + exception.getMessage()).type("text/plain").build();
    }

}
