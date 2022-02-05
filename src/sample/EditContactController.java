package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

// Aleksandr Kudin – 101258693
// Oleksii Pedko – 101242285
// CRN – 13803-202001

public class EditContactController implements Initializable {
    Contact selectedContact;
    public TextField fNameField;
    public TextField lNameField;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void fillCurrentData(Contact c){
        selectedContact = c;
        fNameField.setText(c.getFirstName());
        lNameField.setText(c.getLastName());
        homePhoneField.setText(c.getHomePhone());
        workPhoneField.setText(c.getWorkPhone());
        emailField.setText(c.getEmail());
        dayField.setText(Integer.toString(c.getBirthday().getDay()));
        monthField.setText(Integer.toString(c.getBirthday().getMonth()));
        yearField.setText(Integer.toString(c.getBirthday().getYear()));
        streetField.setText(c.getHomeAddress().streetInfo1);
        street2Field.setText(c.getHomeAddress().streetInfo2);
        cityField.setText(c.getHomeAddress().city);
        provinceField.setText(c.getHomeAddress().province);
        postalCodeField.setText(c.getHomeAddress().postalCode);
        countryField.setText(c.getHomeAddress().country);
        noteField.setText(c.getNotes());
    }


    public void doneBtnClicked(ActionEvent actionEvent) {
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
        String firstName = fNameField.getText();
        String lastName = lNameField.getText();
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

        selectedContact.setFirstName(firstName);
        selectedContact.setLastName(lastName);
        selectedContact.setHomePhone(homePhone);
        selectedContact.setWorkPhone(workPhone);
        selectedContact.getHomeAddress().setStreetInfo1(street);
        selectedContact.getHomeAddress().setStreetInfo2(street2);
        selectedContact.getHomeAddress().setCity(city);
        selectedContact.getHomeAddress().setProvince(province);
        selectedContact.getHomeAddress().setPostalCode(postalCode);
        selectedContact.getHomeAddress().setCountry(country);
        selectedContact.setEmail(email);
        selectedContact.getBirthday().setDay(Integer.parseInt(day));
        selectedContact.getBirthday().setMonth(Integer.parseInt(month));
        selectedContact.getBirthday().setYear(Integer.parseInt(year));
        selectedContact.setNotes(note);

        Stage parent = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        parent.close();

    }
}
