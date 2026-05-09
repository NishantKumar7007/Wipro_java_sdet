package com.billing;
import java.util.Scanner;
public class MainApp {
       public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       ProductDAO dao = new ProductDAO();
       Billing bill = new Billing();

        while(true) {

            System.out.println("\n===== BILLING SYSTEM =====");

            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Generate Bill");
            System.out.println("4. Delete Product");
            System.out.println("5. Update Product Price");
            System.out.println("6. Search Product");
            System.out.println("7. Exit");

            System.out.print("Enter Choice: ");

            int ch = sc.nextInt();

            switch(ch) {

              
                case 1:

                    System.out.print("Enter Name: ");
                    String name = sc.next();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();

                    dao.addProduct(
                        new Product(name, price, quantity)
                    );

                    break;

               
                case 2:

                    dao.viewProducts();

                    break;

                
                case 3:

                    bill.generateBill();

                    break;

                
                case 4:

                    System.out.print( "Enter Product ID to Delete: ");
                   

                    int deleteId = sc.nextInt();

                    dao.deleteProduct(deleteId);

                    break;

                
                case 5:

                    System.out.print("Enter Product ID: ");
                    

                    int updateId = sc.nextInt();

                    System.out.print("Enter New Price: ");
                   

                    double newPrice = sc.nextDouble();

                    dao.updateProduct(updateId, newPrice);

                    break;

              
                case 6:

                    System.out.print("Enter Product ID: ");
                  

                    int searchId = sc.nextInt();

                    dao.searchProduct(searchId);

                    break;

               
                case 7:

                    System.out.println("Thank You!");

                    System.exit(0);

                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }
}