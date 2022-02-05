package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

// Aleksandr Kudin – 101258693
// Oleksii Pedko – 101242285
// CRN – 13803-202001


public class MainSceneController implements Initializable {
    public Label searchErrorLabel;
    public TextField searchField;
    public Label errorMessageLabel;
    public TableView<Contact> tableView; // Таблица
    public TableColumn<Contact, String> colId; // Колонки
    public TableColumn<Contact, String> colName; // Колонки
    public TableColumn<Contact, String> colPhone; // Колонки
    public TableColumn<Contact, String> colEmail; // Колонки
    public TableColumn<Contact, String> colBirthday; // Колонки

    // Initializing ContactManager instance and adding data in it. Forwarding ContactManager data array to the loadData method..
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadData(ContactManager.getContacts());
        initTable();
        System.out.println(tableView);
    }

    // Processing ContactManager data passed. Copying each object to the ObservableArray. Passing ObservableArray data to the TableView object.
    private void loadData(ArrayList<Contact> contactList){
        ObservableList<Contact> dataTable = FXCollections.observableArrayList();
        for (int i = 0; i < contactList.size(); i++) {

            dataTable.add(contactList.get(i));
            //dataTable.add(new Contact(1,"VLAD", "VLAD", "+1 000 000 00 03", "+7 100 586 00-03", new Address("", "", "Toronto", "", "Ontario", "Canada"), "hesam.akbari@georgebrown.ca", new MyDate(1,1,1990), "COMP 2130 Professor – Office C467"));
        }
        tableView.setItems(dataTable);
    }

    // Initialise TableView cols with the data passed from the ObservableArray.
    private void initTable(){
        colId.setCellValueFactory(new PropertyValueFactory<>("contactId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("homePhone"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colBirthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
    }

    public void exitBtnClicked(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void addNewBtnClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("newContact.fxml"));
        Parent mainScene = loader.load();

        Scene contactInfoView = new Scene (mainScene);

        NewContactController newContactController = loader.getController();

        Stage parent = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        Stage newWindow = new Stage();

        newWindow.setScene(contactInfoView);
        newWindow.initModality(Modality.WINDOW_MODAL);
        newWindow.initOwner(parent);
        newWindow.setX(parent.getX() * 2);
        newWindow.setY(parent.getY() * 2);
        newWindow.show();
    }

    public void refreshBtnClicked(ActionEvent actionEvent) {
        loadData(ContactManager.getContacts());
        initTable();
        refresh();
    }


    public void deleteBtnClicked(ActionEvent actionEvent) {
        if (tableView.getSelectionModel().getSelectedItem() == null){
            errorMessageLabel.setText("Contact is not selected.");
            return;
        }

        ObservableList<Contact> selectedRow, allContacts;

        allContacts = tableView.getItems();
        selectedRow = tableView.getSelectionModel().getSelectedItems();

        for (Contact contact : selectedRow){
            allContacts.remove(contact);
            ContactManager.deleteContact(contact.getContactId());
        }

        Contact selectedContact = tableView.getSelectionModel().getSelectedItem();

    }

    // refresh a table
    public void refresh() {
        tableView.refresh();
    }

    public void viewInfoBtnClicked(ActionEvent actionEvent) throws IOException {
        if (tableView.getSelectionModel().getSelectedItem() == null){
            errorMessageLabel.setText("Contact is not selected.");
            return;
        }
        Contact selectedContact = tableView.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("contactView.fxml"));
        Parent mainScene = loader.load();

        Scene contactInfoView = new Scene (mainScene);

        ContactViewController viewController = loader.getController();
        viewController.initData(selectedContact);

        Stage parent = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        Stage newWindow = new Stage();

        newWindow.setScene(contactInfoView);
        newWindow.initModality(Modality.WINDOW_MODAL);
        newWindow.initOwner(parent);
        newWindow.setX(parent.getX() * 2);
        newWindow.setY(parent.getY() * 2);
        newWindow.show();
    }

    public void findBtnClicked(ActionEvent actionEvent) throws IOException {
        Contact selectedContact = null;
        if (searchField.getText().isEmpty()){
            searchField.styleProperty().setValue("-fx-border-color: red");
            searchErrorLabel.setText("ID or keyword must be entered");
            return;
        }

        // check if integer is entered, then find by id
        if (Main.isParsable(searchField.getText())){
            int contactId = Integer.parseInt(searchField.getText());
            if (!ContactManager.contactExists(contactId)){
                searchField.styleProperty().setValue("-fx-border-color: none");
                searchErrorLabel.setText("Contact with this ID not found");
                return;
            }
            else{
                selectedContact = ContactManager.getContact(contactId);
            }
        }

        // check if non integer is entered, then find ALL matches by keyword
        if (!Main.isParsable(searchField.getText())){
            String keyWord = searchField.getText();
            if (ContactManager.getAllContactsByKeyWord(keyWord).isEmpty()){
                searchField.styleProperty().setValue("-fx-border-color: none");
                searchErrorLabel.setText("Contact with this keyword not found");
            }
            else{
                loadData(ContactManager.getAllContactsByKeyWord(keyWord));
                initTable();
            }
            return;
        }

        // final check (should not be thrown)
        if (selectedContact == null) {
            searchErrorLabel.setText("Error occurred");
            return;
        }

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("contactView.fxml"));
        Parent mainScene = loader.load();

        Scene contactInfoView = new Scene (mainScene);

        ContactViewController viewController = loader.getController();
        viewController.initData(selectedContact);

        Stage parent = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        Stage newWindow = new Stage();

        newWindow.setScene(contactInfoView);
        newWindow.initModality(Modality.WINDOW_MODAL);
        newWindow.initOwner(parent);
        newWindow.setX(parent.getX() * 2);
        newWindow.setY(parent.getY() * 2);
        newWindow.show();
    }



}
