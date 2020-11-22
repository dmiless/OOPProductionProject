/**
 * The ProductionRecord class for adding new product info from GUI pass back.
 *
 * @author Dylan Miles
 * @date 11/18/20
 */

import java.util.Date;

public class ProductionRecord {

  /**
   * the int to hold the product number of the product.
   */
  private int productionNumber;
  /**
   * the int to hold the product ID of the product.
   */
  private int productID;
  /**
   * the String to hold the serialNumber of the product.
   */
  private String serialNumber;
  /**
   * the Date to hold the dateProduced of the product.
   */
  private Date dateProduced;
  /**
   * the int to hold the product count.
   */
  private int prodCount;
  /**
   * the String to hold the name of the product.
   */
  private String productName;

  /**
   * ProductionRecord constructor to construct the new data from the passed information
   *
   * @param Product   - Product class passed to access that info
   * @param prodCount - count of products
   */
  public ProductionRecord(Product Product, int prodCount) {
    this.prodCount = prodCount;
    this.productionNumber = prodCount;
    this.productID = Product.getId();
    this.serialNumber = getSerialNum(Product.getManufacturer(),
        Product.getType(), prodCount);
    this.dateProduced = new Date();
    this.productName = Product.getName();


  }

  /**
   * getSerialNum method to set the serial number from the passed arguments and increment the count
   * of audio/visual
   *
   * @param manufacturer - to take first 3 letters of manufacturer
   * @param type         - check the item type to increment
   * @param prodCount    - increase the count of item type
   * @returns String - constructed serial number
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

    return manufacturer.substring(0, 3) + type.label +
        String.format("%05d", prodCount);
  }

  /**
   * ProductionRecord constructor to construct the new data from the passed information
   *
   * @param productionNumber
   * @param productID
   * @param serialNumber
   * @param dateProduced
   */
  public ProductionRecord(int productionNumber, int productID,
      String serialNumber, Date dateProduced) {
    this.productionNumber = productionNumber;
    this.productID = productID;
    this.serialNumber = serialNumber;
    this.dateProduced = new Date(dateProduced.getTime());
    this.productName = getProductName();
  }

  /**
   * toString to display the ProductionRecord's information
   */
  public String toString() {
    return "Product Num: " + productionNumber + " Product Name: " + productName
        + " Serial Num: " + serialNumber + " Date: " + dateProduced;
  }

  //getters

  /**
   * Gets the productionNumber of this product
   *
   * @return this Product's productionNumber.
   */
  public int getProductionNum() {
    return productionNumber;
  }

  /**
   * Gets the productID of this product
   *
   * @return this Product's productID.
   */
  public int getProductID() {
    return productID;
  }

  /**
   * Gets the serialNumber of this product
   *
   * @return this Product's serialNumber.
   */
  public String getSerialNum() {
    return serialNumber;
  }

  /**
   * Gets the date of this product
   *
   * @return this Product's date.
   */
  public Date getProdDate() {
    return new Date(dateProduced.getTime());
  }

  /**
   * Gets the name of this product
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
   * @param productID This Product's new ID.
   */
  public void setProductID(int productID) {
    this.productID = productID;
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