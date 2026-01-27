package de.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginRegisteredUserPositiveTest(){

        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                              .setEmail("ruslammayuk2@gmail.com")
                              .setPassword("rrrr12AA$"));
        clickOnLoginButton();
        Assert.assertTrue(isSignOutButtonPresent());
    }
    @Test
    public void loginRegisteredUserWithoutEmailNegativeTest(){

        clickOnLoginLink();
        fillLoginRegisterForm(new User().setPassword("rrrr12AA$"));
        clickOnLoginButton();
        Assert.assertTrue(isAlertPresent());
    }




}
