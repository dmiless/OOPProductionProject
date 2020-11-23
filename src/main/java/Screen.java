/**
 * The Screen class for constructing a new screen.
 *
 * @author Dylan Miles implements ScreenSpec
 */
public class Screen implements ScreenSpec {

  private String resolution;
  private int refreshRate;
  private int responseTime;

  Screen(String resolution, int refreshRate, int responseTime) {
    this.resolution = resolution;
    this.refreshRate = refreshRate;
    this.responseTime = responseTime;
  }

  public String toString() {
    return "Screen:\n" + "Resolution: " + resolution + "\n" + "Refresh rate: " + refreshRate
        + "\n" + "Response time: " + responseTime;
  }

  @Override
  public String getResolution() {
    return resolution;
  }

  @Override
  public int getRefreshRate() {
    return refreshRate;
  }

  @Override
  public int getResponseTime() {
    return responseTime;
  }
}
