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

public class RegisterTest extends Page
{

   @BeforeTest
   public void isSkip()
   {
      if (!CommonMethods.isExecutable("RegisterTest"))
      {
         throw new SkipException("Skipping test case as Run Mode is No");
      }
   }

   @Test(dataProvider="getData")
   public void doRegisterTest(String fname,String lname)
   {
      test = extent.startTest("RegisterTest");
      driver.findElement(By.xpath(OR.getProperty("register"))).click();
      driver.findElement(By.xpath(OR.getProperty("fname"))).sendKeys(fname);
      driver.findElement(By.xpath(OR.getProperty("lname"))).sendKeys(lname);
      test.log(LogStatus.PASS, "Filled the Registartion form");
   }
   
   @AfterMethod
   public void afterMethod(){
      extent.endTest(test);
   }
   
   @DataProvider
   public Object[][] getData(){
     return CommonMethods.getDatafromExcel("RegisterTest");
     
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
