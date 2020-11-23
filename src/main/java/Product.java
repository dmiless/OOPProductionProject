/**
 * The abstract Product class for defining the attributes Product and constructing together
 * implements Item.
 *
 * @author Dylan Miles
 */


public abstract class Product implements Item {

  /**
   * The ID of the product.
   */
  public int id;
  /**
   * The Type of the product.
   */
  private ItemType type;
  /**
   * The Manufacturer of the product.
   */
  private String manufacturer;
  /**
   * The Name of the product.
   */
  private String name;

  /**
   * The main constructor of the product class.
   *
   * @param name         - new name passed in
   * @param manufacturer - new manufacturer passed in
   * @param type         - new itemType passed in
   */
  Product(String name, String manufacturer, ItemType type) {
    this.name = name;
    this.manufacturer = manufacturer;
    this.type = type;
  }

  /**
   * The toString method of the product class to display this class's info.
   */
  public String toString() {
    return "Name: " + name + "\n" + "Manufacturer: " + manufacturer + "\n" + "Type: "
        + type;
  }

  public int getId() {
    return id;
  }

  /**
   * Gets the Manufacturer of this product.
   *
   * @return this Product's Manufacturer.
   */
  public String getManufacturer() {
    return manufacturer;
  }

  /**
   * Sets the manufacturer of this Product.
   *
   * @param manufacturer This Product's new manufacturer.
   */
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  /**
   * Gets the Name of this product.
   *
   * @return this Product's Name.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of this Product.
   *
   * @param name This Product's new name.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Sets the type of this Product.
   *
   * @param type This Product's new type.
   */
  public void setType(ItemType type) {
    this.type = type;
  }

  /**
   * Gets the Type of this product.
   *
   * @return this Product's Type.
   */
  public ItemType getType() {
    return type;
  }
}
