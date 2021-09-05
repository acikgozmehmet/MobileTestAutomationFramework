package com.macikgoz.tests;

import com.macikgoz.utilities.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class ApiDemosNativeAppTest extends BaseTest
{

    @Test
    public void changePreferenceDependencyToWifiTest()
    {

        Projects.apiDemos().mainPage.Preferences.click();
        Projects.apiDemos().preferencePage.dependencies.click();
        Projects.apiDemos().preferencePage.checkbox.click();
        Projects.apiDemos().preferencePage.wifiSettings.click();
        Projects.apiDemos().preferencePage.wifiSettingsInput.sendKeys("hello");
        Projects.apiDemos().preferencePage.CancelOKBtn.get(1).click();

    }


    @Test(enabled = true)
    public void isSampleMenuDisplayedTest()
    {
        Projects.apiDemos().mainPage.Views.click();
        Gestures.tap(Projects.apiDemos().viewsPage.ExpandableLists);
        Projects.apiDemos().viewsPage.CustomAdapter.click();
        Gestures.longPress(Projects.apiDemos().viewsPage.PeopleNames);

        boolean SampleMenuDisplayed = Projects.apiDemos().viewsPage.SampleMenu.isDisplayed();
        Assert.assertTrue(SampleMenuDisplayed);
    }



    @Test
    public void changeTimebySwipingTest() {
        Projects.apiDemos().mainPage.Views.click();
        Gestures.tap(Projects.apiDemos().viewsPage.DateWidgets);
        Projects.apiDemos().viewsPage.Inline.click();
        Projects.apiDemos().viewsPage.hour9.click();
        WebElement fromElement = Projects.apiDemos().viewsPage.minute15;
        WebElement toElement = Projects.apiDemos().viewsPage.minute45;

        Gestures.swipe(fromElement,toElement);
    }


    @Test
    public void scrollIntoViewTest()
    {
        Projects.apiDemos().mainPage.Views.click();
        Gestures.scrollIntoView("WebView");

    }


    @Test
    public void dragAndDropTest()
    {
        Projects.apiDemos().mainPage.Views.click();
        Projects.apiDemos().viewsPage.DragAndDrop.click();
        WebElement source = Projects.apiDemos().viewsPage.CircleList.get(0);
        WebElement destination = Projects.apiDemos().viewsPage.CircleList.get(1);
        Gestures.dragAndDrop(source, destination);
    }

} //class
