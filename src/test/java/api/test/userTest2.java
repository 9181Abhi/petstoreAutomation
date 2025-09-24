package api.test;




import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.Userendpoints;
import api.endpoints.Userendpoints2;
import api.payload.User;
import io.restassured.response.Response;

public class userTest2 {
	Faker faker;
	User userPayload;
	
	public Logger logger;
	@BeforeClass
	public void setup()
	{
		faker=new Faker();
		userPayload= new User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
	//Need //	logger=LogManager.getLogger(this.getClass());
	}
	
	@Test(priority=1)
	public void testPostUser()
	{
		
		Response response=Userendpoints2.createusers(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		
	}
	
	@Test(priority=2)
	public void testgetuserbyname()
	{
		Response response=Userendpoints2.Readuser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		
	}
	
	@Test(priority=3)
	public void testUpdateuserbyname()
	{
		//update data using payload
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		
		Response response=Userendpoints2.updateeusers(this.userPayload.getUsername(),userPayload);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(),200);
		//checking data after update
		
		Response responseafterupdate=Userendpoints2.Readuser(this.userPayload.getUsername());
		Assert.assertEquals(responseafterupdate.getStatusCode(),200);
		
	}
	
	
	@Test(priority=4)
	public void testdeleteuserbyusername()
	{
		Response response=Userendpoints2.Deleteuser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(),200);
		
	}
	
	
	
	
	
	

}
