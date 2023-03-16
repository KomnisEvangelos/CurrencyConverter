package com.example.currencyconverter2;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class API_REQUEST {
    //temp
    static Double Amount=0.0;
    static String  FromCodeCurrency,ToCodeCurrency,API_KEY;

    //setters & getters
    public static void setAmount(Double Amount1){
        Amount = Amount1;
    }
    public static void setFromCodeCurrency(String FromCodeCurrency1){
        FromCodeCurrency = FromCodeCurrency1;
    }
    public static void setToCodeCurrency(String toCodeCurrency1){
        ToCodeCurrency = toCodeCurrency1;
    }
    public static void setAPI_KEY(String API_KEY1){
        API_KEY = API_KEY1;
    }
    public static Double getAmount(){
        return Amount;
    }
    public static String getFromCodeCurrency(){
        return FromCodeCurrency;
    }
    public static String getToCodeCurrency(){
        return  FromCodeCurrency;
    }
    public static String getAPI_KEY(){
        return API_KEY;
    }

    //API REQUEST FUN -> RETURNS EXCHANGE RATE
    public static double getExchangeRate(String API_KEY, String fromCodeCurrency, String targetCodeCurrency) throws Exception {
        URL url = new URL("https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=" + fromCodeCurrency + "&to_currency=" + targetCodeCurrency + "&apikey=" + API_KEY);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        String json = response.toString();
        JSONObject data = new JSONObject(json);
        String Rate = data.getJSONObject("Realtime Currency Exchange Rate").getString("5. Exchange Rate");
        double exchangeRate = Double.parseDouble(Rate);
        return exchangeRate;

    }
}
