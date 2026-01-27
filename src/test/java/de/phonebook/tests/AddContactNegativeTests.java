package de.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactNegativeTests extends TestBase{

    @BeforeMethod
    public void preconditions () {
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setEmail("ruslammayuk2@gmail.com")
                .setPassword("rrrr12AA$"));
        clickOnLoginButton();

    }
    @Test
    public void addContactWithInvalidPhoneTest() {
        clickOnAddLink();
        fillContactForm(new Contact().setName("Ruslan")
                .setLastname("Maiuk")
                .setPhone("123456789")
                .setEmail("rm@gmail.com")
                .setAddress("Mulhaim")
                .setDescription("QA"));
        clickOnSaveButton();
        Assert.assertTrue(isAlertPresent());

    }
}
