/**
 * The Widget class used for adding a new product extends Product
 */
public class Widget extends Product {

  /**
   * The main constructor of the Widget class
   *
   * @param name         - new name passed in
   * @param manufacturer - new manufacturer passed in
   * @param type         - new itemType passed in
   * @param Id           - new Id passed in
   */
  Widget(String name, String manufacturer, ItemType type, int Id) {
    super(name, manufacturer, type);
    super.id = Id;
  }


  @Override
  public int getID() {
    return 0;
  }
}

