package model;

public class Product implements Comparable<Product>{
    private String productId;
    private String productName;
    private int productPrice;
    private int productAmount;
    private String productDescribe;

    public Product() {
    }

    public Product(String productId, String productName, int productPrice, int productAmount, String productDescribe) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productAmount = productAmount;
        this.productDescribe = productDescribe;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public String getProductDescribe() {
        return productDescribe;
    }

    public void setProductDescribe(String productDescribe) {
        this.productDescribe = productDescribe;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productAmount=" + productAmount +
                ", productDescribe='" + productDescribe + '\'' +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        return this.getProductPrice() - o.getProductPrice();
    }
}
