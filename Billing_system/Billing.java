package com.billing;
import java.sql.*;
import java.util.Scanner;
public class Billing {
        public void generateBill() {
        Scanner sc = new Scanner(System.in);

         try {

           Connection con = DBConnection.getConnection();
           System.out.print("Enter Product ID: ");
           int id = sc.nextInt();
           System.out.print("Enter Quantity: ");
           int qty = sc.nextInt();
       
            PreparedStatement ps = con.prepareStatement("SELECT * FROM products WHERE id=?" );
          
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                String name = rs.getString("name");
                double price = rs.getDouble("price");

            
                int stock = rs.getInt("quantity");
                if(qty > stock) {
                    System.out.println("Not enough stock!");
                    return;
               }
        
                double total = price * qty;
               
                System.out.println("\n----- BILL -----");
                System.out.println("Product : " + name);
                System.out.println("Price   : " + price);
                System.out.println("Quantity: " + qty);
                System.out.println("Total   : " + total);

               
                PreparedStatement ps2 = con.prepareStatement(
                    "INSERT INTO bills(product_name, quantity, total) VALUES (?,?,?)"
                );

                ps2.setString(1, name);
                ps2.setInt(2, qty);
                ps2.setDouble(3, total);
                ps2.executeUpdate();

                String updateQuery =
                "UPDATE products SET quantity = quantity - ? WHERE id = ?";
                PreparedStatement ps3 =
                con.prepareStatement(updateQuery);
                ps3.setInt(1, qty);
                ps3.setInt(2, id);
                ps3.executeUpdate();

                System.out.println("Stock Updated!");

            } else {

                System.out.println("Product Not Found!");

            }

        } catch(Exception e) {

            e.printStackTrace();

        }
    }
}