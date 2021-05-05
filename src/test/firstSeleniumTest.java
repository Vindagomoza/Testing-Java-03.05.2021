package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


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
		String lis = "er";
		String a[] = new String [10];
		System.out.println(lis.length());
		
		for(int i = 1; lis.length() != 0; i++) {
			try {
				lis = driver.findElement(By.xpath("/html/body/div[1]/main/div[1]/div[2]/div/section[2]/div/div[2]/form/div[1]/div/div/ul/li["+i+"]")).getText();
				a[i-1]=lis;
			}catch(Exception e){
				break;
			}
			if(i==6) {
				break;
			}
		};
		File file = new File("error.txt");
		FileWriter fw = new FileWriter(file, true);
		PrintWriter pw = new PrintWriter(fw);
		for(int i = 0; a[i]!=null; i++) {
			System.out.println("gay");
			LocalDateTime date = java.time.LocalDateTime.now();
			a[i] = (a[i] + " ---------- " + date);
			System.out.println(a[i]);
	    	pw.println(a[i]);
		}
		pw.close();
		Thread.sleep(15000);
		driver.quit();
		}
	}