package com.service;

import com.bean.Product;
import com.dao.ProductDao;

public class ProductService {

    private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public Product getProductDetails(int product_code) {
        return productDao.getProductDetails(product_code);
    }

    public double calculatePrice(int quantity, double price) {
        return quantity * price;
    }

    public boolean validateProductCode(int code) {
        return (code > 0 && String.valueOf(code).length() == 4);
    }

    public boolean validateQuantity(int quantity) {
        return quantity > 0;
    }
}
