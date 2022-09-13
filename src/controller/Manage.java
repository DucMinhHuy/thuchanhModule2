package controller;

import com.sun.security.ntlm.Client;
import com.sun.security.ntlm.NTLMException;
import model.Product;
import storage.product.IReadWriteData;
import storage.product.ReadWriteData;
import view.Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static view.Main.inputEditProduct;
import static view.Main.inputRemoveProduct;

public class Manage {
    IReadWriteData readWriteData = ReadWriteData.getInstance();
    public static List<Product> productList = new ArrayList<>();

    public void displayProduct() {
        for (Product a : productList) {
            System.out.println(a);
        }
    }

    public void addProduct(Scanner scanner) throws NTLMException {
        Product product = new Main().creatNewProduct(scanner);
        productList.add(product);
    }

    public void editProduct(Scanner scanner) {
        inputEditProduct(scanner, productList);
    }

    public void removeProduct(Scanner scanner) throws NTLMException {
        inputRemoveProduct(scanner, productList);
    }

    public List<Product> sortByIncreasePrice() {
        Collections.sort(productList);
        return productList;
    }

    public List<Product> sortByDecreasePrice() {
        Collections.reverse(productList);
        return productList;
    }

    public void searchMaxPrice() {
        List<Product> productSortList = sortByIncreasePrice();
        System.out.println(productSortList.get((productSortList.size() - 1)));
    }

    public List<Product> readFileProductList() {
        productList = readWriteData.readData();
        return productList;
    }

    public void writeFileProductList() {
        readWriteData.writeData(productList);
    }
}
