package app.rest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import app.repositories.ProfessorCourseRepository;
import app.repositories.ProfessorRepository;
import app.repositories.StudentRepository;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

// made a new class because we don't want to mix up the annotations 
// if two different types of technologies, try to separate to not mix improperly

@Component
@Path("chikka")
public class ChikkaComponent {
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private ProfessorCourseRepository professorCourseRepo;
	
	@Autowired
	private ProfessorRepository professorRepo;
	
	String messageType = "SEND";
	String shortCode = "29290559";
	String messageId = String.valueOf(UUID.randomUUID()).replaceAll("-", "");
	String clientId = "39393d5774df78319bb34732444ce65f1ed94dc0b754477a3249e3f23c4c45b5";
	String secretKey = "034390726a8cc244741bfe054dd452b4d42ea8f56361bfe670debdf254bef223";
	
	
	
	
	public interface ChikkaService {
		@FormUrlEncoded
		@POST("https://post.chikka.com/smsapi/request")
		public Call<ResponseBody> send(@Field("message_type") String messageType,
						 @Field("mobile_number") String mobileNumber,
						 @Field("shortcode") String shortCode,
						 @Field("message_id") String messageId,
						 @Field("message") String message,
						 @Field("client_id") String clientId,
						 @Field("secret_key") String secretKey);
	}
	
	public String send(Long id, String mobileNumber, String message) throws IOException {
		
		HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
		interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

		//testing outside the school remove this
		java.net.Proxy proxy = new Proxy(Proxy.Type.HTTP,  new InetSocketAddress("proxy.admu.edu.ph", 3128));

		OkHttpClient client = new OkHttpClient.Builder()
						.proxy(proxy)
						.addInterceptor(interceptor)
						.build();

			
		Retrofit retrofit = new Retrofit.Builder()
				.client(client)
		        .baseUrl("https://localhost:9999")   // even if not using base urls, i.e. all absolute URLs you still need to specify one which will be ignored for absolute URLs
		        .build();
		
		ChikkaService service = retrofit.create(ChikkaService.class);
		
		Call<ResponseBody> call = service.send(messageType, mobileNumber, shortCode, messageId, message, clientId, secretKey);
		
		Response<ResponseBody> reply = call.execute();
		System.out.println(reply.code());
		
		return reply.body().string();
	}
}
