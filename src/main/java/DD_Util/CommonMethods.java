package DD_Util;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import DD_Core.Page;



public class CommonMethods extends Page
{

   public static boolean isExecutable(String tc){
      int rows = excel.getRowCount("TestSuite");
      for(int rowNum=2;rowNum<=rows;rowNum++){
         if(excel.getCellData("TestSuite", "TCName", rowNum).equalsIgnoreCase(tc)){
            if(excel.getCellData("TestSuite", "RunMode", rowNum).equalsIgnoreCase("Y")){
               return true;
            }
         }
         
      }
      return false;
      
   }
   
   
   public static Object[][] getDatafromExcel(String tc){
      
      int rows = excel.getRowCount(tc);
      int cols = excel.getColumnCount(tc);
      Object[][] data = new Object[rows-1][cols];
      for(int rowNum=2;rowNum<=rows;rowNum++){
         for(int colNum=1;colNum<=cols;colNum++){
            data[rowNum-2][colNum-1]=excel.getCellData(tc, colNum, rowNum);
            //System.out.println(data[rowNum-2][cols-1]);
         }
      }
      return data;
   }
   
   public static void captureScreenshot(String methodname) throws IOException{
      String screenshotPath = System.getProperty("user.dir") +"\\Screenshots\\"+methodname+ "_" +getCurrentTime();
      File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(file, new File(screenshotPath));
   }
   
   public static String getCurrentTime(){
      Calendar cal = new GregorianCalendar();
      String year = String.valueOf(cal.get(Calendar.YEAR));
      String month = String.valueOf(cal.get(Calendar.MONTH));
      String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
      String hour = String.valueOf(cal.get(Calendar.HOUR));
      String minute = String.valueOf(cal.get(Calendar.MINUTE));
      String second = String.valueOf(cal.get(Calendar.SECOND));
      
     return year+month+day+hour+minute+second;
      
   }
   
   public static void test(){
      test = extent.startTest("RegisterTest");
   }
   
   
   
   
}
