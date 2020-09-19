/**
 * The class was designed in attempt to add the database info into the table. was getting a bit
 * ahead of myself (Work in progress)
 *
 * @author Dylan Miles
 * @date 9/18/20
 */

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProductInfo {

  private final StringProperty name;
  private final StringProperty type;
  private final StringProperty manufacturer;


  //Default constructor
  public ProductInfo(String name, String type, String manufacturer) {
    this.name = new SimpleStringProperty(name);
    this.type = new SimpleStringProperty(type);
    this.manufacturer = new SimpleStringProperty(manufacturer);
  }

  //getters
  public String getName() {
    return name.get();
  }

  public String getType() {
    return type.get();
  }

  public String getManufacturer() {
    return manufacturer.get();
  }

  //setters
  public void setName(String value) {
    name.set(value);
  }

  public void setType(String value) {
    type.set(value);
  }

  public void setManufacturer(String value) {
    manufacturer.set(value);
  }

  //Property Values
  public StringProperty nameProperty() {
    return name;
  }

  public StringProperty typeProperty() {
    return type;
  }

  public StringProperty manufacturerProperty() {
    return manufacturer;
  }

}
