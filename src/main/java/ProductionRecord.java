import java.util.Date;

public class ProductionRecord {

  private int productionNumber;
  private int productID;
  private String serialNumber;
  private Date dateProduced;

  public ProductionRecord(int productID) {
    this.productionNumber = 0;
    this.productID = productID;
    this.serialNumber = "0";
    this.dateProduced = new Date();
  }

  public ProductionRecord(Product Product, int prodCount) {
    this.productionNumber = 0;
    this.productID = getProductID();
    this.serialNumber = getSerialNum(Product.getManufacturer(),
        Product.getType(), prodCount);
    this.dateProduced = new Date();

  }

  public String getSerialNum(String manufacturer, ItemType type,
      int prodCount) {
    return manufacturer.substring(0, 3) + type.label +
        String.format("%05d", prodCount);
  }

  public ProductionRecord(int productionNumber, int productID,
      String serialNumber, Date dateProduced) {
    this.productionNumber = productionNumber;
    this.productID = productID;
    this.serialNumber = serialNumber;
    this.dateProduced = new Date(dateProduced.getTime());
  }

  public String toString() {
    return "Prod. Num: " + productionNumber + " Product ID: " + productID
        + " Serial Num: " + serialNumber + " Date: " + dateProduced;
  }

  //getters
  public int getProductionNum() {
    return productionNumber;
  }

  public int getProductID() {
    return productID;
  }

  public String getSerialNum() {
    return serialNumber;
  }

  public Date getProdDate() {
    return new Date(dateProduced.getTime());
  }

  //setters
  public void setProductionNum(int productionNumber) {
    this.productionNumber = productionNumber;
  }

  public void setProductID(int productID) {
    this.productID = productID;
  }

  public void setSerialNum(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public void setProdDate(Date dateProduced) {
    this.dateProduced = new Date(dateProduced.getTime());
  }


}