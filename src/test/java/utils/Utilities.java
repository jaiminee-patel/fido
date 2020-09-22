package utils;

//import com.ispdatabase.framwork.configuration.FramworkConfig;
//import com.ispdatabase.framwork.driverManager.DriverManager;
import configuration.FramworkConfig;
import driverManager.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Utilities {

    private static Map<String, String> testCaseScreenShotMap = new HashMap<>();

    public static String getTimeStamp(){
        SimpleDateFormat dateFormat = new SimpleDateFormat(FramworkConfig.getProperties("dateformate"));
        return dateFormat.format(new Date());
    }

    private static  String generateScreenshotFileName (String testName){
        String fileName = testName+"_"+getTimeStamp()+".png";
        return fileName;
    }


    private static void createDirs(String type){
      Path shotPassPath = Paths.get(FramworkConfig.getProperties("screenshot.pass.dir"));
      Path shotFailPath = Paths.get(FramworkConfig.getProperties("screenshot.fail.dir"));
      Path reportPath = Paths.get(FramworkConfig.getProperties("report.dir"));

          try {
              if(type.equals("screenshot")){
                  Files.createDirectories(shotPassPath);
                  Files.createDirectories(shotFailPath);
              }
              if(type.equals("report")){
                  Files.createDirectories(reportPath);
              }
          } catch (IOException e) {
              e.printStackTrace();
          }
    }

    public static String captureScreenShot(String testName, CaptureType type){
        createDirs("screenshot");
        String filename = generateScreenshotFileName(testName);
        WebDriver driver = DriverManager.getDriverInstance();

        File captureShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Path path;
        if(type==CaptureType.PASS) {
            path = Paths.get(FramworkConfig.getProperties("screenshot.pass.dir"), filename);
        }
        else {
            path = Paths.get(FramworkConfig.getProperties("screenshot.fail.dir"), filename);
        }
            try {
                Files.copy(captureShotFile.toPath(),path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        testCaseScreenShotMap.put(testName, path.toString());
        return path.toString();
        }


        public static File getReportFile(){
            createDirs("report");
            String fileName =FramworkConfig.getProperties("report.filename")+"_"+getTimeStamp()+".html";
            Path path = Paths.get(FramworkConfig.getProperties("report.dir"), fileName);
            return path.toFile();
        }
}
