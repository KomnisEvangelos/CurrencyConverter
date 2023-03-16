package com.example.currencyconverter2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.currencyconverter2.API_REQUEST.*;

public class HelloController implements Initializable {

    @FXML
    private TextField inputTF,outputTF;
    @FXML
    private ComboBox<String> FromCodeComboBox;
    @FXML
    private ComboBox<String> ToCodeComboBox;
    @FXML
    private Button BtnConverter;
    @FXML
    private Label infolbl;


    @FXML
    protected void OnButtonConverterClick() throws Exception {

       if(Validator.isInt(inputTF.getText())){
           Amount = Double.parseDouble(inputTF.getText());
           FromCodeCurrency = FromCodeComboBox.getValue().toString();
           ToCodeCurrency = ToCodeComboBox.getValue().toString();
           Double ER;

           ER = getExchangeRate(API_KEY,FromCodeCurrency,ToCodeCurrency);
           outputTF.setText(Double.toString(ER*Amount));

           infolbl.setText("1 " + FromCodeCurrency + " = " + ER +" "+ ToCodeCurrency);
       }
       else{
                MessageBox.display("Error", "Must enter a number");
       }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //initialize combo boxes values
        FromCodeComboBox.getItems().addAll("EUR","USD","GBP","CAD","HKD","INR");
        ToCodeComboBox.getItems().addAll("EUR","USD","GBP","CAD","HKD","INR");
        //set pre-selected value
        FromCodeComboBox.setValue("EUR");
        ToCodeComboBox.setValue("USD");

        //set API KEY
        API_REQUEST.setAPI_KEY("EDH6IALMY08EAXGA");
    }



}