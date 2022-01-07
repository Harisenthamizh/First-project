package com.facebook;



import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.sample.LibGLobal;

public class AdactinHotel extends LibGLobal {
	public static void main(String[] args) throws InterruptedException, IOException {
		LibGLobal b = new LibGLobal();
		b.getChromeDriver();
		b.loadUrl("https://adactinhotelapp.com/");
		b.maximize();
		WebElement txtusername = b.findElementById("username");
	    String data1 = b.getData("Newsheet", 1 , 0);
	    b.sendText(txtusername, data1);
		WebElement password = b.findElementById("password");
	    String data2 = b.getData("Newsheet", 1 , 1 );
	    b.sendText(password, data2);
	    WebElement btn = b.findElementById("login");
	    b.click(btn);
	    WebElement hotelLocation = b.findElementById("location");
	    String data3 = b.getData("Newsheet", 1 , 3);
	    b.selectOptionByText(hotelLocation, data3);
	    WebElement hotel = b.findElementById("hotels");
	    String data4 = b.getData("Newsheet", 1, 2);
	    b.selectOptionByText(hotel, data4);
	    WebElement room = b.findElementById("room_type");
	    String data5 = b.getData("Newsheet", 1, 4);
	    b.sendText(room, data5);
	    WebElement roomNo = b.findElementById("room_nos");
	    String data6 = b.getData("Newsheet", 1, 5);
	    b.sendText(roomNo, data6);
	    WebElement dateIn = b.findElementById("datepick_in");
	    String data7 = b.getData("Newsheet", 1, 6);
	    b.sendText(dateIn, data7);
	    WebElement dateOut = b.findElementById("datepick_out");
	    String data8 = b.getData("Newsheet", 1, 7);
	    b.sendText(dateOut, data8);
	    WebElement adultRoom = b.findElementById("adult_room");
	    String data9 = b.getData("Newsheet", 1, 8);
	    b.sendText(adultRoom, data9);
	    WebElement childRoom = b.findElementById("child_room");
	    String data10 = b.getData("Newsheet", 1, 9);
	    b.sendText(childRoom, data10);
	    WebElement btn1 = b.findElementById("Submit");
	    b.click(btn1);
	    WebElement btn2 = b.findElementById("radiobutton_0");
	    b.click(btn2);
	    WebElement btn3 = b.findElementById("continue");
	    b.click(btn3);
	    WebElement txtFn = b.findElementById("first_name");
	    String data11 = b.getData("Newsheet", 1, 10);
	    b.sendText(txtFn, data11);
	    WebElement txtLn = b.findElementById("last_name");
	    String data12 = b.getData("Newsheet", 1, 11);
	    b.sendText(txtLn, data12);
	    WebElement txtadd = b.findElementById("address");
	    String data13 = b.getData("Newsheet", 1, 12);
	    b.sendText(txtadd, data13);
	    WebElement txtcnum = b.findElementById("cc_num");
	    String data14 = b.getData("Newsheet", 1, 13);
	    b.sendText(txtcnum, data14);
	    WebElement txtCtype = b.findElementById("cc_type");                
	    String data15 = b.getData("Newsheet", 1, 14);
	    b.sendText(txtCtype, data15);
	    WebElement txtCexp = b.findElementById("cc_exp_month");
	    String data16 = b.getData("Newsheet", 1, 15);
	    b.sendText(txtCexp, data16);
	    WebElement txtexpy = b.findElementById("cc_exp_year");
	    String data17 = b.getData("Newsheet", 1, 16);
	    b.sendText(txtexpy, data17);
	    WebElement txtCvv = b.findElementById("cc_cvv");
	    String data18 = b.getData("Newsheet", 1, 17);
	    b.sendText(txtCvv, data18);
	    WebElement btnBookNow = b.findElementById("book_now");
	    b.click(btnBookNow);
	    b.implicitWait();
	    WebElement text = b.findElementByXpath("//input[@id='order_no']");
	    String data = b.getAttribute(text);
	    b.writeData("C:\\Users\\acer\\eclipse-workspace\\Employee\\src\\main\\ExcelSheet\\hari.xlsx", "Newsheet", 1, 18, data);

	    b.closeAllWindow();
}


}
