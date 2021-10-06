package org.example;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Cases extends Driver {

    String firstPrice;
    String secPrice;
    private By imgLogo = By.cssSelector("a>img[alt='LC Waikiki Logo']");
    private By loginbuttonHover = By.cssSelector("a[href='https://www.lcwaikiki.com/tr-TR/TR/giris']");
    private By loginbuttonActual = By.cssSelector("div a[class='action-btn btn-block bg-blue']");
    private By inputEmail = By.cssSelector("input[name='LoginEmail']");
    private By inputPw = By.cssSelector("input[id='Password']");
    private By loginButton = By.cssSelector("a[id='loginLink']");
    private By verifyLoginProcess = By.cssSelector("span[class='dropdown-label']");
    //==Hesabım
    private By searchBar = By.cssSelector("input[id='search_input']");
    private By searchButton = By.cssSelector("button[class='searchButton']");
    private By seeMoreProd = By.cssSelector("p[class='lazy-load-text']");
    private By products = By.cssSelector("div[class='col-xs-6 col-sm-6 col-md-3 four-column c-item product-item-wrapper']");
    private By productAddtoCart = By.cssSelector("a[id='pd_add_to_cart']");
    private By goToCart = By.cssSelector("div a[class='button dd-button dd-cart']");
    private By productPrice = By.cssSelector("div span[class='price']:nth-of-type(2)");
    private By cartPrice = By.cssSelector("span[class='rd-cart-item-price mb-15']");
    private By addQuantity = By.cssSelector("a[id*='Cart_AddQuantity']");
    private By deleteProduct = By.cssSelector("a[id*='Cart_ProductDelete']");
    private By deleteProduct2 = By.cssSelector("a[id*='Cart_ProductFavAndDelete']");
    //silme butonu 2 tane element donduruyor. popup cıkıyor
    private By emptyText = By.cssSelector("p[class='cart-empty-title']");

    Methods methods = new Methods(driver);

    @Test
    public void test1() {
        String title = methods.getTitle();
        Assert.assertTrue("siteye erişim saglanamadı", title.contains("LC Waikiki"));
    }

    @Test
    public void test2() throws InterruptedException {
        Thread.sleep(3000);
        methods.moveToElementHover(loginbuttonHover);
        methods.click(loginbuttonActual);
        methods.sendKeys(inputEmail, "unal_ozkul61@msn.com");
        methods.sendKeys(inputPw, "unal6161");
        methods.click(loginButton);
    }

    @Test
    public void test3() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals(methods.getText(verifyLoginProcess), "Hesabım");
    }

    @Test
    public void test4() {

        methods.sendKeys(searchBar, "gozluk");
        methods.click(searchButton);
    }
    @Test
    public void test5() {
        methods.moveDown(seeMoreProd);
        methods.click(seeMoreProd);
    }

    @Test
    public void test6() {
        methods.getRandomElementAndClick(methods.findElements(products));

    }

    @Test
    public void test7() {
        firstPrice = methods.getText(productPrice);
        methods.click(productAddtoCart);
        methods.click(goToCart);
        secPrice = methods.getText(cartPrice);
        Assert.assertEquals(firstPrice, secPrice);
    }
    @Test
    public void test8() throws InterruptedException {
        methods.click(addQuantity);
        methods.click(deleteProduct);
        Thread.sleep(5000);
        methods.click(deleteProduct2);
        //Assert.assertTrue(methods.getText(emptyText).contains("bulunmamaktadır"));
    }


}
