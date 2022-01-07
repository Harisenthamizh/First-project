package org.sample;

	import java.awt.AWTException;
	import java.awt.Robot;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.List;
	import java.util.concurrent.TimeUnit;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.DateUtil;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;

	import io.github.bonigarcia.wdm.WebDriverManager;



	public class LibGLobal {
		
		static WebDriver driver ;
		Actions a;
		Robot r;
		JavascriptExecutor js;
		 Select select;
		 Alert alert;
		
		
		public  static void getChromeDriver() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			}
		public void getFirefoxDriver(String path) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			}
		public static void loadUrl(String url) {
			driver.get(url);
	        }
		public static String getCurrentUrl() {
			String url = driver.getCurrentUrl();
			return url;
			}
		public String getTitle() {
			String title = driver.getTitle();
			return title;
			}
		public static  void maximize() {
			driver.manage().window().maximize();
	        }
		public WebElement findElementById(String id) {
			WebElement element = driver.findElement(By.id(id));
			return element;
	        }
		public WebElement findElementByName(String name) {
			WebElement element = driver.findElement(By.name(name));
			return element;
	        }
		public WebElement findElementByClassName(String className) {
			WebElement element = driver.findElement(By.className(className));
			return element;
	        }
		public WebElement findElementByXpath(String xpath) {
			WebElement element = driver.findElement(By.xpath(xpath));
			return element;
	        }
		public String getText(WebElement element) {
	        String text = element.getText();
			return text;
			}
		public String getAttribute(WebElement element) {
	        String attribute2 = element.getAttribute("value");
			return attribute2;
			}
		public void click(WebElement element) {
	        element.click();
			}
		public void sendText(WebElement element,String data) {
			  element.sendKeys(data);
			}
		public void acceptAlert() {
			 driver.switchTo().alert().accept();
			 }
		public void disMissAlert() {
			driver.switchTo().alert().dismiss();
			}
		public String getAlertText() {
			String text = driver.switchTo().alert().getText();
			return text;
	        }
		public void switchToFrameById(String id) {
			 driver.switchTo().frame(id);
	        }
		public void switchToFrameByIndex(int index) {
			 driver.switchTo().frame(index);
	       }
		public void switchToFrameByElement(WebElement element) {
			 driver.switchTo().frame(element);
	       }
		public void switchToWindowById(String id) {
			 driver.switchTo().window(id);
	       }
		public List<WebElement> getAllOptions(WebElement element) {
	        List<WebElement> list =new Select(element).getOptions();
			return list;
	       }
		public List<WebElement> getAllSelectedOptions(WebElement element) {
	        List<WebElement> list =new Select(element).getAllSelectedOptions();
			return list;
	       }
		public WebElement getFirstSelectOptions(WebElement element) {
	        WebElement list =new Select(element).getFirstSelectedOption();
			return list;
	       }
		public void selectOptionByText(WebElement element,String text) {
			new Select(element).selectByVisibleText(text);
	       }
		public void selectOptionByValue(WebElement element,String text) {
			new Select(element).selectByValue(text);
	       }
		public void selectOptionByIndex(WebElement element,int index) {
			new Select(element).selectByIndex(index);
	       }
		public void deSelectOptionByText(WebElement element,String text) {
			new Select(element).deselectByVisibleText(text);
	       }
		public void deSelectOptionByValue(WebElement element,String text) {
			new Select(element).deselectByValue(text);
	       }
		public void deSelectOptionByIndex(WebElement element,int index) {
			new Select(element).deselectByIndex(index);
	       }
		public void actionsEnterKeyPress() {
			a = new Actions(driver);
		    a.sendKeys(Keys.ENTER);
	     	}
		public void dragAndDrop(WebElement src,WebElement dest) {
	        a = new Actions(driver);
	        a.dragAndDrop(src, dest).perform();;
	        }
		public void doubleClick(WebElement element) {
			a = new Actions(driver);
			a.doubleClick(element);
	        }
		public void contextClick(WebElement element) {
			a = new Actions(driver);
			a.moveToElement(element).contextClick();
	       }
		public void moveMouse(int a,int b) throws AWTException {
	       r = new Robot();
	       r.mouseMove(a, b);
	       }
		public void mouseClick(int btn) throws AWTException {
			r = new Robot();
			r.mousePress(btn);
			r.mousePress(btn);
			}
		public void keyPress(int key) throws AWTException {
			r = new Robot();
			r.mousePress(key);
			r.mousePress(key);
			}
		public void sequenceKeyPress(int key1,int key2) {
			r.keyPress(key1);
			r.keyPress(key2);
			r.keyRelease(key2);
			r.keyRelease(key1);
			}
	    public void mouseOverElement(WebElement element) {
			a = new Actions(driver);
			a.moveToElement(element);
	    }
	    public void clickElementByJs(WebElement element) {
			js = (JavascriptExecutor)driver;
	        js.executeScript("arguments[0].click()", element);
	        }
	    public void sendToAlertPrompt(String data) {
			 driver.switchTo().alert().sendKeys(data);
			 driver.switchTo().alert().accept();
	    	}
	    public String getData(String sheetName, int rowNo, int cellNo) throws IOException {
			String data = null;
			
			File file = new File("C:\\Users\\acer\\eclipse-workspace\\Employee\\src\\main\\ExcelSheet\\hari.xlsx");
			FileInputStream stream = new FileInputStream(file);
			Workbook workbook =new XSSFWorkbook (stream);
			
			Sheet sheet = workbook.getSheet(sheetName);
			
			Row row = sheet.getRow(rowNo);
			
			Cell cell = row.getCell(cellNo);
			
			int cellType = cell.getCellType();
			
			if (cellType==1) {
				data=cell.getStringCellValue();	
			}
			if (cellType==0) {
				if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yy");
					 data = dateformat.format(dateCellValue);
				}
			
			else {
				double d = cell.getNumericCellValue();
				long l = (long) d;
				 data = String.valueOf(l);
			}		
			}
			return data;
		}
	    
	    public void writeData(String path,String sheet, int row, int cell,String data) throws IOException {
	    	File file = new File(path);
	    	FileInputStream stream = new FileInputStream(file);
			Workbook workbook =new XSSFWorkbook(stream);
			Sheet sheet2 = workbook.getSheet(sheet);
			Row row2 = sheet2.getRow(row);
			Cell createCell = row2.createCell(cell);
			createCell.setCellValue(data);
			
			FileOutputStream out = new FileOutputStream(file);
			workbook.write(out);

		}
		public void updateData(String path,String sheet, int row, int cell,String data) throws IOException {
			FileInputStream stream = new FileInputStream(new File(path));
			Workbook workbook = new XSSFWorkbook(stream);
			Sheet sheet2 = workbook.getSheet(sheet);
			Row row2 = sheet2.getRow(row);
			Cell cell2 = row2.getCell(cell);
			cell2.setCellValue(data);
			

		}
		public void currentWindow() {
			driver.close();
	     }
		public static void closeAllWindow() {
			driver.quit();

		}
		
		public void createExcelSheet(String xpath,int row,int cell,String data) throws IOException {
			File file = new File(xpath);
			Workbook workbook = new XSSFWorkbook();
			Sheet sheet = workbook.createSheet();
			Row createRow = sheet.createRow(row);
			Cell createCell = createRow.createCell(cell);
			createCell.setCellValue(data);
			FileOutputStream out = new FileOutputStream(file);
			workbook.write(out);
			

		}
		
		
		
		public void implicitWait() {
	          driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS)  ;

		}			
}
	