

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static WebDriver driver ;
	
	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	public static  void windowMaximize() {
		driver.manage().window().maximize();

	}
	public static void launchUrl(String Url) {
		driver.get(Url);
	}
	public static String pageTile() {
		String title = driver.getTitle();
		return title;
	}
	public static String pageUrl() {
		String Url = driver.getCurrentUrl();
		return Url;

	}
	public static void passTxt(String txt,WebElement ele) {
		ele.sendKeys(txt);
	}
	public static void closeEntireBrowser() {
		driver.quit();
	}
	public static void clickBtn(WebElement ele) {
		ele.click();
	}
	public static void screenShot(String imgName) throws IOException {
		TakesScreenshot ts =(TakesScreenshot)driver; 
		File img = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("locxation+imgName");
		FileUtils.copyFile(img, f);
	}
	public static Actions a ;
	
	public static void moveTheCursor(WebElement targetWebElement) {
		
		a = new Actions (driver);
		a.moveToElement(targetWebElement).perform();	
	}
	public static void dragdrop(WebElement dragElement,WebElement dropElement) {
		a = new Actions (driver);
		a.dragAndDrop(dragElement, dropElement);

	}
	public static JavascriptExecutor js ;
	public static void scrollThePage(WebElement tarWebEle) {
		js.executeScript("arguments[0].scrollIntoView(true)",tarWebEle);

	}
	public static void scroll(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(false)",element);
	}
	public static void excelRead(String sheetName,int rowNum,int cellNum) throws IOException {
		File f = new File("excelLocation.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("datas");
		Row r = sheet.getRow(rowNum);
		Cell c = r.getCell(cellNum);
		int cellType = c.getCellType();
		
		String value ="";
		if (cellType==1) {
			String stringCellValue = c.getStringCellValue();
			
		}
		else if (DateUtil.isCellDateFormatted(c)) {
			Date dd = c.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat();
			String format = s.format(dd);
		}
		else {
			double d = c.getNumericCellValue();
			long l = (long)d;
			String valueOf = String.valueOf(l);
			
		}
		

		
	}
	public static void creatNewExcel(int newrow,int newcell,String WritData) throws IOException {
		File f = new File("C:\\Users\\ganes\\eclipse-workspace\\mavenBaseclass\\Excel\\newFile.xlsx");
		Workbook wb = new XSSFWorkbook();
		Sheet newsheet = wb.createSheet("datas");
		Row r = newsheet.createRow(newrow);
		Cell c = r.createCell(newcell);
		c.setCellValue(WritData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	   
	}
	public static void creatCell(int getrow,int crecell,String newData) throws IOException {
		File f  = new File("C:\\Users\\ganes\\eclipse-workspace\\mavenBaseclass\\Excel\\newFile.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("datas");
		Row r = sheet.getRow(getrow);
		Cell c = r.createCell(crecell);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);

	}
	public static void creatrow(int creRow,int creCell,String newData) throws IOException {
		File f = new File("C:\\Users\\ganes\\eclipse-workspace\\mavenBaseclass\\Excel\\newFile.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fis);
		Sheet sheet = w.getSheet("datas");
		Row r = sheet.createRow(creRow);
		Cell c = r.createCell(creCell);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
		

	}
	public static void updateParticularCell(int getTheRow,int GetTheCell,String existingData,String newData) throws IOException {
		File f =new File("C:\\Users\\ganes\\eclipse-workspace\\mavenBaseclass\\Excel\\newFile.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fis);
		Sheet s = w.getSheet("datas");
		Row r = s.getRow(getTheRow);
		Cell c = r.getCell(GetTheCell);
		String str = c.getStringCellValue();
		if (str.equals(existingData)) {
			c.setCellValue(newData);
			
		}
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
		

	}
}
