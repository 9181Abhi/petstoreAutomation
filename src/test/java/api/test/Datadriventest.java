package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.Userendpoints;
import api.payload.User;
import api.utilities.Dataprovider;
import io.restassured.response.Response;

public class Datadriventest 
{
	@Test(priority=1, dataProvider="Data", dataProviderClass=Dataprovider.class)
	public void testpostuser(String userID, String userName, String fname, String lname, String useremail, String pwd, String ph)
	{
		
		User userPayload= new User();   
		userPayload= new User();
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		
		Response response=Userendpoints.createusers(userPayload);
		Assert.assertEquals(response.getStatusCode(),200);
		
	}
	
	@Test(priority=2, dataProvider="UserNames",dataProviderClass=Dataprovider.class)
	public void testdeleteuserbyName(String userName1)
	{
		Response response=Userendpoints.Deleteuser(userName1);
		Assert.assertEquals(response.getStatusCode(),200);
	}
	

}
