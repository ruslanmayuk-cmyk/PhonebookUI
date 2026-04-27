package de.phonebook.utils;

import de.phonebook.model.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProviders {

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

    //  DataProvider читающий данные из CSV файла
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
