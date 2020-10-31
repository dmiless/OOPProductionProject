public enum ItemType {

  AUDIO("AU"),
  VISUAL("VI"),
  AUDIO_MOBILE( "AM"),
  VISUAL_MOBILE("VM");

  public String label;


  ItemType(String itemName){
    this.label = itemName;

  }

  //public String toString(){
  //  return label;
  //}

}
