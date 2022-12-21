package ru.netology.productManager.domain.Repository;

import ru.netology.productManager.domain.Book;
import ru.netology.productManager.domain.Product;

public class Repository {

    private Product[] products = new Product[0];
    private Book[] books = new Book[0];


    public void add(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[products.length] = product;
        products = tmp;
    }

    public void removeById(int removeId) {
        Product[] tmp = new Product[products.length - 1];
        int indexToInsert = 0;
        for (Product product : products) {
            if (product.getId() != removeId) {
                tmp[indexToInsert] = product;
                indexToInsert++;
            }
        }
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

    public Book[] findAlls() {
        return books;
    }
}
