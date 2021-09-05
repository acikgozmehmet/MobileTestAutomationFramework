package com.macikgoz.tests;

import com.macikgoz.utilities.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Set;

public class GeneralStoreNativeAppTest extends BaseTest {

    @Test
    public void LoginTest() {

        Projects.generalStore().mainPage.editBox.sendKeys("Hello");
        Driver.getDriver().hideKeyboard();

        Projects.generalStore().mainPage.femaleRadioBtn.click();

        Projects.generalStore().mainPage.dropDownBox.click();

        Gestures.scrollIntoView("Argentina");
        Projects.generalStore().mainPage.selectCountry("Argentina").click();

        Projects.generalStore().mainPage.letsShopBtn.click();

       }



    @Test
    public void VerifyToastMessage()
    {

        Projects.generalStore().mainPage.femaleRadioBtn.click();

        Projects.generalStore().mainPage.dropDownBox.click();

        Gestures.scrollIntoView("Argentina");
        Projects.generalStore().mainPage.selectCountry("Argentina").click();

        Projects.generalStore().mainPage.letsShopBtn.click();

        String message = Projects.generalStore().mainPage.ToastMessage.getAttribute("name");
        Assert.assertEquals("Please enter your name", message);
    }


    @Test
    public void shopItemAndAddtoCart() throws InterruptedException {

        LoginTest();
        Thread.sleep(5000);

        String parentListElementLocator ="com.androidsample.generalstore:id/rvProductList";
        String item ="Jordan 6 Rings";

        Gestures.scrollIntoViewAmongList(parentListElementLocator, item);
        int index = Gestures.getMeIndexofItemInList(Projects.generalStore().mainPage.productNames, item);
        Projects.generalStore().mainPage.productAddToCart.get(index).click();
    }


    @Test
    public void ValidateTheCart() throws InterruptedException {

        shopItemAndAddtoCart();
        Thread.sleep(5000);
        Projects.generalStore().mainPage.Cart.click();

        Thread.sleep(5000); // wait until

        String productName = Projects.generalStore().mainPage.productNames.get(0).getText();
        String item ="Jordan 6 Rings";

        Assert.assertEquals(productName, item );
    }


    @Test
    public void Add2ItemstoCartAndValidateTotalAmount() throws InterruptedException {

        LoginTest();
        Thread.sleep(5000);

        String parentListElementLocator ="com.androidsample.generalstore:id/rvProductList";
        String item1 ="Jordan 6 Rings";
        String item2 ="Air Jordan 9 Retro";

        Gestures.scrollIntoViewAmongList(parentListElementLocator, item1);
        int index = Gestures.getMeIndexofItemInList(Projects.generalStore().mainPage.productNames, item1);
        Projects.generalStore().mainPage.productAddToCart.get(index).click();
        Thread.sleep(3000);

        Gestures.scrollIntoViewAmongList(parentListElementLocator, item2);
        index = Gestures.getMeIndexofItemInList(Projects.generalStore().mainPage.productNames, item2);
        Projects.generalStore().mainPage.productAddToCart.get(index).click();

        Projects.generalStore().mainPage.Cart.click();

        Thread.sleep(5000); // wait until

        double sum = 0;
        for (int i = 0; i < Projects.generalStore().mainPage.productPrices.size(); i++)
        {
            String priceStr = Projects.generalStore().mainPage.productPrices.get(i).getText().trim().substring(1);
            double price = Double.parseDouble(priceStr);
            sum += price;
        }

        String totalAmountStr = Projects.generalStore().mainPage.totalPurchaseAmount.getText().trim().substring(1);
        double totalAmount = Double.parseDouble(totalAmountStr);

        System.out.println("sum" + sum);
        System.out.println("totalAmount" + totalAmount);

        Assert.assertEquals(totalAmount, sum);

    }


    @Test(enabled = false)
    public void ChangeContextView() throws InterruptedException {
        Add2ItemstoCartAndValidateTotalAmount();

        Gestures.tap(Projects.generalStore().mainPage.checkBox);
        Projects.generalStore().mainPage.contextSwitchBtn.click();

        Thread.sleep(5000);

        driver = Driver.getDriver();
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }


        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.get("https://www.google.com");
    }



} // class
