public class Widget extends Product {

//  Widget(String name, String manufacturer, String supportedAudioFormats,
  //    String supportedPlaylistFormats) {
  //super(name, manufacturer, supportedAudioFormats, supportedPlaylistFormats);
  //}

  Widget(String name, String manufacturer, ItemType type) {
    super(name, manufacturer, type);
  }

  @Override
  public int getID() {
    return 0;
  }
}

