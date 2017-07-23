package DD_Util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListener implements IRetryAnalyzer
{

   int counter=0;
   int maxRetryCount=3;
   public boolean retry(ITestResult arg0)
   {
    
      if(counter<maxRetryCount){
         counter++;
         return true;
      }
      
      
      return false;
   }

}
