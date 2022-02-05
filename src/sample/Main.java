package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;

// Aleksandr Kudin – 101258693
// Oleksii Pedko – 101242285
// CRN – 13803-202001

public class Main extends Application { // MAIN class MUST extend Application class to become JavaFX application

    public static Stage primaryStage;
    MainSceneController mainSceneController = new MainSceneController();

    public static boolean isParsable(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (final NumberFormatException e) {
            return false;
        }
    }

    @Override // overriding abstract method START from the Application class.
    public void start(Stage stage) throws Exception{ //  primaryStage is a primal STAGE (application window)
        // Application hierarchy – Stage -> Scene -> Nodes
        // Stage – application window
        // Scene – particular set of content inside the window (can have only one node)
        // Node – single control elements (buttons, layouts...)
        // Node (layout) – a unique node container can contain different nodes
        // XML is Extensible Markup Language (similar to HTML) – recommended by the World Wide Web Consortium.

        // Setting up FXML manager class.
        FXMLLoader FXMLLoader = new FXMLLoader(); // 'FXML manager class' loads all objects (object hierarchy) from the fxml file.
        URL xmlUrl = getClass().getResource("mainScene.fxml"); // Storing the url path to the FXML file into an instance of the URL class.
        FXMLLoader.setLocation(xmlUrl); // FXMLLoader gets the path to the FXML file.
        FXMLLoader.setController(mainSceneController); // Controller dependency injection. (1 option)
        Parent root = FXMLLoader.load(); // layout node containing other node elements

        // Parent root = FXMLLoader.load(getClass().getResource("mainScene.fxml")); // short version.

        // Setting up the stage.
        primaryStage = stage;
        primaryStage.setTitle("Contact Management System");
        Scene primaryScene = new Scene(root, 1024, 768); // create a scene for the stage (scene constructor is requiring to have one node. ROOT is a node)
        primaryStage.setScene(primaryScene); // set the scene for the stage
        primaryStage.setMaxHeight(768);
        primaryStage.setMaxWidth(1024);
        primaryStage.setMinHeight(768);
        primaryStage.setMinWidth(1024);
        primaryStage.show(); // primal stage is hidden by the default
    }



// JavaFX application does not require to have main method (this method is optional).
    public static void main(String[] args) {
        ContactManager.addContact("Aleksandr", "Kudin", "+1 000 000 00 00", "+7 100 000 00-00", new Address("80 Cooperage St", "", "Toronto", "M5A 0J3", "Ontario", "Canada"), "aleksandr.kudin@georgebrown.ca", new MyDate(1,9,2001), "T127 Student – 3rd semester");
        ContactManager.addContact("Oleksii", "Pedko", "+1 000 000 00 01", "+7 100 586 00-01", new Address("80 Cooperage St", "", "Toronto", "M5A 0J3", "Ontario", "Canada"), "oleksii.pedko@georgebrown.ca", new MyDate(6,10,2001), "T127 Student – 3rd semester");
        ContactManager.addContact("Hesam", "Akbari", "+1 000 000 00 03", "+7 100 586 00-03", new Address("", "", "Toronto", "", "Ontario", "Canada"), "hesam.akbari@georgebrown.ca", new MyDate(1,1,1990), "COMP 2130 Professor – Office C467");
        launch(args);
    }
}
