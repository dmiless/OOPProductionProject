/**
 * The controller class for adding new product info from GUI into database. Sprint 2 (Beta)
 *
 * @author Dylan Miles
 * @date 9/19/20
 */

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.*;


public class Controller {

  @FXML
  private TextField txtProductName;

  @FXML
  private TextField txtManufacturerName;

  @FXML
  private ComboBox<Integer> cmbQuantity;

  @FXML
  private ChoiceBox<ItemType> cbItemType;

  @FXML
  private TableView<ProductInfo> tableView;

  @FXML
  private TableColumn<?, Product> colProduct;

  @FXML
  private TableColumn<?, Product> colManu;

  @FXML
  private TableColumn<?, Product> colType;

  @FXML
  private ListView<ProductInfo> listView;

  @FXML
  private TextArea proLog;

  @FXML
  void btnItemType(MouseEvent event) {

  }

  @FXML
  void addProduct(ActionEvent event) {
    //when button is clicked, connect to database and add products
    connectToDb();
  }

  @FXML
  void recordProduction(ActionEvent event) {
    //tableView.getItems().clear();

  }

  /**
   * Initializes the database and fills boxes with data options also allows user to enter values
   */
  public void initialize() {

    //connectToDb();
    for (int count = 1; count <= 10; count++) {
      cmbQuantity.getItems().add(Integer.valueOf(String.valueOf(count)));
      cmbQuantity.getSelectionModel().selectFirst();
    }
    cmbQuantity.setEditable(true); // allows the user to enter other values

    //adding item types values for user to choose
    cbItemType.getItems().add(ItemType.valueOf(String.valueOf(ItemType.AUDIO)));
    cbItemType.getItems().add(ItemType.valueOf(String.valueOf(ItemType.VISUAL)));
    cbItemType.getItems().add(ItemType.valueOf(String.valueOf(ItemType.AUDIO_MOBILE)));
    cbItemType.getItems().add(ItemType.valueOf(String.valueOf(ItemType.VISUAL_MOBILE)));
    cbItemType.getSelectionModel().selectFirst();

  }

  /**
   * Connects program to the database Gets and inserts user data from boxes to database Prints
   * database info to console
   */
  public void connectToDb() {
    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./res/HR";

    //  Database credentials
    final String USER = ""; // empty database password
    final String PASS = "";
    Connection conn = null;
    Statement stmt = null;

    try {
      // STEP 1: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 2: Open a connection
      conn = DriverManager.getConnection(DB_URL, USER, PASS); // no password set - not secure

      //STEP 3: Execute a query
      stmt = conn.createStatement();

      //getting user input from the txt boxes
      String productName = txtProductName.getText();
      String manufacturerName = txtManufacturerName.getText();
      ItemType typeName = cbItemType.getValue();

      //inserting user input to database
      String insertSql = "INSERT INTO PRODUCT(name, type, manufacturer)" +
          " VALUES (?, ?, ?)";
      PreparedStatement ps = conn.prepareStatement(insertSql);
      ps.setString(1, productName);
      ps.setString(2, String.valueOf(typeName));
      ps.setString(3, manufacturerName);

      ps.executeUpdate();
      //inserting user input to database
      String insertSql2 =
          "INSERT INTO PRODUCTIONRECORD(PRODUCTION_NUM, PRODUCT_ID, SERIAL_NUM, DATE_PRODUCED)" +
              " VALUES (?, ?, ?, ?)";

      // test constructor used when creating production records from user interface
      int productionNumber = 0;
      int productID = 0;
      String serialNumber = "";
      Date dateProduced = new Date();

      ProductionRecord pr2 = new ProductionRecord(productionNumber, productID, serialNumber,
          dateProduced);

      String sqlprod = "SELECT name, type, manufacturer " +
          "FROM PRODUCT ";

      ResultSet rsprod = stmt.executeQuery(sqlprod);

      int testNum = 0;
      ArrayList<String> products = new ArrayList<String>();
      ArrayList<String> products2 = new ArrayList<String>();
      boolean j = true;

      while (rsprod.next()) {

        testNum++;

        if (j) {
          switch (rsprod.getString(2)) {
            case "VISUAL":
              products.add(0, rsprod.getString(3).substring(0, 3) + "VI" + "00000");
              products2.add(rsprod.getString(3).substring(0, 3) + "VI" + "00000");
              break;
            case "AUDIO":
              products.add(0, rsprod.getString(3).substring(0, 3) + "AU" + "00000");
              products2.add(rsprod.getString(3).substring(0, 3) + "AU" + "00000");

              break;
            case "VISUAL_MOBILE":
              products.add(0, rsprod.getString(3).substring(0, 3) + "VM" + "00000");
              products2.add(rsprod.getString(3).substring(0, 3) + "VM" + "00000");

              break;
            case "AUDIO_MOBILE":
              products.add(0, rsprod.getString(3).substring(0, 3) + "AM" + "00000");
              products2.add(rsprod.getString(3).substring(0, 3) + "AM" + "00000");

              break;
            default:
              //System.out.println("Error missing ItemType ");
              break;
          }
          System.out.println(products.get(0));
          j = false;
        }

        for (int i = 0; i < products.size(); i++) {
          //System.out.println(products.get(i));
          if (rsprod.getString(3) == null || rsprod.getString(3).length() < 3) {
            break;
          }
          if (rsprod.getString(3).substring(0, 3).equals(products.get(i).substring(0, 3))) {
            int part = Integer.parseInt(products.get(i).substring(5, 10));
            part++;
            switch (rsprod.getString(2)) {
              case "VISUAL":
                products.add(i,
                    rsprod.getString(3).substring(0, 3) + "VI" + String.format("%05d", part));
                products2.add(
                    rsprod.getString(3).substring(0, 3) + "VI" + String.format("%05d", part));
                break;
              case "AUDIO":
                products.add(i,
                    rsprod.getString(3).substring(0, 3) + "AU" + String.format("%05d", part));
                products2.add(
                    rsprod.getString(3).substring(0, 3) + "AU" + String.format("%05d", part));
                break;
              case "VISUAL_MOBILE":
                products.add(i,
                    rsprod.getString(3).substring(0, 3) + "VM" + String.format("%05d", part));
                products2.add(
                    rsprod.getString(3).substring(0, 3) + "VM" + String.format("%05d", part));
                break;
              case "AUDIO_MOBILE":
                products.add(i,
                    rsprod.getString(3).substring(0, 3) + "AM" + String.format("%05d", part));
                products2.add(
                    rsprod.getString(3).substring(0, 3) + "AM" + String.format("%05d", part));
                break;
              default:
                //System.out.println("Error missing ItemType ");
                break;
            }
            System.out.println(products.get(i));
            break;
          } else if (products.size() == i + 1) {
            switch (rsprod.getString(2)) {
              case "VISUAL":
                products.add(i, rsprod.getString(3).substring(0, 3) + "VI" + "00000");
                products2.add(rsprod.getString(3).substring(0, 3) + "VI" + "00000");
                break;
              case "AUDIO":
                products.add(i, rsprod.getString(3).substring(0, 3) + "AU" + "00000");
                products2.add(rsprod.getString(3).substring(0, 3) + "AU" + "00000");
                break;
              case "VISUAL_MOBILE":
                products.add(i, rsprod.getString(3).substring(0, 3) + "VM" + "00000");
                products2.add(rsprod.getString(3).substring(0, 3) + "VM" + "00000");
                break;
              case "AUDIO_MOBILE":
                products.add(i, rsprod.getString(3).substring(0, 3) + "AM" + "00000");
                products2.add(rsprod.getString(3).substring(0, 3) + "AM" + "00000");
                break;
              default:
                //System.out.println("Error missing ItemType ");
                break;
            }
            System.out.println(products.get(i));
            break;
          }
        }

        //System.out.println(rsprod.getString(3));

      }

      for (int i = 0; products.size() > i; i++) {
        //System.out.println(products.get(i)+" 9999999999999999999");
        System.out.println(products2.get(i) + " 888888888");

      }

      // test constructor used when creating production records from reading database
      PreparedStatement ps2 = conn.prepareStatement(insertSql2);
      int numProduced = 3;// cmbQuantity.getValue();  // this will come from the combobox in the UI
      int itemCount = 0;

      for (int productionRunProduct = 0; productionRunProduct < numProduced;
          productionRunProduct++) {

        // ProductionRecord pr = new ProductionRecord(productProduced, itemCount++);
        // using the iterator as the product id for testing

        pr2.setProductionNum(testNum);
        pr2.setProductID(productionRunProduct);
        // pr2.setProductID(products.get(testNum));

        pr2.setProdDate(new Date());
        pr2.setProdDate(dateProduced);

        productionNumber = pr2.getProductionNum();
        productID = pr2.getProductID();
        serialNumber = pr2.getSerialNum(manufacturerName, typeName, itemCount);
        dateProduced = pr2.getProdDate();
        serialNumber = products.get(productID);

        ps2.setInt(1, productionNumber);
        ps2.setInt(2, productID);
        //ps2.setString(3, serialNumber);
        System.out.println(productID);
        System.out.println(productionNumber);

        ps2.setString(3, products2.get(productionNumber)); // remove nulls//in db///
        ps2.setObject(4, dateProduced);
        itemCount++;
      }
      ps2.executeUpdate();

      String sql = "SELECT name, type, manufacturer " +
          "FROM PRODUCT ";

      String sql2 = "SELECT PRODUCTION_NUM, PRODUCT_ID, SERIAL_NUM, DATE_PRODUCED " +
          "FROM PRODUCTIONRECORD ";

      ResultSet rs = stmt.executeQuery(sql);
      ObservableList<ProductInfo> productLine = FXCollections.observableArrayList();

      while (rs.next()) {
        itemCount++;
        //print database info to console
        //System.out.println(rs.getString(1));
        //System.out.println(rs.getString(2));
        //System.out.println(rs.getString(3));
        switch (rs.getString(2)) {
          case "VISUAL":
            productLine.add(new ProductInfo(rs.getString(1), rs.getString(3), ItemType.VISUAL));
            break;
          case "AUDIO":
            productLine.add(new ProductInfo(rs.getString(1), rs.getString(3), ItemType.AUDIO));
            break;
          case "VISUAL_MOBILE":
            productLine
                .add(new ProductInfo(rs.getString(1), rs.getString(3), ItemType.VISUAL_MOBILE));
            break;
          case "AUDIO_MOBILE":
            productLine
                .add(new ProductInfo(rs.getString(1), rs.getString(3), ItemType.AUDIO_MOBILE));
            break;
          default:
            //System.out.println("Error missing ItemType ");
            break;
        }


      }
      ResultSet rs2 = stmt.executeQuery(sql2);
      while (rs2.next()) {
        pr2.setProductionNum(itemCount);

//        //print database info to console
//        System.out.println(rs2.getString(1));
//        System.out.println(rs2.getString(2));
//        System.out.println(rs2.getString(3));
//        System.out.println(rs2.getString(4));

        proLog.appendText("Prod. Num: " + rs2.getString(1) + " Product ID: " + rs2.getString(2)
            + " Serial Num: " + rs2.getString(3) + " Date: " + rs2.getString(4) + "\n");

      }

      colProduct.setCellValueFactory(new PropertyValueFactory("Name"));
      colManu.setCellValueFactory(new PropertyValueFactory("Manufacturer"));
      colType.setCellValueFactory(new PropertyValueFactory("Type"));

      tableView.setItems(productLine);

      listView.getItems().addAll(productLine);

      // STEP 4: Clean-up environment
      stmt.close(); //should close out of the database
      conn.close(); //close out connection

    } catch (ClassNotFoundException e) {
      e.printStackTrace();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


}
