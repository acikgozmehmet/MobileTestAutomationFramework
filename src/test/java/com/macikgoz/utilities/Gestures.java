package com.macikgoz.utilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Coordinates;

import java.time.Duration;
import java.util.List;

public class Gestures {

    private static Dimension dimension;
    private static int numberOfScroll;
    private static int topX, topY, bottomX, bottomY, centerX, centerY;

    static
    {
        dimension = Driver.getDriver().manage().window().getSize();
        numberOfScroll = 12;

        topX =(int)(dimension.width * 0.5);
        topY = (int)(dimension.height * 0.2);

        bottomX =(int)(dimension.width * 0.5);
        bottomY = (int)(dimension.height * 0.8);

        centerX =(int)(dimension.width * 0.5);
        centerY = (int)(dimension.height * 0.5);
    }


    public static void tap(WebElement webElement){
        TouchAction touchAction = new TouchAction(Driver.getDriver());
        touchAction.tap(tapOptions().withElement(element(webElement))).perform();
    }

    public static void longPress(WebElement webElement, int sec)
    {
        TouchAction touchAction = new TouchAction(Driver.getDriver());
        touchAction.longPress(longPressOptions().withElement(element(webElement)).withDuration(Duration.ofSeconds(sec))).release().perform();
    }

    public static void longPress(WebElement webElement)
    {
        int sec = 2;
        longPress(webElement,sec);
    }

    public static void  swipe(WebElement fromElement, WebElement toElement)
    {
        int sec =2;
        TouchAction touchAction = new TouchAction(Driver.getDriver());
        touchAction.longPress(longPressOptions().withElement(element(fromElement)).withDuration(Duration.ofSeconds(sec))).moveTo(element(toElement)).release().perform();
    }

    public static void scrollIntoView(String textToLookFor)
    {
        String command = "new UiScrollable(new UiSelector()).scrollIntoView(text(\""+ textToLookFor + "\"))";
        Driver.getDriver().findElementByAndroidUIAutomator(command);
    }


    public static void scroll(int startX, int startY, int endX, int endY)
    {
        TouchAction touchAction = new TouchAction(Driver.getDriver());
        touchAction.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(endX, endY))
                .release().perform();
    }



    public static void scrollDown() {
        scroll(bottomX, bottomY, topX, topY);
    }

    public static void scrollDown(int nTimes)  {
        for (int i = 0; i < nTimes; i++)
        {
            scrollDown();
        }
    }

    public static void scrollToBottom()
    {
        for (int i = 0; i < numberOfScroll; i++) {
            scrollDown();
        }
    }


    public static void scrollUp()
    {
        scroll(topX, topY, bottomX, bottomY);
    }

    public static void scrollUp(int nTimes)
    {
        for (int i = 0; i < nTimes; i++) {
            scrollUp();
        }
    }

    public static void scrollToTop()
    {
        for (int i = 0; i < numberOfScroll; i++) {
            scrollUp();
        }
    }


    public static void scrollDownTo(String text)  {

        By locatorOfElement =  By.xpath("//*[@text=\"" + text + "\"]");
        Driver.getDriver().hideKeyboard();
        int i = 0;
        while (i < numberOfScroll) {

            List<AndroidElement> elements = Driver.getDriver().findElements(locatorOfElement);

            if (elements.size() > 0) {
                int startX = elements.get(0).getLocation().x;
                int startY = elements.get(0).getLocation().y;
                scroll(startX, startY, centerX, centerY);
                System.out.println(" -->> Sent  ..");
                return;
            } else {
                scrollDown();
                i++;
                System.out.println("--> Scrolling iteartion:" + i);
            }
        }

        System.out.println("Couldn't find the text : "+ locatorOfElement.toString());
    }



    public static void scrollIntoCenterView(WebElement element) {

        MobileElement mobileElement = (MobileElement) element;

        int i = 0;

        while ( (!mobileElement.isDisplayed()) && (i < numberOfScroll) ) {
            scrollDown();
            i++;

            if (i == numberOfScroll )
                return;
        }


        int x = mobileElement.getLocation().x;
        int y = mobileElement.getLocation().y;

        scroll(x,y,centerX,centerY);

    }



    public static void dragAndDrop(WebElement source,WebElement destination)
    {
        int sec =2;
        TouchAction touchAction = new TouchAction(Driver.getDriver());
        touchAction.longPress(element(source)).moveTo(element(destination)).release().perform();
    }


    public static void scrollIntoViewAmongList(String parentListElementLocator, String item)
    {
        Driver.getDriver().findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                        + ".resourceId(\""+parentListElementLocator +"\")).scrollIntoView("
                        + "new UiSelector().textMatches(\""+ item + "\"));");
    }


    public static  int getMeIndexofItemInList(List<WebElement> elementList, String item)
    {
        for (int i = 0; i < elementList.size(); i++)
        {
            if (elementList.get(i).getText().trim().equals(item)){
                return i;
            }
        }
        return -1;
    }





} // class
