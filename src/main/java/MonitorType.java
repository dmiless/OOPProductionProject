/**
 * The MonitorType enum for defining the type of monitor.
 *
 * @author Dylan Miles
 * @date 11/15/20
 */
public enum MonitorType {

  LCD("LCD"), LED("LED");

  public String label;

  MonitorType(String monitorType) {
    this.label = monitorType;
  }

}
