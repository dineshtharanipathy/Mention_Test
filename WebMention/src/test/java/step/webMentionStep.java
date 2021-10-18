package step;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class webMentionStep {
	
	public static RemoteWebDriver driver;
	WebDriverWait wait;
	
	@Given("User Opens webMention url")
	public void user_opens_web_mention_url() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.manage().window().maximize();
		
		driver.get("https://web.mention.com/");
	}

	@Given("User Enters UserName")
	public void user_enters_user_name() {
		driver.findElementByXPath("//input[@name='username']").sendKeys("ci-test@mention.com");
	}

	@Given("User Enters Password")
	public void user_enters_password() {
		driver.findElementByXPath("//input[@name='password']").sendKeys("nqkNtTxdgKhJ");
	}

	@Given("User Click ConnectNow button")
	public void user_click_connect_now_button() {
		driver.findElementByXPath("//input[@type='submit']").click();
	}

	@Then("User verifies the site loaded completely")
	public void user_verifies_the_site_loaded_completely() throws InterruptedException {
		wait =new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='mnt-SortableList-element']//h4")));
	}

	@Then("User verifies an alert named Lenovo Thinkpad")
	public void user_verifies_an_alert_named_lenovo_thinkpad() {
Assert.assertTrue(driver.findElementByXPath("//div[@class='mnt-SortableList-element']//h4").isDisplayed());
		
		
	}

	@Then("User see a mention with content SB10F46467 Fit for:Lenovo Thinkpad")
	public void user_see_a_mention_with_content_sb10f46467_fit_for_lenovo_thinkpad() throws InterruptedException {
		Thread.sleep(5000);
		String text = driver.findElementByTagName("body").getText();
		Assert.assertTrue(text.contains("SB10F46467 Fit for:Lenovo Thinkpad"));
		
	}

	@Given("User enter the keyword ifixit T520i in search field")
	public void user_enter_the_keyword_ifixit_t520i_in_search_field() {
		driver.findElementByXPath("//input[@placeholder='Search in alert history']").sendKeys("ifixit T520i");
		driver.findElementByXPath("//input[@placeholder='Search in alert history']").sendKeys(Keys.ENTER);
		
	
	}

	@Then("User see a mention with keyword Lenovo thinkpad T520i")
	public void user_see_a_mention_with_keyword_lenovo_thinkpad_t520i() throws InterruptedException {
		wait =new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='mnt-FeedMention unread-mention is-clickable'])[1]")));
		Assert.assertTrue(driver.findElementByTagName("body").getText().contains("Lenovo thinkpad T520i"));
	}

}
