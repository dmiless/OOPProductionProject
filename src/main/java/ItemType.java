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
    switch (code) {
      case "AUDIO":
        return ItemType.AUDIO;
      case "VISUAL":
        return ItemType.VISUAL;
      case "AUDIO_MOBILE":
        return ItemType.AUDIO_MOBILE;
      case "VISUAL_MOBILE":
        return ItemType.VISUAL_MOBILE;
      default:
        System.out.println("Invalid ItemType");
        break;
    }
    return ItemType.AUDIO;
  }

}
