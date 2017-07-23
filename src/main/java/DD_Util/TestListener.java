package DD_Util;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import DD_Core.Page;

public class TestListener extends Page implements ITestListener
{

   public void onFinish(ITestContext arg0)
   {
      // TODO Auto-generated method stub
      
   }

   public void onStart(ITestContext arg0)
   {
      // TODO Auto-generated method stub
      
   }

   public void onTestFailedButWithinSuccessPercentage(ITestResult arg0)
   {
      // TODO Auto-generated method stub
      
   }

   public void onTestFailure(ITestResult arg0)
   {
      String methodname = arg0.getName();
      try
      {
         CommonMethods.captureScreenshot(methodname);
      }
      catch (IOException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
   }

   public void onTestSkipped(ITestResult arg0)
   {
      // TODO Auto-generated method stub
      
   }

   public void onTestStart(ITestResult arg0)
   {
      // TODO Auto-generated method stub
      
   }

   public void onTestSuccess(ITestResult arg0)
   {
      // TODO Auto-generated method stub
      
   }

   
}
