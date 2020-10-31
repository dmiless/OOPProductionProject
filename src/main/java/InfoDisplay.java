import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

public class InfoDisplay {

  private static Connection conn;
  private static Statement stmt;

  public static Product addProduct(String name, String manuf, ItemType type) {

    return new ProductInfo(name, manuf, type);
  }
}
