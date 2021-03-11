package selenium.tests;

import org.junit.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.ComponentScan;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@ComponentScan
public class AssetsTest {
    private static WebDriver driver;
    private ChromeOptions options = new ChromeOptions();


    @BeforeClass
    public static void setSettings() throws IOException {
        Property p=new Property();
        //Указывается путь к драйверу
        System.setProperty("webdriver.chrome.driver", p.getChromedriver());
    }

    @Before
    public void setUpDriver() {
        //запуск браузера в headless режиме
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @Test
    public void doScrin() {
        //ожидание загрузки страницы
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //запуск страницы
        driver.get(ConfProperties.getProperty("page"));
        //Делается скриншот страницы при запуске
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(ConfProperties.getProperty("savepath"));
        try {//сохранение скрина в нужную папку
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void closeDriver() {
        driver.quit();
    }

}
