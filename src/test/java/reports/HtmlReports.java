package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.ispdatabase.framwork.utils.Utilities;
import utils.Utilities;

public class HtmlReports {
    private static ExtentReports reports;
    private static HtmlReports instance;

    private HtmlReports() {
        reports = new ExtentReports();
//        ExtentHtmlReporter reporter = new ExtentHtmlReporter(Utilities.getReportFile());
             reports.attachReporter(new ExtentHtmlReporter(Utilities.getReportFile()));
//        reports.attachReporter(reporter);
    }



//    public static ExtentTest createTest(String testName){
//        if(reports == null){
//            new HtmlReports();
//        }
//        return reports.createTest(testName);
//    }

//    public static void flushReport(){
//        reports.flush();
//    }

    public static ExtentReports getReports(){
        if(instance == null){
            instance = new HtmlReports();
        }
        return instance.reports;
    }

}
