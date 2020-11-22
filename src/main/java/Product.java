/**
 * The abstract Product class for defining the attributes Product and constructing together
 * implements Item
 *
 * @author Dylan Miles
 */


public abstract class Product implements Item {

  /**
   * The ID of the product
   */
  public int Id;
  /**
   * The Type of the product
   */
  private ItemType Type;
  /**
   * The Manufacturer of the product
   */
  private String Manufacturer;
  /**
   * The Name of the product
   */
  private String Name;

  /**
   * The main constructor of the product class
   *
   * @param name         - new name passed in
   * @param manufacturer - new manufacturer passed in
   * @param type         - new itemType passed in
   */
  Product(String name, String manufacturer, ItemType type) {
    this.Name = name;
    this.Manufacturer = manufacturer;
    this.Type = type;
  }

  /**
   * The toString method of the product class to display this class's info
   */
  public String toString() {
    return "Name: " + Name + "\n" + "Manufacturer: " + Manufacturer + "\n" + "Type: "
        + Type;
  }

  public int getId() {
    return Id;
  }

  /**
   * Gets the Manufacturer of this product
   *
   * @return this Product's Manufacturer.
   */
  public String getManufacturer() {
    return Manufacturer;
  }

  /**
   * Sets the manufacturer of this Product.
   *
   * @param manufacturer This Product's new manufacturer.
   */
  public void setManufacturer(String manufacturer) {
    Manufacturer = manufacturer;
  }

  /**
   * Gets the Name of this product
   *
   * @return this Product's Name.
   */
  public String getName() {
    return Name;
  }

  /**
   * Sets the name of this Product.
   *
   * @param name This Product's new name.
   */
  public void setName(String name) {
    Name = name;
  }

  /**
   * Sets the type of this Product.
   *
   * @param type This Product's new type.
   */
  public void setType(ItemType type) {
    Type = type;
  }

  /**
   * Gets the Type of this product
   *
   * @return this Product's Type.
   */
  public ItemType getType() {
    return Type;
  }
}
