package autotest.thuchanh;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAnnotation {

	@BeforeSuite
    public void beforeSuite() {
        System.out.println("----------@BeforeSuite: Bắt đầu toàn bộ Test Suite-----------");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("----------@AfterSuite: Kết thúc toàn bộ Test Suite-----------");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("----------@BeforeTest: Chuẩn bị chạy <test> trong XML-----------");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("----------@AfterTest: Kết thúc chạy <test> trong XML-----------");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("----------@BeforeClass: Trước khi chạy test trong class-----------");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("----------@AfterClass: Sau khi chạy test trong class-----------");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("----------@BeforeMethod: Trước mỗi test method-----------");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("----------@AfterMethod: Sau mỗi test method-----------");
    }

    @Test
    public void testCase1() {
        System.out.println("----------@Test: Thực thi Test Case 1-----------");
    }

    @Test
    public void testCase2() {
        System.out.println("----------@Test: Thực thi Test Case 2-----------");
    }
}
