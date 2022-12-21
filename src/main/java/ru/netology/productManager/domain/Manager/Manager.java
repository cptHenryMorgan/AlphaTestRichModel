package ru.netology.productManager.domain.Manager;

import ru.netology.productManager.domain.Product;
import ru.netology.productManager.domain.Repository.Repository;

public class Manager {

    private Repository repo;

    public Manager(Repository repo) {
        this.repo = repo;
    }

    public void save(Product product) {
        repo.add(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repo.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[result.length] = product;
                result = tmp;
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }
}
