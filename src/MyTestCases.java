import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {
	WebDriver  driver =new ChromeDriver();
	
	String URL="https://www.saucedemo.com/";
	
	String userName="standard_user";
	
	String password="secret_sauce";
	
	@BeforeTest()
	public void setUp() {
		
		
		driver.get(URL);
		
		
	}
	//Test case to login with correct userName and Password 
	@Test (priority=1)
	public void loginTest() {
		
		WebElement userNameInput =driver.findElement(By.id("user-name"));
		userNameInput.sendKeys(userName);
		 
		WebElement passwordInput =driver.findElement(By.id("password"));
		passwordInput.sendKeys(password);
		
		WebElement loginButton =driver.findElement(By.id("login-button"));
		loginButton.click(); 
		
		
	}
	//Test case to add all items 
	@Test(priority =2)
	public void addAllItems() {
		
		List <WebElement> addToCartButton=driver.findElements(By.className("btn"));
		
		
		for (int i=0;i<addToCartButton.size();i++) {
			
		addToCartButton.get(i).click();
			
			
		}
		
	}
	//Test case to add one item and skip the next 
	@Test(priority =3)
	public void addOneItemAndSkipTheNext(){
		List <WebElement> addToCartButtons=driver.findElements(By.className("btn"));
		for (int i=0;i<addToCartButtons.size() ;i+=2) {
			
			addToCartButtons.get(i).click();
			
		}
		
		
	}
	//Test case to add items that contains Labs word
	@Test(priority =4)
	public void findAllElementsThatHasTextLabs() {
		
		List <WebElement> nameOfItems=driver.findElements(By.className("inventory_item_name"));
		List <WebElement> addToCartButtons=driver.findElements(By.className("btn"));
		
	
		for (int i=0;i<addToCartButtons.size();i++) {
		String itemNames =nameOfItems.get(i).getText();
		if (itemNames.contains("Labs")) {
			
			addToCartButtons.get(i).click();
			
		}
		   }

	}
	
	
	//Test case to add items price > $15
	@Test(priority=5)
	public void addItemsIfPricGraterThanFifteen() {
	
	List <WebElement> itemPrice = driver.findElements(By.className("inventory_item_price"));
	List<WebElement>  myAddToCartButtons=driver.findElements(By.className("btn"));
	
	for (int i=0;i<itemPrice.size();i++) {
	String  priceText=itemPrice.get(i).getText().replace("$", " ");	
	double price= Double.parseDouble(priceText);
		if (price >15)
		{
			myAddToCartButtons.get(i).click();
			
		}
		
	}
	
	
	
	
	
	}
	
}