package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import java.time.LocalDateTime;
 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class firstSeleniumTest {
	
	public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException {
		System.setProperty("webdriver.chrome.driver", "C://Users//loopo//Desktop//demoProjects//chromedriver_win32//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String var1 = "Le champ Nom de famille est requis.";
		String var2 = "Le champ Mot de passe est requis.";
		File file = new File("error.txt");
		FileWriter fw = new FileWriter(file, true);
		PrintWriter pw = new PrintWriter(fw);

		driver.manage().window().maximize();
		driver.get("https://prelive.aptimea.com/form/questionnaire?current=/node/96");
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id=\"popup-buttons\"]/button[1]")).click();
		Thread.sleep(500); 
		driver.findElement(By.id("edit-je-suis-0")).click();
		Thread.sleep(500);
		driver.findElement(By.id("edit-je-suis-ne-e-en-annee-year")).sendKeys("1990");
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,800)");
		driver.findElement(By.id("edit-je-fais-du-sport-chaque-semaine-2")).click();
		Thread.sleep(500);
		driver.findElement(By.id("edit-je-suis-2-1")).click();
		Thread.sleep(500);
		driver.findElement(By.id("edit-mes-traitements-medicaux-sont")).sendKeys("test");
		Thread.sleep(500);
		driver.findElement(By.id("edit-user-weight")).sendKeys("70");
		Thread.sleep(500);
		driver.findElement(By.id("edit-user-height")).sendKeys("180");
		Thread.sleep(500);
		driver.findElement(By.id("edit-je-vis-1")).click();
		Thread.sleep(500);
		driver.findElement(By.id("edit-j-ai-enfants-nombre-")).sendKeys("10");
		Thread.sleep(500);
		driver.findElement(By.id("edit-patient-goals-41")).click();
		Thread.sleep(500);
		driver.findElement(By.id("edit-email")).sendKeys("testtesttest@test.test");
		Thread.sleep(500);
		WebElement element = driver.findElement(By.id("edit-wizard-next"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		driver.findElement(By.id("edit-first-name")).sendKeys("Test");
		driver.findElement(By.id("edit-wizard-next")).click();
		Thread.sleep(1000);
		List<WebElement> allLi = driver.findElements(By.tagName("li"));
		for(WebElement eachLi:allLi){
		    String tmp = eachLi.getText();
		    if(tmp.contains(var1)){
		    	LocalDateTime date1 = java.time.LocalDateTime.now();
		    	String strDate1 = (tmp + " ---------- " + date1);		    	System.out.println(strDate1);
		    	pw.println(strDate1);
		    }else if (tmp.contains(var2)) {
		    	LocalDateTime date2 = java.time.LocalDateTime.now();
		    	String strDate2 = (tmp + " ---------- " + date2);
		    	System.out.println(strDate2);
				pw.println(strDate2);
		    }
	}
		pw.close();
		}
		}