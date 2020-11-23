/**
 * The AudioPlayer class for constructing an AudioPlayer extends Product implements
 * MultimediaControl.
 *
 * @author Dylan Miles
 */
public class AudioPlayer extends Product implements MultimediaControl {

  private final String supportedAudioFormats;
  private final String supportedPlaylistFormats;
  private final ItemType mediaType;
  private final String manufacturer;
  private final String name;

  AudioPlayer(String name, String manufacturer, String supportedAudioFormats,
      String supportedPlaylistFormats) {
    super(name, manufacturer, ItemType.AUDIO);
    mediaType = ItemType.AUDIO;
    this.supportedAudioFormats = supportedAudioFormats;
    this.supportedPlaylistFormats = supportedPlaylistFormats;
    this.name = name;
    this.manufacturer = manufacturer;
  }

  /**
   * toString method for AudioPlayer class to display class info.
   */
  public String toString() {
    return "Name: " + name + "\n" + "Manufacturer: " + manufacturer + "\n" + "Type: " + mediaType
        + "\n" + "Supported Audio Formats: " + supportedAudioFormats + "\n"
        + "Supported Playlist Formats: " + supportedPlaylistFormats;
  }

  @Override
  public int getid() {
    return 0;
  }

  @Override
  public void play() {
    System.out.println("Playing");
  }

  @Override
  public void stop() {
    System.out.println("Stopping");

  }

  @Override
  public void next() {
    System.out.println("Next");
  }

  @Override
  public void previous() {
    System.out.println("Previous");
  }

}
