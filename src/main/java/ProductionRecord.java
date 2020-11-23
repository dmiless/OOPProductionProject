import java.util.Date;

/**
 * The ProductionRecord class for adding new product info from GUI and pass back to display data.
 *
 * @author Dylan Miles
 */
public class ProductionRecord {

  /**
   * the int to hold the product number of the product.
   */
  private int productionNumber;
  /**
   * the int to hold the product ID of the product.
   */
  private int productId;
  /**
   * the String to hold the serialNumber of the product.
   */
  private String serialNumber;
  /**
   * the Date to hold the dateProduced of the product.
   */
  private Date dateProduced;
  /**
   * the String to hold the name of the product.
   */
  private String productName;

  /**
   * ProductionRecord constructor to construct the new data from the passed information.
   *
   * @param product   - product class passed to access that info
   * @param prodCount - count of products
   */
  public ProductionRecord(Product product, int prodCount) {
    this.productionNumber = prodCount;
    this.productId = product.getId();
    this.serialNumber = getSerialNum(product.getManufacturer(),
        product.getType(), prodCount);
    this.dateProduced = new Date();
    this.productName = product.getName();


  }

  /**
   * getSerialNum method to set the serial number from the passed arguments and increment the count
   * of audio/visual.
   *
   * @param manufacturer - to take first 3 letters of manufacturer
   * @param type         - check the item type to increment
   * @param prodCount    - increase the count of item type
   * @return String - fully constructed serial number
   */
  public String getSerialNum(String manufacturer, ItemType type,
      int prodCount) {

    if (type.label.equals("AU") || type.label.equals("AM")) {

      Controller.audioCount = 1 + Controller.audioCount;
      prodCount = Controller.audioCount;
    } else if (type.label.equals("VI") || type.label.equals("VM")) {

      Controller.visualCount = 1 + Controller.visualCount;
      prodCount = Controller.visualCount;
    }

    return manufacturer.substring(0, 3) + type.label
        + String.format("%05d", prodCount);
  }

  /**
   * Gets the serialNumber of this product.
   *
   * @return this Product's serialNumber.
   */
  public String getSerialNum() {
    return serialNumber;
  }

  /**
   * ProductionRecord constructor to construct the new data from the passed information.
   *
   * @param productionNumber - production number
   * @param productId        - product ID
   * @param serialNumber     - serial number
   * @param dateProduced     - date produced
   */
  public ProductionRecord(int productionNumber, int productId,
      String serialNumber, Date dateProduced) {
    this.productionNumber = productionNumber;
    this.productId = productId;
    this.serialNumber = serialNumber;
    this.dateProduced = new Date(dateProduced.getTime());
    this.productName = getProductName();
  }

  /**
   * toString to display the ProductionRecord's information.
   */
  public String toString() {
    return "Product Num: " + productionNumber + " Product Name: " + productName
        + " Serial Num: " + serialNumber + " Date: " + dateProduced;
  }

  //getters

  /**
   * Gets the productionNumber of this product.
   *
   * @return this Product's productionNumber.
   */
  public int getProductionNum() {
    return productionNumber;
  }

  /**
   * Gets the productID of this product.
   *
   * @return this Product's productID.
   */
  public int getProductId() {
    return productId;
  }

  /**
   * Gets the date of this product.
   *
   * @return this Product's date.
   */
  public Date getProdDate() {
    return new Date(dateProduced.getTime());
  }

  /**
   * Gets the name of this product.
   *
   * @return this Product's name.
   */
  public String getProductName() {
    return productName;
  }

  //setters

  /**
   * Sets the productionNumber of this Product.
   *
   * @param productionNumber This Product's new number.
   */
  public void setProductionNum(int productionNumber) {
    this.productionNumber = productionNumber;
  }

  /**
   * Sets the productID of this Product.
   *
   * @param productId This Product's new ID.
   */
  public void setProductId(int productId) {
    this.productId = productId;
  }

  /**
   * Sets the serialNumber of this Product.
   *
   * @param serialNumber This Product's new serialNumber.
   */
  public void setSerialNum(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  /**
   * Sets the dateProduced of this Product.
   *
   * @param dateProduced This Product's new dateProduced.
   */
  public void setProdDate(Date dateProduced) {
    this.dateProduced = new Date(dateProduced.getTime());
  }

  /**
   * Sets the productName of this Product.
   *
   * @param productName This Product's new name.
   */
  public void setProductName(String productName) {
    this.productName = productName;
  }

}