package com.billing;
import java.sql.*;
public class ProductDAO {
    public void addProduct(Product p) {
        try {
            Connection con = DBConnection.getConnection();
            String query =
            "INSERT INTO products(name, price, quantity) VALUES (?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);
    
            ps.setString(1, p.name);
            ps.setDouble(2, p.price);
            ps.setInt(3, p.quantity);
            ps.executeUpdate();

            System.out.println("Product Added Successfully!");

        } catch(Exception e) {
            e.printStackTrace();

        }
    }


    public void viewProducts() {

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM products";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            System.out.println("\n----- PRODUCT LIST -----");

            while(rs.next()) {

                System.out.println(
                    "ID: " + rs.getInt("id")
                    + " | Name: " + rs.getString("name")
                    + " | Price: " + rs.getDouble("price")
                    + " | Quantity: " + rs.getInt("quantity")
                );
            }

        } catch(Exception e) {

            e.printStackTrace();

        }
    }

    public void deleteProduct(int id) {

        try {

            Connection con = DBConnection.getConnection();

            String query =   "DELETE FROM products WHERE id=?";
        
            PreparedStatement ps =
            con.prepareStatement(query);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if(rows > 0) {

                System.out.println("Product Deleted Successfully!");

            } else {

                System.out.println("Product Not Found!");

            }

        } catch(Exception e) {

            e.printStackTrace();

        }
    }

 
    public void updateProduct(int id, double newPrice) {

        try {

            Connection con = DBConnection.getConnection();

            String query =
            "UPDATE products SET price=? WHERE id=?";

            PreparedStatement ps =
            con.prepareStatement(query);

            ps.setDouble(1, newPrice);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if(rows > 0) {

                System.out.println("Product Updated!");

            } else {

                System.out.println("Product Not Found!");

            }

        } catch(Exception e) {

            e.printStackTrace();

        }
    }

    
    public void searchProduct(int id) {

        try {

            Connection con = DBConnection.getConnection();

            String query =
            "SELECT * FROM products WHERE id=?";

            PreparedStatement ps =
            con.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                System.out.println(
                    "ID: " + rs.getInt("id")
                    + " | Name: " + rs.getString("name")
                    + " | Price: " + rs.getDouble("price")
                    + " | Quantity: " + rs.getInt("quantity")
                );

            } else {

                System.out.println("Product Not Found!");

            }

        } catch(Exception e) {

            e.printStackTrace();

        }
    }
}