package com.macikgoz.tests;

import com.macikgoz.utilities.AndroidUtils;
import com.macikgoz.utilities.Projects;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class GoogleChromeBrowserTest extends BaseTest {


    @Test
    public void searchInBrowser()
    {

        driver.get(baseUrl);
        Projects.google().homePage.AdvancedBtn.click();
        Projects.google().homePage.ProceedLnk.click();
        AndroidUtils.waitForVisibility(Projects.google().homePage.searchBox, 30);
        Projects.google().homePage.searchBox.sendKeys("appium"+ Keys.ENTER);

    }


}// class
