package api.endpoints;
import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//Create for perform CRUD
public class Userendpoints {

	  public static Response createusers(User payload)
	{
		 Response response= given()
		  	.contentType(ContentType.JSON)
		  	.accept(ContentType.JSON)
		  	.body(payload)
		  .when()
		  .post(Routes.post_url);
		 
		 return response;
	}
	
	  public static Response Readuser(String userName1)
		{
			 Response response= given()
			  	.pathParam("username", userName1)
			  .when()
			  .get(Routes.get_url);
			 
			 return response;
		}
	  
	  public static Response updateeusers(String userName1,User payload)
		{
			 Response response= given()
			  	.contentType(ContentType.JSON)
			  	.accept(ContentType.JSON)
			  	.pathParam("username", userName1)
			  	.body(payload)
			  .when()
			  .put(Routes.update_url);
			 
			 return response;
		}
	  
	  public static Response Deleteuser(String userName1)
		{
			 Response response= given()
			  	.pathParam("username", userName1)
			  .when()
			  .delete(Routes.delete_url);
			 
			 return response;
		}
	  
	  
}
