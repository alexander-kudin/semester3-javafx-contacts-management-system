package sample;

// Aleksandr Kudin – 101258693
// Oleksii Pedko – 101242285
// CRN – 13803-202001

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewContactController {
    public TextField lNameField;
    public TextField fNameField;
    public TextField homePhoneField;
    public TextField workPhoneField;
    public TextField emailField;
    public TextField yearField;
    public TextField monthField;
    public TextField dayField;
    public TextField streetField;
    public TextField street2Field;
    public TextField cityField;
    public TextField provinceField;
    public TextField postalCodeField;
    public TextField countryField;
    public TextField noteField;
    public Button doneBtn;

    public void doneBtnClicked(ActionEvent actionEvent){
        if (!Main.isParsable(dayField.getText())){
            dayField.styleProperty().setValue("-fx-border-color: red");
            return;
        }
        dayField.styleProperty().setValue("-fx-border-color: none");
        if (!Main.isParsable(monthField.getText()) || Integer.parseInt(monthField.getText()) > 12 || Integer.parseInt(monthField.getText()) < 1){
            monthField.styleProperty().setValue("-fx-border-color: red");
            return;
        }
        monthField.styleProperty().setValue("-fx-border-color: none");
        if (!Main.isParsable(yearField.getText())){
            yearField.styleProperty().setValue("-fx-border-color: red");
            return;
        }
        yearField.styleProperty().setValue("-fx-border-color: none");
        String lastName = lNameField.getText();
        String firstName = fNameField.getText();
        String homePhone = homePhoneField.getText();
        String workPhone = workPhoneField.getText();
        String email = emailField.getText();
        String year = yearField.getText();
        String month = monthField.getText();
        String day = dayField.getText();
        String street = streetField.getText();
        String street2 = street2Field.getText();
        String city = cityField.getText();
        String province = provinceField.getText();
        String postalCode = postalCodeField.getText();
        String country = countryField.getText();
        String note = noteField.getText();

        MyDate newBirthDate = new MyDate(Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year));
        Address newAddress = new Address(street, street2, city, postalCode, province, country);
        ContactManager.addContact(firstName, lastName, homePhone, workPhone, newAddress, email, newBirthDate, note);

        Stage parent = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        parent.close();

    }

    public void closeBtnClicked(ActionEvent actionEvent) {
        Stage parent = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        parent.close();
    }
}


