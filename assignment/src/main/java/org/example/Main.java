package org.example;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {

        String myUrl= "https://api.nationalize.io/?name=nathaniel";

        HttpURLConnection connection=null;
        int responseCode=0;
        URL url=null;
        try {
            url = new URL(myUrl);
        } catch(MalformedURLException e){
            System.out.println("Something is worng with the URL");
        }

        //Connection:
        try{
            connection=(HttpURLConnection)url.openConnection();
            responseCode=connection.getResponseCode();
        }catch(IOException e){
            throw new RuntimeException(e);
        }

        if(responseCode==200){
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("API call not successfull");
        }


    }
}