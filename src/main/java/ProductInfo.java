/**
 * The class was designed in attempt to add the database info into the table. was getting a bit
 * ahead of myself (Work in progress)
 *
 * @author Dylan Miles
 * @date 9/18/20
 */

public class ProductInfo extends Product{

  private String Name;
  private ItemType Type;
  private String Manufacturer;


  //Default constructor
   ProductInfo(String name, String manufacturer, ItemType type) {
    super(name, manufacturer, type);
     this.Name = name;
     this.Manufacturer = manufacturer;
     this.Type = type;

  }

  //getters
  public String getName() {
    return Name;
  }

  public ItemType getType() {
    return Type;
  }

  public String getManufacturer() {
    return Manufacturer;
  }

  @Override
  public int getID() {
    return 0;
  }

  //setters
  public void setName(String name) {
    Name = name;
  }

  public void setType(ItemType type) {
    Type = type;
  }

  public void setManufacturer(String manufacturer) {
    Manufacturer = manufacturer;
  }



}
