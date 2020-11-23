import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The employee class for adding new employee login info from GUI into program.
 *
 * @author Dylan Miles
 */
public class Employee {

  private static final String EMAIL_SUFFIX = "@oracleacademy.Test";

  private static final Pattern INVALID_PATTERN = Pattern.compile("[^a-zA-Z ]+");

  private static final Pattern LOWER_PATTERN = Pattern.compile("[a-z]+");

  private static final Pattern UPPER_PATTERN = Pattern.compile("[A-Z]+");

  private static final Pattern OTHER_PATTERN = Pattern.compile("[^a-zA-Z0-9]+");

  private final String name;

  private String username;

  private String password;

  private String email;

  /**
   * Main constructor for Employee class.
   *
   * @param fullName - full name of employee
   * @param password - password of employee
   */
  public Employee(String fullName, String password) {

    if (checkName(fullName)) {

      this.name = fullName.trim();

      String[] partName = name.split(" ", 2);
      setUsername(partName[0], partName[1]);
      setEmail(partName[0], partName[1]);
    } else {
      //if name doesn't contain a space
      System.out.println("Invalid Name: Required to enter a first "
          + "and last name (letters only) separated by a space.");
      this.name = fullName.trim();
      this.username = "default";
      this.email = "user" + EMAIL_SUFFIX;
    }

    if (isValidPassword(password)) {
      reverseString(password);
      setPassword(password);
    } else {
      System.out.println("Invalid Password: Required to contain "
          + "a capital letter, a lowercase letter, and a special character.");
      this.password = "pw";
    }

  }

  /**
   * toString method of employee class to display class data.
   */
  @Override
  public String toString() {

    return "Employee Details\n"
        + "Name : " + name + "\n"
        + "Username : " + username + "\n"
        + "Email : " + email + "\n"
        + "Initial Password : " + password;
  }

  /**
   * reverseString method of employee class to reverse the password entered.
   *
   * @param pw - password passed in normally from GUI
   * @return encrypted password returned
   */
  public static String reverseString(String pw) {
    if (pw.isEmpty()) {
      System.out.println("String in now Empty");
      return pw;
    }
    //Calling Function Recursively
    System.out.println("String to be passed: " + pw.substring(1));
    return reverseString(pw.substring(1)) + pw.charAt(0);
  }

  public void setPassword(String password) {

    this.password = password;
  }

  private boolean checkName(String name) {

    Matcher nameMatch = INVALID_PATTERN.matcher(name);

    return name.contains(" ") && !nameMatch.find();
  }

  private boolean isValidPassword(String password) {

    Matcher upperMatch = UPPER_PATTERN.matcher(password);
    Matcher lowerMatch = LOWER_PATTERN.matcher(password);
    Matcher otherMatch = OTHER_PATTERN.matcher(password);

    return upperMatch.find() && lowerMatch.find() && otherMatch.find();
  }

  private void setUsername(String firstName, String lastName) {

    this.username = firstName.toLowerCase().charAt(0) + lastName.toLowerCase();
  }

  private void setEmail(String firstName, String lastName) {

    this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + EMAIL_SUFFIX;
  }


  public String getName() {
    return name;
  }

  public String getUsername() {
    return username;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

}
