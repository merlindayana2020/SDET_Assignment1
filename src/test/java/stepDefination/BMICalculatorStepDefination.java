package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BMICalculatorStepDefination {
	
	WebDriver driver;


@Given("^User is on BMI calculator home page$")
public void user_is_on_BMI_calculator_home_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MerlinR\\Desktop\\Full Stack Tester\\seleniumDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net");
	}

	@Then("^validate Home tittle page$")
	public void validate_Home_tittle_page() {
		String pagetittle = driver.getTitle();
		if(pagetittle.contains("Free Online Calculators")) {
			System.out.println("Page tittle is verified, its "+pagetittle);
		}else {
			System.out.println("Page tittle is invalid, its "+pagetittle);
		}
	}
	
	@Then("^validate BMI calculaor tittle page$")
	public void validate_BMI_calculaor_tittle_page() {
		String pagetittle = driver.getTitle();
		if(pagetittle.equals("BMI Calculator")) {
			System.out.println("Page tittle is verified, its "+pagetittle);
		}else {
			System.out.println("Page tittle is invalid, its "+pagetittle);
		}
	}

	@When("^click on BMI Calculator$")
	public void click_on_BMI_Calculator() {
		driver.findElement(By.xpath("//*[text()='BMI Calculator']")).click();
	}

	@Then("^Enter the age (\\d+)$")
	public void enter_the_age(int arg1) {
		driver.findElement(By.xpath("//td[text()='Age']/..//input")).clear();
		driver.findElement(By.xpath("//td[text()='Age']/..//input")).sendKeys(""+arg1+"");
	}
	
	@Then("^Enter the height (\\d+)$")
	public void enter_the_height(int arg1) {
		driver.findElement(By.xpath("//td[text()='Height']/../td/input")).clear();
		driver.findElement(By.xpath("//td[text()='Height']/../td/input")).sendKeys(""+arg1+"");
	}
	
	@Then("^Enter the weight (\\d+)$")
	public void enter_the_weight(int arg1) {
		driver.findElement(By.xpath("//span[text()='kg']/preceding-sibling::input")).clear();
		driver.findElement(By.xpath("//span[text()='kg']/preceding-sibling::input")).sendKeys(""+arg1+"");
	}
	
	@When("^Tap on Calculate BMI$")
	public void tap_on_Calculate_BMI() {
		driver.findElement(By.xpath("//*[@value='Calculate']")).click();
	}

	@Then("^Capture the BMI Result value and Print it$")
	public void capture_the_BMI_Result_value_and_Print_it() {
		String bmi = driver.findElement(By.xpath("//*[text()='Result']/../div/b")).getText();
		String result = driver.findElement(By.xpath("//*[text()='Result']/../div/font/b")).getText();
		System.out.println(bmi);
		System.out.println("BMI Result is "+result);
	}

	@Given("^close browser$")
	public void close_browser() {
		driver.close();
	}
}
