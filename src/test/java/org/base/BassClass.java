package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BassClass {
	public static WebDriver driver;
	private WebElement findElement;

	// to configure the web browser

	public static void getDriver(String browserType, String url) {
		switch (browserType) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			break;

		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(url);

			break;

		default:
			System.out.println("None");

			break;
		}
	}

	// Inspection

	public static WebElement locaterId(String id) {
		WebElement findElement = driver.findElement(By.id(id));
		return findElement;
	}

	public static WebElement locaterName(String name) {
		WebElement findElement = driver.findElement(By.name(name));
		return findElement;
	}

	public static WebElement locaterXpath(String xpath) {
		WebElement findElement = driver.findElement(By.xpath(xpath));
		return findElement;
	}

	public static void buttonClick(WebElement findElement) {
		findElement.click();
	}

	public static void textSend(WebElement findElement, String keysToSend) {
		findElement.sendKeys(keysToSend);
	}

	// SendText
	public static void enterText(WebElement element, String keysToSend) {
		element.sendKeys(keysToSend);
	}

	// ClickButton
	public void buttonclick(WebElement element) {

		element.click();
	}

	// Select == byIndex
	public static void byIndex(WebElement element, int index) {

		Select s = new Select(element);
		s.selectByIndex(index);
	}

	// Select == byValue
	public static void byValue(WebElement element, String value) {

		Select s1 = new Select(element);
		s1.selectByValue(value);
	}

	// Select == byText
	public static void byText(WebElement element, String text) {

		Select s2 = new Select(element);
		s2.selectByVisibleText(text);
	}
	// ReadDataFromExcel

	public static String readTheExcelDatas(int rowNumber, int cellNumber) {

		try {
			File file = new File(
					"C:\\Users\\Uday\\eclipse-workspace\\ProjectAdactin\\src\\test\\java\\org\\base\\BassClass.java");

			FileInputStream stream = new FileInputStream(file);

			Workbook book = new XSSFWorkbook(stream);

			Sheet sheet = book.getSheet("Sheet1");

			Row row = sheet.getRow(rowNumber);

			Cell cell = row.getCell(cellNumber);

			CellType cellType = cell.getCellType();

			String value = null;
			switch (cellType) {
			case STRING:
				value = cell.getStringCellValue();
				break;

			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat format = new SimpleDateFormat("dd//MM/yyyy");
					value = format.format(dateCellValue);

				} else {
					double numericCellValue = cell.getNumericCellValue();

					long l = (long) numericCellValue; // type casting
					BigDecimal valueOf = BigDecimal.valueOf(l);
					value = valueOf.toString();

				}
				break;

			default:
				System.out.println("None");
				break;
			}

			return value;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Data Provider

	@DataProvider(name = "LoginDatas")
	private Object[][] getData() {

		return new Object[][] { { readTheExcelDatas(1, 0), readTheExcelDatas(1, 1) },
				{ readTheExcelDatas(2, 0), readTheExcelDatas(2, 1) },
				{ readTheExcelDatas(3, 0), readTheExcelDatas(3, 1) },
				{ readTheExcelDatas(4, 0), readTheExcelDatas(4, 1) },

		};
	}

	// To Take screen shot
	public void screenShot(String screenShotName) {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File sourceFile = ts.getScreenshotAs(OutputType.FILE);
			File targetFile = new File("F:\\Java\\screenshot" + screenShotName + ".jpeg");
			FileUtils.copyFile(sourceFile, targetFile);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
