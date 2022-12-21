package ru.netology.productManager.domain.Repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.productManager.domain.Book;
import ru.netology.productManager.domain.Product;
import ru.netology.productManager.domain.Smartphone;

class RepositoryTest {

    @Test
    public void shouldAddBook() {
        Repository repo = new Repository();
        Book book1 = new Book(1, "Blue", 300, "Ray");
        Book book2 = new Book(2, "Red", 150, "Jhon");
        Book book3 = new Book(3, "Yellow", 200, "Garry");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);

        Product[] expected = {book1, book2, book3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemoveBookById() {
        Repository repo = new Repository();
        Book book1 = new Book(1, "Blue", 300, "Ray");
        Book book2 = new Book(2, "Red", 150, "Jhon");
        Book book3 = new Book(3, "Yellow", 200, "Garry");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.removeById(3);


        Product[] expected = {book1, book2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveInMiddleBookById() {
        Repository repo = new Repository();
        Book book1 = new Book(1, "Blue", 300, "Ray");
        Book book2 = new Book(2, "Red", 150, "Jhon");
        Book book3 = new Book(3, "Yellow", 200, "Garry");
        Book book4 = new Book(4, "Green", 200, "Sarah");
        Book book5 = new Book(5, "Black", 250, "Linda");


        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(book4);
        repo.add(book5);

        repo.removeById(3);


        Product[] expected = {book1, book2, book4, book5};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveInMiddleWithSimilarNameBookById() {
        Repository repo = new Repository();
        Book book1 = new Book(1, "Blue", 300, "Ray");
        Book book2 = new Book(2, "Red", 150, "Jhon");
        Book book3 = new Book(3, "Green", 200, "Garry");
        Book book4 = new Book(4, "Green", 200, "Garry");
        Book book5 = new Book(5, "Black", 250, "Linda");


        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(book4);
        repo.add(book5);

        repo.removeById(3);


        Product[] expected = {book1, book2, book4, book5};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddSmartphone() {
        Repository repo = new Repository();
        Smartphone smartphone1 = new Smartphone(1, "new", 11_000, "producer 1");
        Smartphone smartphone2 = new Smartphone(2, "Day", 12_000, "producer 2");
        Smartphone smartphone3 = new Smartphone(3, "cast", 9_000, "producer 3");
        Smartphone smartphone4 = new Smartphone(4, "owl", 10_000, "producer 4");
        Smartphone smartphone5 = new Smartphone(5, "Night", 13_000, "producer 5");

        repo.add(smartphone1);
        repo.add(smartphone2);
        repo.add(smartphone3);
        repo.add(smartphone4);
        repo.add(smartphone5);

        Product[] expected = {smartphone1, smartphone2, smartphone3, smartphone4, smartphone5};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemoveSmartphoneById() {
        Repository repo = new Repository();
        Smartphone smartphone1 = new Smartphone(1, "new", 11_000, "producer 1");
        Smartphone smartphone2 = new Smartphone(2, "Day", 12_000, "producer 2");
        Smartphone smartphone3 = new Smartphone(3, "cast", 9_000, "producer 3");
        Smartphone smartphone4 = new Smartphone(4, "owl", 10_000, "producer 4");
        Smartphone smartphone5 = new Smartphone(5, "Night", 13_000, "producer 5");

        repo.add(smartphone1);
        repo.add(smartphone2);
        repo.add(smartphone3);
        repo.add(smartphone4);
        repo.add(smartphone5);

        repo.removeById(1);


        Product[] expected = {smartphone2, smartphone3, smartphone4, smartphone5};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveInMiddleSmartphoneById() {
        Repository repo = new Repository();
        Smartphone smartphone1 = new Smartphone(1, "new", 11_000, "producer 1");
        Smartphone smartphone2 = new Smartphone(2, "Day", 12_000, "producer 2");
        Smartphone smartphone3 = new Smartphone(3, "cast", 9_000, "producer 3");
        Smartphone smartphone4 = new Smartphone(4, "owl", 10_000, "producer 4");
        Smartphone smartphone5 = new Smartphone(5, "Night", 13_000, "producer 5");

        repo.add(smartphone1);
        repo.add(smartphone2);
        repo.add(smartphone3);
        repo.add(smartphone4);
        repo.add(smartphone5);


        repo.removeById(3);


        Product[] expected = {smartphone1, smartphone2, smartphone4, smartphone5};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveInMiddleWithSimilarNameSmartphoneById() {
        Repository repo = new Repository();
        Smartphone smartphone1 = new Smartphone(1, "new", 11_000, "producer 1");
        Smartphone smartphone2 = new Smartphone(2, "Day", 12_000, "producer 2");
        Smartphone smartphone3 = new Smartphone(3, "Day", 12_000, "producer 2");
        Smartphone smartphone4 = new Smartphone(4, "owl", 10_000, "producer 4");
        Smartphone smartphone5 = new Smartphone(5, "Night", 13_000, "producer 5");

        repo.add(smartphone1);
        repo.add(smartphone2);
        repo.add(smartphone3);
        repo.add(smartphone4);
        repo.add(smartphone5);


        repo.removeById(3);


        Product[] expected = {smartphone1, smartphone2, smartphone4, smartphone5};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}