//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//import javafx.collections.ObservableList;
//
//public class Info {
//  private ObservableList<ProductInfo> productLine;
//  private static Connection conn = null;
//  private static Statement stmt = null;
//  public static List<Product> getProducts() throws IllegalStateException{
//
//    List<Product> products = new ArrayList<>();
//
//    try (
//        PreparedStatement stmt = conn.prepareStatement(
//            "SELECT * FROM product");
//
//        ResultSet rs = stmt.executeQuery()
//    ) {
//      while (rs.next()) {
//
//        String name = rs.getString("name");
//        ItemType type;
//        try {
//          type = ItemType.translateCode(rs.getString("type"));
//
//        } catch (IllegalArgumentException ex) {
//          continue;
//        }
//        String manuf = rs.getString("manuf");
//
//        products.add(new ProductInfo(name, manuf, type));
//      }
//    } catch (SQLException e) {
//      e.printStackTrace();
//    }
//    return products;
//  }
//}
