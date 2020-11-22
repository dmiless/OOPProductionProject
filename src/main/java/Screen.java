/**
 * The Screen class for constructing a new screen.
 *
 * @author Dylan Miles
 * @implements ScreenSpec
 * @date 11/18/20
 */
public class Screen implements ScreenSpec {

  private String resolution;
  private int refreshRate;
  private int responseTime;

  Screen(String Resolution, int RefreshRate, int ResponseTime) {
    //super(Resolution, RefreshRate, ResponseTime);
    this.resolution = Resolution;
    this.refreshRate = RefreshRate;
    this.responseTime = ResponseTime;
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
