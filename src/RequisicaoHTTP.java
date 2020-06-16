import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RequisicaoHTTP {
	
	public String get(String uri) throws Exception {
	    HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	          .uri(URI.create(uri))
	          .build();

	    HttpResponse<String> response =
	          client.send(request, BodyHandlers.ofString());

	    return response.body();
	    
	}
	
	public void post() {
		
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPost uploadFile = new HttpPost("https://api.codenation.dev/v1/challenge/dev-ps/submit-solution?token=fea03e5ee88ee1a7a6781050f536d87d733cc6cc");
			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
	    	//builder.addTextBody("field1", "yes", ContentType.TEXT_PLAIN);
	
			// This attaches the file to the POST:
			File f = new File("answer.json");
			builder.addBinaryBody(
			    "answer",
			    new FileInputStream(f),
			    ContentType.APPLICATION_OCTET_STREAM,
			    f.getName()
			);
	
			HttpEntity multipart = builder.build();
			uploadFile.setEntity(multipart);
			CloseableHttpResponse response = httpClient.execute(uploadFile);
			HttpEntity responseEntity = response.getEntity();
			
			System.out.println(responseEntity.getContent());
		}catch (Exception exe) {
			exe.getStackTrace();
		}
	}

}
