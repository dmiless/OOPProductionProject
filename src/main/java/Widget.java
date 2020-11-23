/**
 * The Widget class used for adding a new product extends Product.
 */
public class Widget extends Product {

  /**
   * The main constructor of the Widget class.
   *
   * @param name         - new name passed in
   * @param manufacturer - new manufacturer passed in
   * @param type         - new itemType passed in
   * @param id           - new id passed in
   */
  Widget(String name, String manufacturer, ItemType type, int id) {
    super(name, manufacturer, type);
    super.id = id;
  }


  @Override
  public int getid() {
    return 0;
  }
}

