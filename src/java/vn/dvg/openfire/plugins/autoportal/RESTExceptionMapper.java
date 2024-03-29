package vn.dvg.openfire.plugins.autoportal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.dvg.openfire.plugins.autoportal.restapi.exceptions.ErrorResponse;
import vn.dvg.openfire.plugins.autoportal.restapi.exceptions.ServiceException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * The Class RESTExceptionMapper.
 */
@Provider
public class RESTExceptionMapper implements ExceptionMapper<ServiceException> {

    /** The log. */
    private static Logger LOG = LoggerFactory.getLogger(RESTExceptionMapper.class);

    /**
     * Instantiates a new REST exception mapper.
     */
    public RESTExceptionMapper() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
     */
    public Response toResponse(ServiceException exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setResource(exception.getResource());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setException(exception.getException());
        LOG.error(
                exception.getException() + ": " + exception.getMessage() + " with resource "
                        + exception.getResource(), exception.getException());
        return Response.status(exception.getStatus()).entity(errorResponse).type(MediaType.APPLICATION_XML).build();
    }

}
