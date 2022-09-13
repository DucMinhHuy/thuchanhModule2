package storage.product;

import model.Product;

import java.util.List;

public interface IReadWriteData {
    List<Product> readData();
    void writeData(List<Product> books);
}
