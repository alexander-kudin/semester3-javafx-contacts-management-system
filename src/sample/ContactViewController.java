package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

// Aleksandr Kudin – 101258693
// Oleksii Pedko – 101242285
// CRN – 13803-202001

public class ContactViewController implements Initializable {

    Contact selectedContact;
    public Label emailLabel;
    public Label workPhoneLabel;
    public Label birthdayLabel;
    public Label addressLabel;
    public Label addressLabel2;
    public Label notesLabel;
    public Label fullNameLabel;
    public Label homePhoneLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    // Accepts contact object to initialise the view
    public void initData(Contact c){
        selectedContact = c;
        fullNameLabel.setText(c.getFirstName() + " " + c.getLastName());
        homePhoneLabel.setText(c.getHomePhone());
        workPhoneLabel.setText(c.getWorkPhone());
        emailLabel.setText(c.getEmail());
        birthdayLabel.setText(c.getBirthday().toString());
        addressLabel.setText(c.getHomeAddress().streetInfo1);
        addressLabel2.setText(c.getHomeAddress().streetInfo2 + " " + c.getHomeAddress().city + " " + c.getHomeAddress().province + " " + c.getHomeAddress().postalCode + " " + c.getHomeAddress().country);
        notesLabel.setText(c.getNotes());
    }

    public void editBtnClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("editContact.fxml"));
        Parent mainScene = loader.load();

        Scene newContactScene = new Scene (mainScene);

        EditContactController editContactController = loader.getController();
        editContactController.fillCurrentData(selectedContact);

        Stage parent = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        parent.setScene(newContactScene);
    }

    public void closeBtnClicked(ActionEvent actionEvent) {
        Stage parent = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        parent.close();
    }
}
