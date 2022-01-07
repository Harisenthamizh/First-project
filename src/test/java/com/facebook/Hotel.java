package com.facebook;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sample.LibGLobal;

public class Hotel extends LibGLobal {

	static WebDriver driver;

	@BeforeClass
	public static void initialLaunch() throws InterruptedException {
		getChromeDriver();
		loadUrl("https://adactinhotelapp.com/");

	}

	@Test
	public void login() throws IOException {

		sendText(findElementById("username"), getData("Newsheet", 1, 0));

		sendText(findElementById("password"), getData("Newsheet", 1, 1));

		click(findElementById("login"));

		// verify Search Hotel
		String text2 = getText(findElementByXpath("//td[@class='login_title']"));
		Assert.assertEquals("verify Search Hotel", "Search Hotel (Fields marked with Red asterix (*) are mandatory)",
				text2);
		System.out.println(text2);

		selectOptionByText(findElementById("hotels"), getData("Newsheet", 1, 2));

		selectOptionByText(findElementById("location"), getData("Newsheet", 1, 3));

		selectOptionByText(findElementById("room_type"), getData("Newsheet", 1, 4));

		selectOptionByText(findElementById("room_nos"), getData("Newsheet", 1, 5));

		selectOptionByText(findElementById("adult_room"), getData("Newsheet", 1, 8));

		selectOptionByText(findElementByName("child_room"), getData("Newsheet", 1, 9));

		click(findElementById("Submit"));

		// verify select hotel
		String text3 = getText(findElementByXpath("//td[@class='login_title']"));
		Assert.assertEquals("verify select hotel", "Select Hotel", text3);
		System.out.println(text3);

		click(findElementById("radiobutton_0"));

		click(findElementByName("continue"));

		// verify Book hotel
		String text4 = getText(findElementByXpath("(//td[@class='login_title'])[2]"));
		Assert.assertEquals("verify Book hotel", "Book A Hotel", text4);
		System.out.println(text4);

		sendText(findElementById("first_name"), getData("Newsheet", 1, 10));

		sendText(findElementById("last_name"), getData("Newsheet", 1, 11));

		sendText(findElementById("address"), getData("Newsheet", 1, 12));

		sendText(findElementByName("cc_num"), getData("Newsheet", 1, 13));

		selectOptionByText(findElementById("cc_type"), getData("Newsheet", 1, 14));

		selectOptionByText(findElementById("cc_exp_month"), getData("Newsheet", 1, 15));

		selectOptionByValue(findElementById("cc_exp_year"), getData("Newsheet", 1, 16));

		sendText(findElementById("cc_cvv"), getData("Newsheet", 1, 17));

		click(findElementById("book_now"));

		String attribute = getAttribute(findElementByXpath("//input[@id='order_no']"));
		writeData("C:\\Users\\acer\\eclipse-workspace\\Employee\\src\\main\\ExcelSheet\\hari.xlsx", "Newsheet", 1, 18, attribute);

		click(findElementByXpath("//a[text()='Booked Itinerary']"));
		String text5 = getText(findElementByXpath("//td[@class='login_title']"));
		Assert.assertEquals("verify booking confirmation", "Booking Confirmation", text5);
		System.out.println(text5);

		sendText(findElementByXpath("//input[@name='order_id_text']"), getData("Newsheet", 1, 18));

		click(findElementByXpath("//input[@id='search_hotel_id']"));

		click(findElementByXpath("//input[@name='ids[]']"));

		click(findElementByXpath("(//input[contains(@value,'Cancel')])[1]"));

		acceptAlert();

		// verify cancel confirmation
		String text6 = getText(findElementByXpath("//label[contains(@id,'search_result_error')]"));
		Assert.assertEquals("verify cancel confirmation", "The booking has been cancelled.", text6);
		System.out.println(text6);

	}

}
