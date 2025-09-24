package api.endpoints;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//Create for perform CRUD
public class Userendpoints2 {

	
	//method create for getting url
	static ResourceBundle getURL()
	{
		ResourceBundle routes=ResourceBundle.getBundle("routes");//load the property file
		return routes;
	}
	
	
	
	
	  public static Response createusers(User payload)
	{
		String post_url=  getURL().getString("post_url");
		  
		  
		 Response response= given()
		  	.contentType(ContentType.JSON)
		  	.accept(ContentType.JSON)
		  	.body(payload)
		  .when()
		  .post(post_url);
		 
		 return response;
	}
	
	  public static Response Readuser(String userName1)
		{
		  String get_url=  getURL().getString("get_url");
			 Response response= given()
			  	.pathParam("username", userName1)
			  .when()
			  .get(get_url);
			 
			 return response;
		}
	  
	  public static Response updateeusers(String userName1,User payload)
		{
		  String update_url=  getURL().getString("update_url");
		  
			 Response response= given()
			  	.contentType(ContentType.JSON)
			  	.accept(ContentType.JSON)
			  	.pathParam("username", userName1)
			  	.body(payload)
			  .when()
			  .put(update_url);
			 
			 return response;
		}
	  
	  public static Response Deleteuser(String userName1)
		{
		  String delete_url=  getURL().getString("delete_url");
			 Response response= given()
			  	.pathParam("username", userName1)
			  .when()
			  .delete(delete_url);
			 
			 return response;
		}
	  
	  
}
