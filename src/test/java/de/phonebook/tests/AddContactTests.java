package de.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{

   @BeforeMethod
    public void preconditions () {
       clickOnLoginLink();
       fillLoginRegisterForm(new User()
               .setEmail("ruslammayuk2@gmail.com")
               .setPassword("rrrr12AA$"));
       clickOnLoginButton();

   }
    @Test
    public void addContactPositiveTest() {

        clickOnAddLink();
        fillContactForm(new Contact().setName("Ruslan")
                .setLastname("Maiuk")
                .setPhone("1234567890")
                .setEmail("rm@gmail.com")
                .setAddress("Mulhaim")
                .setDescription("QA"));
        clickOnSaveButton();
        Assert.assertTrue(verifyContactByName("Ruslan"));

    }

    @AfterMethod
    public void postCondition() {
        removeContact();

    }

}
