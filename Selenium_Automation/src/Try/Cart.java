package Try;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cart {
	@Test
	public static void Add() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		String url = "https://rahulshettyacademy.com/angularpractice/shop";
		driver.get(url);
		WebElement productNameElement = driver.findElement(By.xpath("//h4[@class='card-title']/a"));
		String productName = productNameElement.getText();
		System.out.println("Product Name: " + productName);
		driver.findElement(By.xpath("//h4[@class='card-title']/a")).click();
		
		
		
		
	}

}
