package com.blemall.smokeTest.testcases.login;

import java.io.IOException;
import java.util.Map;
import javax.swing.JOptionPane;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.blemall.smokeTest.page.login.LoginPage;
import com.test.base.TestBase;
import com.test.util.Assertion;
import com.test.util.Log;
import com.test.util.ScreenShot;

public class TestCase_01_Login extends TestBase{
	@Test(dataProvider="providerMethod")
	public void loginBlemall(Map<String,String> param) throws IOException, InterruptedException
	{
		System.out.println("Good Morning,Merry!");
		LoginPage blemall=new LoginPage(driver);
		blemall.loginBlemall(param);

		
	}
	
}
