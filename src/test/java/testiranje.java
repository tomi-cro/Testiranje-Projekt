import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class testiranje {
    public WebDriver driver;
    public String testURL = "https://www.eurowings.com";
    //-----------------------------------Test Setup-----------------------------------
    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "H:/testiranje/chromedriver.exe");
        //Create a new ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(testURL);
    }
    @Test
    public void homepageTitle() throws InterruptedException {
        String expectedTitle = "Eurowings - book cheap flights";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test
    public void bookFlights() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement  element1 = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Discover'])[1]/following::span[2]"));
        actions.moveToElement(element1).click().perform();
        Thread.sleep(1000);
        WebElement  element2 = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Flights'])[1]/following::span[3]"));
        actions.moveToElement(element2).click().perform();
        Thread.sleep(1000);
        String expectedTitle = "Book flights";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
    @Test
    public void checkIn() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement  element1 = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My trip'])[1]/following::span[2]"));
        actions.moveToElement(element1).click().perform();
        Thread.sleep(1000);
        String expectedTitle = "Check-in";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
    @Test
    public void flightSchedule() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement  element1 = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Book'])[1]/following::span[2]"));
        actions.moveToElement(element1).click().perform();
        Thread.sleep(2000);
        WebElement  element2 = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Routes and destinations'])[1]/following::span[3]"));
        actions.moveToElement(element2).click().perform();
        Thread.sleep(3000);
        driver.findElement(By.id("originName-1050751489")).click();
        driver.findElement(By.id("originName-1050751489")).clear();
        driver.findElement(By.id("originName-1050751489")).sendKeys("Osijek");
        driver.findElement(By.id("destinationName924288213")).clear();
        driver.findElement(By.id("destinationName924288213")).sendKeys("Munich");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Show ###targetMonth###'])[1]/following::button[1]")).click();
        String expectedTitle = "flight schedule";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
    @Test
    public void flyToOsijek() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement  element1 = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Primärnavigation'])[1]/following::span[1]"));
        actions.moveToElement(element1).click().perform();
        Thread.sleep(1000);
        WebElement  element2 = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Destinations'])[1]/following::span[3]"));
        actions.moveToElement(element2).click().perform();
        Thread.sleep(1000);
        WebElement  element3 = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Destinations'])[1]/following::span[3]"));
        actions.moveToElement(element3).click().perform();
        Thread.sleep(1000);
        WebElement  element4 = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Airports in Croatia'])[1]/following::ul[1]"));
        actions.moveToElement(element4).click().perform();
        Thread.sleep(1000);
        WebElement  element5 = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Dubrovnik (DBV)'])[1]/following::span[1]"));
        actions.moveToElement(element5).click().perform();
        Thread.sleep(1000);
        String expectedTitle = "Flight to Osijek";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    //-----------------------------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest() {
        //Close browser and end the session
        driver.quit();
    }

}
