package com.macikgoz.pages.android.apiDemos.nativeapp;

import com.macikgoz.utilities.Driver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ViewsPage {

    public ViewsPage()
    {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }


    @AndroidFindBy(xpath="//android.widget.TextView[@text='Expandable Lists']")
    public WebElement ExpandableLists;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='1. Custom Adapter']")
    public WebElement CustomAdapter;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='People Names']")
    public WebElement PeopleNames;

    @AndroidFindBy(id="android:id/title")
    public WebElement SampleMenu;


    @AndroidFindBy(xpath="//android.widget.TextView[@text='Date Widgets']")
    public WebElement DateWidgets;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='2. Inline']")
    public WebElement Inline;

    @AndroidFindBy(xpath="//*[@content-desc='9']")
    public WebElement hour9;

    @AndroidFindBy(xpath="//*[@content-desc='15']")
    public WebElement minute15;

    @AndroidFindBy(xpath="//*[@content-desc='45']")
    public WebElement minute45;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Drag and Drop']")
    public WebElement DragAndDrop;

    @AndroidFindBy(className="android.view.View")
    public List<WebElement> CircleList;





}
