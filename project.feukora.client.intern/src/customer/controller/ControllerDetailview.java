package customer.controller;

import org.apache.log4j.Logger;

import application.Context;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import projekt.feukora.client.intern.ClientInternRMI;
import projekt.feukora.server.model.Customer;

public class ControllerDetailview {
	
	private static final Logger logger = Logger
			.getLogger(ControllerDetailview.class);

	final ToggleGroup group = new ToggleGroup();
	
	private Customer customer;
	
    @FXML
    private Button detailviewSaveCustomer;
    
    @FXML
    private Button detailviewCancelCustomer;
    
    @FXML
    private RadioButton radioButtonOwner;

    @FXML
    private RadioButton radioButtonAdministration;

    @FXML
    private TextField customerCompanyNameField;
    
    @FXML
    private TextField customerNameField;

    @FXML
    private TextField customerAddressField;

    @FXML
    private TextField customerNumberField;

    @FXML
    private TextField customerZipField;
    
    @FXML
    private TextField customerMunicipalityField;

    @FXML
    private TextField customerFirstNameField;

    @FXML
    private TextField customerEmailField;

    @FXML
    void ActionCustomerCompanyNameField(ActionEvent event) {

    }
    
    @FXML
    void ActionCustomerNameField(ActionEvent event) {

    }

    @FXML
    void ActionCustomerFirstNameField(ActionEvent event) {

    }
    
    @FXML
    void ActionCustomerMunicipalityField(ActionEvent event) {


    }

    @FXML
    void ActionCustomerAddressField(ActionEvent event) {

    }
    
    @FXML
    void ActionCustomerZipField(ActionEvent event) {
    	String plz = customerZipField.getText();
    	Integer zip = Integer.parseInt(plz);
    	
    	try {
			ClientInternRMI feukora = new ClientInternRMI();
			String town = feukora.getTown(zip);
			customerMunicipalityField.setText(town);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Aktion konnte nicht durchgef�hrt werden\'",
					e);
		}

    }

    @FXML
    void ActionCustomerEmailField(ActionEvent event) {

    }

    @FXML
    void ActionCustomerNumberField(ActionEvent event) {

    }
    
    public void initialize() {
    	
    	if(Context.getCustomerName() != null) {
    		NewOrUpdate();
    	} else {
    		radioButtonOwner.setToggleGroup(group);
        	radioButtonAdministration.setToggleGroup(group);
        	radioButtonOwner.setSelected(false);
        	radioButtonAdministration.setSelected(false);
    	}
    	
    	
    
    }
    
    public void NewOrUpdate(){
    
//    	if(Context.getCustomerName() != null){
    		customer = Context.getCustomer();
    		customerCompanyNameField.setText(Context.getCustomerCompanyName());
	    	customerNameField.setText(Context.getCustomerName());
	    	customerFirstNameField.setText(Context.getCustomerFirstname());
	    	customerAddressField.setText(Context.getCustomerAdress());
	    	customerNumberField.setText(Context.getCustomerPhone());
	    	customerEmailField.setText(Context.getCustomerEmail());
	    	customerZipField.setText(Context.getCustomerTown().substring(0, 4));
	    	customerMunicipalityField.setText(Context.getCustomerTown().substring(5));
	    	customerNameField.setText(Context.getCustomerName());
	    	if(Context.getCustomerCustomerfunction().toString().equals("Eigent�mer")){
	    		radioButtonOwner.setSelected(true);
	    	}else{
	    		radioButtonAdministration.setSelected(true);
	    	}
	    	Context.setNull();
//    	} else {
//        	radioButtonOwner.setToggleGroup(group);
//        	radioButtonAdministration.setToggleGroup(group);
//        	radioButtonOwner.setSelected(false);
//        	radioButtonAdministration.setSelected(false);
//      	}
    	
    	
    }

    @FXML
    void ActionDetailviewSaveCustomer(ActionEvent event) {
    	
    	String companyname = customerCompanyNameField.getText();
    	String lastname = customerNameField.getText();
    	String adress = customerAddressField.getText();
    	String phone = customerNumberField.getText();
    	String plz = customerZipField.getText();
    	String firstname = customerFirstNameField.getText();
    	String email = customerEmailField.getText();
    	Integer zip = Integer.parseInt(plz);
    	Boolean isOwner = false;
    	if(radioButtonOwner.isSelected()) {
    		isOwner = true;
    	} else if(radioButtonAdministration.isSelected()) {
    		isOwner = false;
    	}
    	
    	try {
			ClientInternRMI feukora = new ClientInternRMI();
			if(customer == null) {
				feukora.saveCustomer(companyname, lastname, adress, phone, zip, firstname, email, isOwner);
			} else {
				feukora.updateCustomer(companyname, lastname, adress, phone, zip, firstname, email, isOwner);
			}
			
//	    	feukora.deleteCustomer(customer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Aktion konnte nicht durchgef�hrt werden\'",
					e);
		}
    	
    	customerCompanyNameField.clear();
    	customerNameField.clear();
    	customerAddressField.clear();
    	customerNumberField.clear();
    	customerZipField.clear();
    	customerMunicipalityField.clear();
    	customerFirstNameField.clear();
    	customerEmailField.clear();
    	radioButtonOwner.setSelected(false);
    	radioButtonAdministration.setSelected(false);
    	
    }
    
    @FXML
    void ActionDetailviewCancelCustomer(ActionEvent event) {
		BorderPane pane = new BorderPane();
    	
    	try {
			pane = FXMLLoader.load(getClass().getClassLoader().getResource("application/MainViewAdministrator.fxml"));

		} catch (Exception e) {
			logger.error("Aktion konnte nicht durchgef�hrt werden\'",
					e);
		}	
		
    	detailviewCancelCustomer.getScene().setRoot(pane);
    }
    
    @FXML
    void ActionRadioButtonOwner(ActionEvent event) {
    	

    }

    @FXML
    void ActionRadioButtonAdministration(ActionEvent event) {

    }
}
