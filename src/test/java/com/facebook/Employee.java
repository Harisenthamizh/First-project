package com.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Employee {
	public static void main(String[] args) {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.facebook.com/");
		WebElement txtUserName = driver.findElement(By.id("email"));
		txtUserName.sendKeys("Nothing");
		WebElement txtPassword = driver.findElement(By.id("pass"));
		txtPassword.sendKeys("985568");
		
		WebElement btnLogin = driver.findElement(By.name("login"));
		btnLogin.click();
		driver.quit();
	}

}
