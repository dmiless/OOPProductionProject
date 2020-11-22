/**
 * The MonitorType enum for defining the type of monitor.
 *
 * @author Dylan Miles
 */
public enum MonitorType {

  LCD("LCD"), LED("LED");

  public String label;

  MonitorType(String monitorType) {
    this.label = monitorType;
  }

}
