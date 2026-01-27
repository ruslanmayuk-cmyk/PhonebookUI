package de.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{

    @BeforeMethod
    public void precondition () {
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setEmail("ruslammayuk2@gmail.com")
                .setPassword("rrrr12AA$"));
        clickOnLoginButton();


        clickOnAddLink();
        fillContactForm(new Contact().setName("Ruslan")
                .setLastname("Maiuk")
                .setPhone("1234567890")
                .setEmail("rm@gmail.com")
                .setAddress("Mulhaim")
                .setDescription("QA"));
        clickOnSaveButton();

    }
    @Test
    public void removeContactTest(){

        int sizeBefore = sizeOfContacts();
        removeContact();
        pause(500);
        int sizeAfter = sizeOfContacts();

        Assert.assertEquals(sizeAfter,sizeBefore-1 );

    }

}
