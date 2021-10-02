import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class baseTest {
    private ExpectedConditions ExceptedConditions;
    protected WebDriver driver;

    By acceptClickElement=new By.ById("sp-cc-accept");
    By searchClickElement=new By.ById("twotabsearchtextbox");
    By productSelectElement=new By.ByClassName("s-image");
    By productAddElement=new By.ById("add-to-cart-button");
    By goToBasketElement=new By.ById("hlb-view-cart-announce");
    By countElement=new By.ByClassName("a-dropdown-prompt");
    By serachClickButtonElement=new By.ById("nav-search-submit-button");
    protected String productName="çanta";


    @BeforeAll
public void setup(){
    System.setProperty("webdriver.chrome.driver","C:/Users/Zehra/Desktop/chromedriver.exe");
    driver=new ChromeDriver();
    driver.get("https://www.amazon.com.tr/");
    driver.manage().window().maximize();
}
@Test
@Order(1)
public void accept(){
    driver.findElement(acceptClickElement).click();
}
@Test
@Order(2)
    public void searchClick(){
    waitMethod(searchClickElement);
    driver.findElement(searchClickElement).sendKeys(productName);
    driver.findElement(serachClickButtonElement).click();
}

@Test
@Order(3)
public void productSelect(){
        waitMethod(productSelectElement);
    driver.findElements(productSelectElement).get(0).click();
}

@Test
@Order(4)
public void productAdd(){
        waitMethod(productAddElement);
        driver.findElement(productAddElement).click();
}
@Test
@Order(5)
public void goToBasket(){
        waitMethod(goToBasketElement);
        driver.findElement(goToBasketElement).click();
        System.out.println("sepetteki urun sayisi: "+count());
}
private int count(){
    String productBasketCount=driver.findElement(countElement).getText();
    return Integer.parseInt(productBasketCount);
}
@AfterAll
public void windowQuit(){
        driver.quit();
}
public void waitMethod(By locator){
    WebDriverWait wait=new WebDriverWait(driver,3);
    wait.until(ExceptedConditions.visibilityOfElementLocated(locator));
}
}
