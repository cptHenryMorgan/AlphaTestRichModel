package ru.netology.productManager.domain.Manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.productManager.domain.Book;
import ru.netology.productManager.domain.Product;
import ru.netology.productManager.domain.Repository.Repository;
import ru.netology.productManager.domain.Smartphone;

class ManagerTest {

    @Test
    public void shouldSaveBooks() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Blue", 300, "Ray");
        Book book2 = new Book(2, "Red", 150, "Jhon");
        Book book3 = new Book(3, "Yellow", 200, "Garry");

        manager.save(book1);
        manager.save(book2);
        manager.save(book3);

        Product[] expected = {book1, book2, book3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveWithSimilarNamePriceAndAuthorBooks() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Blue", 300, "Ray");
        Book book2 = new Book(2, "Blue", 300, "Ray");
        Book book3 = new Book(3, "Yellow", 200, "Garry");

        manager.save(book1);
        manager.save(book2);
        manager.save(book3);

        Product[] expected = {book1, book2, book3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByNameBook() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Blue", 300, "Ray");
        Book book2 = new Book(2, "Blue 2", 150, "Jhon");
        Book book3 = new Book(3, "Yellow", 200, "Garry");

        manager.save(book1);
        manager.save(book2);
        manager.save(book3);

        Product[] expected = {book1, book2};
        Product[] actual = manager.searchBy("Blue");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByHalfNameBook() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(1, "Blue", 300, "Ray");
        Book book2 = new Book(2, "Blue 2", 150, "Jhon");
        Book book3 = new Book(3, "Yellow", 200, "Garry");

        manager.save(book1);
        manager.save(book2);
        manager.save(book3);

        Product[] expected = {book1, book2};
        Product[] actual = manager.searchBy("ue");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByWithTwoSimilarLettersBook() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(113, "Blue", 300, "Ray");
        Book book2 = new Book(2, "Blueses 2", 150, "Jhon");
        Book book3 = new Book(3, "Yellow", 200, "Garry");

        manager.save(book1);
        manager.save(book2);
        manager.save(book3);

        Product[] expected = {book1, book2};
        Product[] actual = manager.searchBy("ue");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSaveSmartphone() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Smartphone smartphone1 = new Smartphone(1, "new", 20_000, "producer 1");
        Smartphone smartphone2 = new Smartphone(2, "cast", 25_000, "producer 2");
        Smartphone smartphone3 = new Smartphone(3, "owl", 30_000, "producer 3");

        manager.save(smartphone1);
        manager.save(smartphone2);
        manager.save(smartphone3);

        Product[] expected = {smartphone1, smartphone2, smartphone3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveWithSimilarNamePriceAndAuthorSmartphone() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Smartphone smartphone1 = new Smartphone(1, "new", 11_000, "producer 1");
        Smartphone smartphone2 = new Smartphone(2, "new", 11_000, "producer 1");
        Smartphone smartphone3 = new Smartphone(3, "cast", 9_000, "producer 3");
        Smartphone smartphone4 = new Smartphone(4, "owl", 10_000, "producer 4");

        manager.save(smartphone1);
        manager.save(smartphone2);
        manager.save(smartphone3);
        manager.save(smartphone4);


        Product[] expected = {smartphone1, smartphone2, smartphone3, smartphone4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByNameSmartphone() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Smartphone smartphone1 = new Smartphone(1, "new", 11_000, "producer 1");
        Smartphone smartphone2 = new Smartphone(2, "day", 12_000, "producer 2");
        Smartphone smartphone3 = new Smartphone(3, "cast", 9_000, "producer 3");
        Smartphone smartphone4 = new Smartphone(4, "owl", 10_000, "producer 4");

        manager.save(smartphone1);
        manager.save(smartphone2);
        manager.save(smartphone3);
        manager.save(smartphone4);


        Product[] expected = {smartphone2};
        Product[] actual = manager.searchBy("day");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByHalfNameSmartphone() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Smartphone smartphone1 = new Smartphone(1, "new", 11_000, "producer 1");
        Smartphone smartphone2 = new Smartphone(2, "Day", 12_000, "producer 2");
        Smartphone smartphone3 = new Smartphone(3, "cast", 9_000, "producer 3");
        Smartphone smartphone4 = new Smartphone(4, "owl", 10_000, "producer 4");

        manager.save(smartphone1);
        manager.save(smartphone2);
        manager.save(smartphone3);
        manager.save(smartphone4);

        Product[] expected = {smartphone3};
        Product[] actual = manager.searchBy("st");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByWithTwoSimilarLettersSmartphone() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Smartphone smartphone1 = new Smartphone(1, "new", 11_000, "producer 1");
        Smartphone smartphone2 = new Smartphone(2, "castest", 12_000, "producer 2");
        Smartphone smartphone3 = new Smartphone(3, "cast", 9_000, "producer 3");
        Smartphone smartphone4 = new Smartphone(4, "owl", 10_000, "producer 4");

        manager.save(smartphone1);
        manager.save(smartphone2);
        manager.save(smartphone3);
        manager.save(smartphone4);

        Product[] expected = {smartphone2, smartphone3};
        Product[] actual = manager.searchBy("as");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Book book1 = new Book(113, "Blue", 300, "Ray");
        Book book2 = new Book(2, "Blueses 2", 150, "Jhon");
        Book book3 = new Book(3, "Yellow", 200, "Garry");

        manager.save(book1);
        manager.save(book2);
        manager.save(book3);

        Product[] expected = {book1};
        Product[] actual = manager.searchBy("Ray");

        Assertions.assertArrayEquals(expected, actual);
    }
    }
}