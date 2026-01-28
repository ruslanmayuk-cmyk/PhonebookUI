package de.phonebook.tests;

import de.phonebook.data.ContactData;
import de.phonebook.data.UserData;
import de.phonebook.core.TestBase;
import de.phonebook.model.Contact;
import de.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();

    }

    @Test
    public void addContactPositiveTest() {

        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact().setName(ContactData.NAME)
                .setLastname(ContactData.LASTNAME)
                .setPhone(ContactData.PHONE)
                .setEmail(ContactData.EMAIL)
                .setAddress(ContactData.ADRESS)
                .setDescription(ContactData.DESCRIPTION));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().verifyContactByName(ContactData.NAME));

    }

    @AfterMethod
    public void postCondition() {
        app.getContact().removeContact();

    }

    // DataProvider №1
    @DataProvider
    public Iterator<Object[]> addContact() {

        // Список наборов тестовых данных
        // Каждый Object[] — это один запуск теста
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                "Anatoliy",
                "Trubin",
                "1234567890",
                "trubin@gmail.com",
                "berlin",
                "goalkeeper"});

        list.add(new Object[]{"Andrey",
                "Lunin",
                "1234567891",
                "lunin@gmail.com",
                "berlin",
                "goalkeeper"});

        list.add(new Object[]{"Alex",
                "Shovkovskiy",
                "1234567892",
                "alex@gmail.com",
                "berlin",
                "goalkeeper"});

        // Возвращаем итератор, чтобы TestNG мог по очереди
        // подставлять данные в тестовый метод
        return list.iterator();
    }

    // Тест с DataProvider
    @Test(dataProvider = "addContact")
    public void addContactPositiveFronDataProviderTest(String name, String lastname, String phone, String email, String address, String desc) {

        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact().setName(name)
                .setLastname(lastname)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDescription(desc));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().verifyContactByName(name));

    }

    //  DataProvider из CSV
    @DataProvider
    public Iterator<Object[]> addContactFromCsv() throws IOException {
        // Список тестовых данных
        List<Object[]> list = new ArrayList<>();

        // Чтение CSV-файла с тестовыми данными
        BufferedReader reader = new BufferedReader(
                new FileReader("src/test/resources/contact.csv"));

        String line;
        // Читаем файл построчно (одна строка = один набор данных)
        while ((line = reader.readLine()) != null) {

            // Разделяем строку CSV по запятой
            String[] split = line.split(",");

            // Создаём объект Contact из данных строки
            // и добавляем его как аргумент для теста
            list.add(new Object[]{
                    new Contact()
                            .setName(split[0])
                            .setLastname(split[1])
                            .setPhone(split[2])
                            .setEmail(split[3])
                            .setAddress(split[4])
                            .setDescription(split[5])
            });
        }

        // Возвращаем итератор для TestNG
        return list.iterator();
    }

}


