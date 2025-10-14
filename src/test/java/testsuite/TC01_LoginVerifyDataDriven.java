package testsuite;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tiu.page_object.ChangePasword;
import com.tiu.test_base.TestBase;

import jxl.read.biff.BiffException;

public class TC01_LoginVerifyDataDriven extends TestBase {
    public static final Logger log = Logger.getLogger(TC01_LoginVerifyDataDriven.class.getName());

    @BeforeMethod
    public void setup(Method result) throws IOException {
        test = extent.startTest(result.getName());
        test.log(LogStatus.INFO, result.getName() + " test Started");
        init();
    }

    @DataProvider(name = "exceldata")
    public String[][] dataprovidefunc() throws BiffException, IOException {
        String[][] obj = getData("KredSafe_Login_Data.xlsx", "Sheet7");
        return obj;
    }

@Test(dataProvider = "exceldata", priority = 1, enabled = true)
public void verifyLoginFunctionality(String username, String password, String errormessage) throws IOException, InterruptedException, AWTException {
        log.info("<===========Started Verifying Login Functionality===========> ");
        openAppUrl();
        ChangePasword cp = new ChangePasword(driver);
        cp.clientSignInn(username, password, errormessage);
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        get_result(result);
    }
}