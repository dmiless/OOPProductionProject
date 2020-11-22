/**
 * The employee class for adding new employee info from GUI into program.
 *
 * @author Dylan Miles
 * @date 11/15/20
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Employee {

  private static final String EMAIL_SUFFIX = "@oracleacademy.Test";

  private static final Pattern INVALID_PATTERN = Pattern.compile("[^a-zA-Z ]+");

  private static final Pattern LOWER_PATTERN = Pattern.compile("[a-z]+");

  private static final Pattern UPPER_PATTERN = Pattern.compile("[A-Z]+");

  private static final Pattern OTHER_PATTERN = Pattern.compile("[^a-zA-Z0-9]+");

  private String name;

  private String username;

  private String password;

  private String email;

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
      setPassword(password);
    } else {
      System.out.println("Invalid Password: Required to contain "
          + "a capital letter, a lowercase letter, and a special character.");
      this.password = "pw";
    }

  }

  @Override
  public String toString() {

    return "Employee Details\n"
        + "Name : " + name + "\n"
        + "Username : " + username + "\n"
        + "Email : " + email + "\n"
        + "Initial Password : " + password;
  }

  public String reverseString(String pw) {
    String codedPW = pw;
    codedPW.substring(1, 2);

    return codedPW;
  }

  public void setPassword(String password) {

    this.password = password;
  }

  private boolean checkName(String name) {

    Matcher nameMatch = INVALID_PATTERN.matcher(name);

    if (name.contains(" ") && !nameMatch.find()) {
      return true;
    } else {
      return false;
    }
  }

  private boolean isValidPassword(String password) {

    Matcher upperMatch = UPPER_PATTERN.matcher(password);
    Matcher lowerMatch = LOWER_PATTERN.matcher(password);
    Matcher otherMatch = OTHER_PATTERN.matcher(password);

    return upperMatch.find() && lowerMatch.find() && otherMatch.find();
  }

  private void setUsername(String firstName, String lastName) {

    this.username = firstName.toLowerCase().substring(0, 1) + lastName.toLowerCase();
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
