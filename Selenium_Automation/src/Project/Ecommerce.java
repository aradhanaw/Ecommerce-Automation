package Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Ecommerce {
	@Test(priority= 1)
	public static void Login() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		String url = "https://rahulshettyacademy.com/loginpagePractise/";
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//span[@class='checkmark']")).click();
		
		Select role = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		role.selectByVisibleText("Teacher");
		
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.xpath("//input[@name='signin']")).click();
		
		WebDriverWait objj = new WebDriverWait(driver, Duration.ofSeconds(10));
		//to verify that user has been successfully login to the system
		objj.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Shop Name')]")));
		
	}
	@Test(priority = 2)
	public static void AddToCart() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		String url = "https://rahulshettyacademy.com/angularpractice/shop";
		driver.get(url);
		//add 1st item
		driver.findElement(By.xpath("//body/app-root[1]/app-shop[1]/div[1]/div[1]/div[2]/app-card-list[1]/app-card[1]/div[1]/div[2]/button[1]")).click();
		//add 2nd item
		driver.findElement(By.xpath("//body/app-root[1]/app-shop[1]/div[1]/div[1]/div[2]/app-card-list[1]/app-card[2]/div[1]/div[2]/button[1]")).click();
		//For clicking check out
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
		//To delete
		driver.findElement(By.xpath("//tbody/tr[2]/td[5]/button[1]")).click();		
		//For Checkout
		driver.findElement(By.xpath("//tbody/tr[3]/td[5]/button[1]")).click();	
		//to enter the location
		driver.findElement(By.id("country")).sendKeys("Kathmandu");
		driver.findElement(By.xpath("//body/app-root[1]/app-shop[1]/div[1]/app-checkout[1]/div[1]/div[2]/label[1]")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		WebDriverWait purchase = new WebDriverWait(driver, Duration.ofSeconds(12));
		//to make sure that order has been placed successfully or not.
		purchase.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[contains(text(),'Success!')]")));
		
		
		
		
	}

}
