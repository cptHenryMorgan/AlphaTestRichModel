package ru.netology.productManager.domain;

import ru.netology.productManager.domain.Repository.Repository;

public class Book extends Product {
    private String author;
    Repository repo = new Repository();

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public String setAuthor(String author) {
        this.author = author;
        return author;
    }
    @Override
    public Book[] searchBy(String text) {
        Book[] result = new Book[0]; // тут будем хранить подошедшие запросу продукты
        for (Book book : repo.findAlls()) {
            if (matches(book, text)) {
                Book[] tmp = new Book[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[result.length] = book;
                result = tmp;
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Book book, String search) {
        return book.getAuthor().contains(search);
    }
}
