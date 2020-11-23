/**
 * The MoviePlayer class for constructing a new MoviePlayer extends Product implements
 * MultimediaControl.
 *
 * @author Dylan Miles
 */
public class MoviePlayer extends Product implements MultimediaControl {

  private final Screen screen;
  private final MonitorType monitorType;
  private String name;
  private String manufacturer;

  MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType) {

    super(name, manufacturer, ItemType.VISUAL);

    this.screen = screen;
    this.monitorType = monitorType;
    this.name = name;
    this.manufacturer = manufacturer;
  }

  /**
   * toString method for MoviePlayer class to display class info.
   */
  public String toString() {
    return "Name: " + name + "\n" + "Manufacturer: " + manufacturer + "\n" + "Type: "
        + ItemType.VISUAL
        + "\n" + screen + "\n"
        + "Monitor Type: " + monitorType;
  }

  @Override
  public int getID() {
    return 0;
  }

  @Override
  public void play() {
    System.out.println("Playing movie");
  }

  @Override
  public void stop() {
    System.out.println("Stopping movie");
  }

  @Override
  public void next() {
    System.out.println("Next movie");
  }

  @Override
  public void previous() {
    System.out.println("Previous movie");
  }

}
