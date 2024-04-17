package TestRunner;
 
import org.junit.runner.RunWith;
 
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
// io.cucumber.testng.CucumberOptions; - to run through testng, change the runner file type into xml
 
@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resource\\Features", // we can just run till features folder
	glue = "StepDefination",// package name for test file
	tags="@Invalid"
//	plugin= {"pretty", 
//			"html:target/HTMLReports/AsianPaintsReport.html",	
//			"json:target/JSONReports/AsianPaintsReport.json",
//			"junit:target/JUNITReports/AsianPaintsReport.xml",
//			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
//			}
)
public class Runner extends AbstractTestNGCucumberTests {
 
}