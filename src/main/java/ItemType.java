/**
 * The ItemType enum class for setting the product's type.
 *
 * @author Dylan Miles
 */
public enum ItemType {

  AUDIO("AU"),
  VISUAL("VI"),
  AUDIO_MOBILE("AM"),
  VISUAL_MOBILE("VM");

  /**
   * Local variable label to store item's name.
   */
  public String label;

  /**
   * The ItemType constructor to set the item's name.
   *
   * @param itemName - name of Item
   */
  ItemType(String itemName) {
    this.label = itemName;

  }

  /**
   * SetItemType method to compare and return passed in string with matching ItemTypes.
   *
   * @param code - passed in itemType code
   * @return ItemType
   */
  public static ItemType setItemType(String code) {
    if (code.equals("AUDIO")) {
      return ItemType.AUDIO;
    } else if (code.equals("VISUAL")) {
      return ItemType.VISUAL;
    } else if (code.equals("AUDIO_MOBILE")) {
      return ItemType.AUDIO_MOBILE;
    } else if (code.equals("VISUAL_MOBILE")) {
      return ItemType.VISUAL_MOBILE;
    } else {
      System.out.println("Invalid ItemType");
    }
    return ItemType.AUDIO;
  }

}
