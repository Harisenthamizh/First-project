package com.facebook;


	import java.util.concurrent.TimeUnit;

	import org.junit.After;
	import org.junit.AfterClass;
	import org.junit.Before;
	import org.junit.BeforeClass;
	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class Junit {
		static WebDriver driver;

		@BeforeClass
		public static void set() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("http://greenscart.in/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}

		@AfterClass
		public static void afterClass() {
			//driver.quit();
		}

		@Before
		public void beforeMethod() {
			long s = System.currentTimeMillis();
			System.out.println(s);
		}

		@After
		public void afterMethod() {
			long e = System.currentTimeMillis();
			System.out.println(e);
		}

		@Test
		public void logic() {
			WebElement txtUser = driver.findElement(By.id("loginEmailId"));
			txtUser.sendKeys("Hari");
			WebElement txtPassword = driver.findElement(By.id("loginPassword"));
			txtPassword.sendKeys("Hari@123");
			WebElement btnLogin = driver.findElement(By.className("btnRegister form-control"));
			btnLogin.click();

		}
	}

