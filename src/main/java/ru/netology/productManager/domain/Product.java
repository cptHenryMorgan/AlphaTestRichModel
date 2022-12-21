 package ru.netology.productManager.domain;

 import ru.netology.productManager.domain.Repository.Repository;

 public class Product {
        protected int id;
        protected String name;
        protected int price;

        Repository repo = new Repository();

        public Product(int id, String name, int price) {

            this.id = id;
            this.name = name;
            this.price = price;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
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
