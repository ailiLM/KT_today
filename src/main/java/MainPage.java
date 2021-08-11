
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class MainPage {
    String mainURL="https://romanceabroad.com/";
    String currentURLSearch;
    String expectedURL="https://romanceabroad.com/users/search";
    String currentURLPhotos;
    String expectedURLPhotos="https://romanceabroad.com/media/index";
    String currentURLHowItWorks;
    String expectedURLHowItWorks= "https://romanceabroad.com/content/view/how-it-works";
    By LINK_PRETTY_WOMEN_SEARCH = By.xpath("//a[@href='https://romanceabroad.com/users/search']");
    By LINK_PHOTOS = By.xpath("//a[@href='https://romanceabroad.com/media/index']");
    By LINK_HOW_IT_WORKS = By.xpath("//a[@href='https://romanceabroad.com/content/view/how-it-works']");
    By LINK_JOIN_FOR_FREE = By.cssSelector("#show-registration-block");
    By PAGE_GET_STARTED_ON_SIGNIN = By.xpath("//*[@id=\"second-registration-page\"]/div/div[2]");

    WebDriver driver;

    @BeforeMethod
    public void setUP(){
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(mainURL);
    }


    @Test
    public void testSearchPage() {

driver.findElement(LINK_PRETTY_WOMEN_SEARCH).click();
currentURLSearch=driver.getCurrentUrl();
        System.out.println(currentURLSearch);
        Assert.assertEquals(currentURLSearch,expectedURL);

    }
    @Test
    public void testPhotosPage(){
        driver.findElement(LINK_PHOTOS).click();
        currentURLPhotos= driver.getCurrentUrl();
        Assert.assertEquals(currentURLPhotos,expectedURLPhotos);
    }

    @Test
    public  void testHowItWorksPage(){
        driver.findElement(LINK_HOW_IT_WORKS).click();
        currentURLHowItWorks = driver.getCurrentUrl();
        Assert.assertEquals(currentURLHowItWorks,expectedURLHowItWorks);
    }

    @Test
    public void testSignIn(){
        driver.findElement(LINK_JOIN_FOR_FREE).click();
        if (
                driver.findElement(PAGE_GET_STARTED_ON_SIGNIN).isDisplayed())
        {
            driver.findElement(By.cssSelector("#email")).sendKeys("test123@test.cr.com");
            driver.findElement(By.cssSelector("#email")).sendKeys("test123@test.cr.com");
        }

    }

    @AfterMethod
            public void afterActions(){

        driver.quit();
    }
}
