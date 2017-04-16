package by.epamlab;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.ws.rs.core.MediaType;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RunnerClientREST {
    private static final Logger LOG = Logger.getLogger(RunnerClientREST.class);

    public static void main(String[] args) {
        String resourceAddress = "";
        String acceptDataType = "";
        String method = "";
        String data = null;

        resourceAddress = "http://localhost:8080/ServiceREST/documents";
        acceptDataType = null;
        method = "GET";
        printResult(resourceAddress, acceptDataType, method);

        resourceAddress = "http://localhost:8080/ServiceREST/documents/5";
        acceptDataType = null;
        method = "GET";
        printResult(resourceAddress, acceptDataType, method);

        resourceAddress = "http://localhost:8080/ServiceREST/documents/111111111";
        acceptDataType = null;
        method = "GET";
        printResult(resourceAddress, acceptDataType, method);

        resourceAddress = "http://localhost:8080/ServiceREST/documents/chapters/shortest";
        acceptDataType = "application/xml";
        method = "GET";
        printResult(resourceAddress, acceptDataType, method);

        resourceAddress = "http://localhost:8080/ServiceREST/documents";
        acceptDataType = "application/json";
        method = "POST";
        data = "{\"id\":1000,\"name\":\"XXX\",\"chapters\":{\"chapters\":[{\"id\":1,\"chapterNumber\":111,\"numberOfPage\":21},{\"id\":2,\"chapterNumber\":12,\"numberOfPage\":12},{\"id\":3,\"chapterNumber\":1,\"numberOfPage\":12},{\"id\":4,\"chapterNumber\":34,\"numberOfPage\":12},{\"id\":5,\"chapterNumber\":54,\"numberOfPage\":322},{\"id\":6,\"chapterNumber\":45,\"numberOfPage\":122}]}}";
        printResultQQQ(resourceAddress, acceptDataType, method, data);

        resourceAddress = "http://localhost:8080/ServiceREST/documents";
        acceptDataType = "application/json";
        method = "POST";
        data = "incorrect data";
        printResultQQQ(resourceAddress, acceptDataType, method, data);

        resourceAddress = "http://localhost:8080/ServiceREST/documents";
        acceptDataType = "application/json";
        method = "PUT";
        data = "{\"id\":1000,\"name\":\"XXX\",\"chapters\":{\"chapters\":[{\"id\":1,\"chapterNumber\":111,\"numberOfPage\":21},{\"id\":2,\"chapterNumber\":12,\"numberOfPage\":12},{\"id\":3,\"chapterNumber\":1,\"numberOfPage\":12},{\"id\":4,\"chapterNumber\":34,\"numberOfPage\":12},{\"id\":5,\"chapterNumber\":54,\"numberOfPage\":322},{\"id\":6,\"chapterNumber\":45,\"numberOfPage\":122}]}}";
        printResultQQQ(resourceAddress, acceptDataType, method, data);

        resourceAddress = "http://localhost:8080/ServiceREST/documents";
        acceptDataType = "application/json";
        method = "PUT";
        data = "{\"id\":5555,\"name\":\"XXX\",\"chapters\":{\"chapters\":[{\"id\":1,\"chapterNumber\":111,\"numberOfPage\":21},{\"id\":2,\"chapterNumber\":12,\"numberOfPage\":12},{\"id\":3,\"chapterNumber\":1,\"numberOfPage\":12},{\"id\":4,\"chapterNumber\":34,\"numberOfPage\":12},{\"id\":5,\"chapterNumber\":54,\"numberOfPage\":322},{\"id\":6,\"chapterNumber\":45,\"numberOfPage\":122}]}}";
        printResultQQQ(resourceAddress, acceptDataType, method, data);

        resourceAddress = "http://localhost:8080/ServiceREST/documents/1000";
        acceptDataType = "application/json";
        method = "DELETE";
        data = null;
        printResult(resourceAddress, acceptDataType, method);

    }

    static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    private static void printResult(final String resourceAddress, final String acceptDataType, final String method) {
        try {
            Client client = Client.create();
            WebResource webResource = client.resource(resourceAddress);
            ClientResponse response = webResource.accept(acceptDataType).method(method, ClientResponse.class);
            String output = response.getEntity(String.class);
            LOG.info("REQUEST : " + method);
            LOG.info("REQUEST: " + resourceAddress);
            LOG.info("RESPONSE STATUS: " + response.getStatus());
            LOG.info("RESPONSE DATA: " + output + "\n");
        } catch (Exception e) {
            LOG.error("---" + e);
        }
    }

    private static void printResultQQQ(final String resourceAddress, final String acceptDataType, final String method,
            final String data) {
        try {
            Client client = Client.create();
            WebResource webResource = client.resource(resourceAddress);
            ClientResponse response = webResource.accept(acceptDataType).entity(data, MediaType.APPLICATION_JSON)
                    .method(method, ClientResponse.class);
            String output = response.getEntity(String.class);
            LOG.info("REQUEST : " + method);
            LOG.info("REQUEST: " + resourceAddress);
            LOG.info("REQUEST: " + data);
            LOG.info("RESPONSE STATUS: " + response.getStatus());
            LOG.info("RESPONSE DATA: " + output + "\n");
        } catch (Exception e) {
            LOG.error(e);
        }
    }

}
