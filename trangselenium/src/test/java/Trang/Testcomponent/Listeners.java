package Trang.Testcomponent;

import org.testng.ITestListener;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

import org.testng.ITestContext ;			
import org.testng.ITestResult ;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Trang.resources.ExtentReporterNG;


public class Listeners extends BaseTest implements ITestListener{
	ExtentTest test;// biến để theo dõi 1 bài kiểm tra đơn lẻ trong extent report
	ExtentReports extent = ExtentReporterNG.getReportObject();// đối tượng báo cáo của ExtentReport,
	//được khởi tạo bằng cách gọi phương thức getReportObject() từ lớp  ExtentReporterNG 
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal <ExtentTest>();
	// sử dụng ThreadLocal để đảm bảo mỗi luồng kiểm tra có đối tượng extentreport riêng
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		// khi bắt đầu 1 bài kiểm tra, thì sẽ thực hiện các hành động này
		test =extent.createTest(result.getMethod().getMethodName());
		// tạo 1 bài kiểm tra mới trong báo cáo extentReports với tên phuwong thức kiểm tra
		extentTest.set(test);//unique thread id (errorvalidation test) -> test
		// lưu trữ đối tượng extentTest này trong ThreadLocal
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS,"Test Passed");
		// ghi trạng thái thành công của bài kiểm tra vào bài báo cáo
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
		extentTest.get().fail(result.getThrowable());
		// this line of code will help get driver information
		// ghi lại lỗi của bài kiểm tra vào bài báo cáo
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			// truy cập vào biến driver trong lớp bài kiểm tra hiện tại
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String filePath = null;
		try {
			 filePath = getScreenshot(result.getMethod().getMethodName());
			 // chụp ảnh màn hình
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		//thêm ảnh chụp màn hình vào bài báo cáo
	}
	// lấy đối tượng WebDriver từ lớp bài kiểm tra hiện tại để chụp ảnh màn hình khi bào kiểm tra thất bại

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}


}
