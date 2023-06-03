package com.co.proyectoBase.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class MyWebDriverFactory {
    public static WebDriver myWebDriver;

    public static MyWebDriverFactory web() {
        myWebDriver = getMyWebDriver();
        myWebDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return new MyWebDriverFactory();
    }
    public static WebDriver getMyWebDriver() {
        String webdriverstr=System.getProperty("os.name");
        if(webdriverstr.contains("Mac")) {
            webdriverstr="chrome_mac";
        }else {
            webdriverstr="firefox_win";

        }
        switch(webdriverstr) {
            case "chrome_mac":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/mac/chromedriver");
                ChromeOptions chropts_mac=new ChromeOptions();
                chropts_mac.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                chropts_mac.setHeadless(false);
                chropts_mac.addArguments("−−lang=en");
                return new ChromeDriver(chropts_mac);
            case "firefox_win":
                System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/win/geckodriver.exe");
                FirefoxOptions fireoptswin = new FirefoxOptions();
                fireoptswin.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                WebDriver driver =  new FirefoxDriver();
                return driver;
            default:
                throw new RuntimeException("Unsupported webdriver: " + webdriverstr);
        }
    }

    public WebDriver onPage(String url) {
        myWebDriver.get(url);
        myWebDriver.manage().window().maximize();
        return myWebDriver;
    }


}
