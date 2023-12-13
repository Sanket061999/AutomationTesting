package checkbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxDemo1 {

	public static void main(String[] args) {
		
		//To select the checkbox of Student

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_114\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		System.out.println(driver.findElement(By.xpath("//input[contains(@id,'StudentDiscount')]")).isSelected());
		driver.findElement(By.xpath("//input[contains(@id,'StudentDiscount')]")).click();
		System.out.println("Student Checkbox is selected");
		System.out.println(driver.findElement(By.xpath("//input[contains(@id,'StudentDiscount')]")).isSelected());

		
		//To count the checkbox present in the page
		System.out.println("Total no. of checkboxes are");
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		
	}

}
