package com.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Product;
import com.service.ProductService;
import com.service.BillingException;

public class BillingMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProductService service = (ProductService) context.getBean("productService");

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Generate Bill by entering code and quantity");
            System.out.println("2. Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    int code = 0, qty = 0;
                    boolean validCode = false, validQty = false;

                    while (!validCode) {
                        System.out.println("Enter product_code");
                        code = sc.nextInt();
                        if (!service.validateProductCode(code)) {
                            System.out.println("Invalid product_code, it should be >0 and 4 digit +ve number");
                        } else {
                            validCode = true;
                        }
                    }

                    while (!validQty) {
                        System.out.println("Enter quantity");
                        qty = sc.nextInt();
                        if (!service.validateQuantity(qty)) {
                            System.out.println("Invalid quantity, it should be >0");
                        } else {
                            validQty = true;
                        }
                    }

                    try {
                        Product p = service.getProductDetails(code);
                        double total = service.calculatePrice(qty, p.getProduct_price());

                        System.out.println("Product Name: " + p.getProduct_name());
                        System.out.println("Product Category: " + p.getProduct_category());
                        System.out.println("Product Description: " + p.getProduct_description());
                        System.out.println("Product Price(Rs): " + p.getProduct_price());
                        System.out.println("Quantity: " + qty);
                        System.out.println("Total Bill Amount: Rs." + total);
                    } catch (Exception e) {
                        System.out.println("Product not found!");
                    }
                    break;

                case 2:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Enter option 1 to 2 only");
            }

        } while (choice != 2);
    }
}
