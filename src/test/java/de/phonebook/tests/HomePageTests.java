package de.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @Test
    // проверяем наличие элемента HomeComponent  на главной стр.
    public void isHomeComponentPresentTest() {
        // driver.findElement(By.xpath( "//div[2]//h1"));
        //ниччего не проверяет, нужет булевый метод, к-рый возвращает  true/false
        // System.out.println("Home Component is " + isHomeComponentPresent());
        Assert.assertTrue(isHomeComponentPresent());


    }

}
