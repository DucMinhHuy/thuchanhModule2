package storage.product;

import controller.Manage;
import model.Product;

import java.io.*;
import java.util.List;

public class ReadWriteData implements IReadWriteData{
    List<Product> productList = Manage.productList;

    private static ReadWriteData instance = null;

    private void ReadWriteFile() {
    }

    public static ReadWriteData getInstance() {
        if (instance == null) instance = new ReadWriteData();
        return instance;
    }

    @Override
    public List<Product> readData() {
        try {
            File file = new File("data/products.csv");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value;
            while ((value = bufferedReader.readLine()) != null) {
                String[] strings = value.split(",");
                Product product = new Product(strings[0], strings[1], Integer.parseInt(strings[2]), Integer.parseInt(strings[3]), strings[4]);
                productList.add(product);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("");
        }
        return productList;
    }

    @Override
    public void writeData(List<Product> books) {
        try {
            File file = new File("data/products.csv");
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Product product : productList) {
                bufferedWriter.write(product.getProductId() + "," + product.getProductName() + "," + product.getProductPrice() + "," + product.getProductAmount() + "," + product.getProductDescribe() + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("");
        }
    }
}
