package de.phonebook.tests;

import de.phonebook.core.TestBase;
import de.phonebook.model.Contact;
import de.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {

    @BeforeMethod
    public void precondition () {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }

        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("ruslammayuk2@gmail.com")
                .setPassword("rrrr12AA$"));
        app.getUser().clickOnLoginButton();


        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact().setName("Ruslan")
                .setLastname("Maiuk")
                .setPhone("1234567890")
                .setEmail("rm@gmail.com")
                .setAddress("Mulhaim")
                .setDescription("QA"));
        app.getContact().clickOnSaveButton();

    }
    @Test
    public void removeContactTest(){

        int sizeBefore = app.getContact().sizeOfContacts();
        app.getContact().removeContact();
        app.getContact().pause(1000);
        int sizeAfter = app.getContact().sizeOfContacts();

        Assert.assertEquals(sizeAfter,sizeBefore-1 );

    }

}
