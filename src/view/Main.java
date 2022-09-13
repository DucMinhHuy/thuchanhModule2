package view;

import com.sun.security.ntlm.NTLMException;
import controller.Manage;
import model.Product;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NTLMException {
        menu();
    }
    private static void menu() throws NTLMException {
        Scanner scanner = new Scanner(System.in);
        Manage productManage = new Manage();
        int choice;
        do {
            System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM ----");
            System.out.println("Chọn chức năng theo số (để tiếp tục)");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Tìm sản phẩm có giá đắt nhất");
            System.out.println("7. Đọc từ file");
            System.out.println("8. Ghi từ file");
            System.out.println("9. Thoát");
            System.out.println("Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productManage.displayProduct();
                    break;
                case 2:
                    productManage.addProduct(scanner);
                    break;
                case 3:
                    productManage.editProduct(scanner);
                    break;
                case 4:
                    productManage.removeProduct(scanner);
                    break;
                case 5:
                    int choice1;
                    System.out.println("1. Sắp xếp tăng dần");
                    System.out.println("2. Sắp xếp giảm dần");
                    System.out.println("3. Thoát sắp xếp");
                    choice1 = Integer.parseInt(scanner.nextLine());
                    switch (choice1) {
                        case 1:
                            productManage.sortByIncreasePrice();
                            break;
                        case 2:
                            productManage.sortByDecreasePrice();
                            break;
                        case 3:
                            menu();
                        default:
                            System.out.println("Nhập sai rồi! (Chỉ được nhập 1/2/3)");
                    }
                    break;
                case 6:
                    productManage.searchMaxPrice();
                    break;
                case 7:
                    productManage.readFileProductList();
                    break;
                case 8:
                    productManage.writeFileProductList();
                    break;
                case 9:
                    System.exit(0);
                    break;
            }
        } while (choice != 0);
    }

    public Product creatNewProduct(Scanner scanner) {
        String productId = "", productName ="", productDescribe = "";
        int  productPrice = 0, productAmount = 0;
        try {
            System.out.println("Nhập mã sản phẩm: ");
            productId = scanner.nextLine();
            System.out.println("Nhập tên sản phẩm: ");
            productName = scanner.nextLine();
            System.out.println("Nhập giá sản phẩm: ");
            productPrice = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập số lượng sản phẩm: ");
            productAmount = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập mô tả sản phẩm: ");
            productDescribe = scanner.nextLine();
            System.out.println("Thêm mới sản phẩm thành công");
        } catch (Exception e) {
            System.out.println("Nhập lại nhé!");
            creatNewProduct(scanner);
        }
        return new Product(productId, productName, productPrice, productAmount, productDescribe);
    }

    public static void inputEditProduct(Scanner scanner, List<Product> productList) {
        System.out.println("Nhập vào mã sản phẩm cần sửa");
        String id = scanner.nextLine();
        for (Product a : productList) {
            if (a.getProductId().equals(id)) {
                System.out.println("Nhập mã sản phẩm muốn sửa: ");
                String productCode = scanner.nextLine();
                System.out.println("Nhập tên sản phẩm muốn sửa: ");
                String productName = scanner.nextLine();
                System.out.println("Nhập giá sản phẩm muốn sửa: ");
                int productPrice = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập số lượng sản phẩm muốn sửa: ");
                int productAmount = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhâp mô tả sản phẩm cần sửa: ");
                String productDescribe = scanner.nextLine();
                a.setProductId(productCode);
                a.setProductName(productName);
                a.setProductPrice(productPrice);
                a.setProductAmount(productAmount);
                a.setProductDescribe(productDescribe);
                System.out.println("Sửa thành công");
            } else {
                System.out.println("Không tìm được sản phẩm ");
                inputEditProduct(scanner, productList);
            }
        }
    }

    public static void inputRemoveProduct(Scanner scanner, List<Product> productList) throws NTLMException {
        System.out.println("Nhập vào mã sản phẩm muốn xóa: ");
        String productCode = scanner.nextLine();
        for (Product a : productList) {
            if (a.getProductId().equals(productCode)) {
                System.out.println("Bạn có chắc muốn xóa sản phẩm ?");
                System.out.println("Y: Đồng ý xóa.");
                System.out.println("Nhập ký tự bất kỳ để thoát");
                String confirm = scanner.nextLine();
                if (confirm.equals("Y")) {
                    productList.remove(a);
                    System.out.println("Xoá thành công!");
                    break;
                } else {
                    menu();
                }
            } else {
                System.out.println("Không tìm được sản phẩm");
                inputRemoveProduct(scanner, productList);
            }
        }
    }
}
