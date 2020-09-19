/**
 * Main class including start method that starts the program. Sets the scene for project.
 *
 * @author Dylan Miles
 * @date 9/19/20
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

    Scene scene = new Scene(root, 500, 650);

    primaryStage.setTitle("OOP Production Project");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
