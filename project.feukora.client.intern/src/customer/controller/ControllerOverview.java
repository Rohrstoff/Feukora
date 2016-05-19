package customer.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Sample Skeleton for 'customerOverview.fxml' Controller Class
 */

public class ControllerOverview {

    @FXML // fx:id="overviewRefreshCustomer"
    private Button overviewRefreshCustomer; // Value injected by FXMLLoader

    @FXML // fx:id="overviewDeleteCustomer"
    private Button overviewDeleteCustomer; // Value injected by FXMLLoader
    
    @FXML // fx:id="overviewTableCustomer"
    private TableView<?> overviewTableCustomer; // Value injected by FXMLLoader
    
	@FXML // fx:id="columnCompanynameCostumer"
    private TableColumn<?, ?> columnCompanynameCostumer; // Value injected by FXMLLoader

    @FXML // fx:id="columnEmailCustomer"
    private TableColumn<?, ?> columnEmailCustomer; // Value injected by FXMLLoader

    @FXML // fx:id="columnPhoneCustomer"
    private TableColumn<?, ?> columnPhoneCustomer; // Value injected by FXMLLoader

    @FXML // fx:id="columnNameCustomer"
    private TableColumn<?, ?> columnNameCustomer; // Value injected by FXMLLoader

    @FXML // fx:id="columnAddressCustomer"
    private TableColumn<?, ?> columnAddressCustomer; // Value injected by FXMLLoader

    @FXML // fx:id="columnZIPCustomer"
    private TableColumn<?, ?> columnZIPCustomer; // Value injected by FXMLLoader

    @FXML // fx:id="columnFirstnameCustomer"
    private TableColumn<?, ?> columnFirstnameCustomer; // Value injected by FXMLLoader

    @FXML // Methode f�r die Tabelle
    void ActionOverviewTableCustomer(ActionEvent event) {

    }

    @FXML
    void ActionOverviewDeleteCustomer(ActionEvent event) {

    }

    @FXML
    void ActionOverviewRefreshCustomer(ActionEvent event) {

    }

}
