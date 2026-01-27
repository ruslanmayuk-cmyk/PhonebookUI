package de.phonebook.tests;

import de.phonebook.core.TestBase;
import de.phonebook.model.Contact;
import de.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

   @BeforeMethod
    public void preconditions () {
       if (!app.getUser().isLoginLinkPresent()) {
           app.getUser().clickOnSignOutButton();
       }
       app.getUser().clickOnLoginLink();
       app.getUser().fillLoginRegisterForm(new User()
               .setEmail("ruslammayuk2@gmail.com")
               .setPassword("rrrr12AA$"));
       app.getUser().clickOnLoginButton();

   }
    @Test
    public void addContactPositiveTest() {

        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact().setName("Ruslan")
                .setLastname("Maiuk")
                .setPhone("1234567890")
                .setEmail("rm@gmail.com")
                .setAddress("Mulhaim")
                .setDescription("QA"));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().verifyContactByName("Ruslan"));

    }

    @AfterMethod
    public void postCondition() {
        app.getContact().removeContact();

    }

}
