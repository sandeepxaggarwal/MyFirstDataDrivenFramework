package DD_TestCases;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;





import com.relevantcodes.extentreports.LogStatus;

import DD_Core.Page;
import DD_Util.CommonMethods;

public class LoginTest extends Page
{

   @BeforeTest
   public void isSkip()
   {
      if (!CommonMethods.isExecutable("LoginTest"))
      {
         throw new SkipException("Skipping test case as Run Mode is No");
      }
   }

   @Test(dataProvider="getData")
   public void doLogin(String username,String password)
   {
      test = extent.startTest("LoginTest");
      driver.findElement(By.xpath(OR.getProperty("username"))).sendKeys(username);
      driver.findElement(By.xpath(OR.getProperty("password"))).sendKeys(password);
      test.log(LogStatus.PASS, "Login is done successfully");

   }
   
   @AfterMethod
   public void afterMethod(){
      extent.endTest(test);
   }
   
   @DataProvider
   public Object[][] getData(){
     return CommonMethods.getDatafromExcel("LoginTest");
     
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
