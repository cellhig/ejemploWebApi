package com.example.higom.ejemplowebservice;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //private Button btn1;
    //TextView sal;

    ListView sal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*btn1 = (Button) findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });*/

        //sal  = (TextView) findViewById(R.id.salida);
        sal  = (ListView) findViewById(R.id.listaView);

        getData();
    }

    public void getData(){

        //placeholder
        String sql = "https://jsonplaceholder.typicode.com/users";
        //maps
        //String sql = "http://maps.googleapis.com/maps/api/geocode/json?address=Medellin";
        //jsonTest
        //String sql = "http://date.jsontest.com/";
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //URL url = null;
        HttpURLConnection conn;

        try {

            URL url = new URL(sql);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String inputLine;
            StringBuffer response = new StringBuffer();

            while((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }

            String json = response.toString();
            JSONArray jsonArr = new JSONArray(json);
            String mensaje = "";
            //JSONObject jsonObject = new JSONObject(json);

            //placeholder
            /*mensaje = "nombre: "+" "+jsonObject.optString("name")+"\n"+"email: "+" "+
                    jsonObject.optString("email")+"\n" +"telefono: "+" "+
                    jsonObject.optString("phone")+"\n"+
                    "website: "+" "+jsonObject.optString("website")+"\n"+"\n"+"\n";*/

            List<String> list = new ArrayList<>();

            for (int i = 0; i < jsonArr.length(); i++){
                JSONObject jsonObject1 = jsonArr.getJSONObject(i);
                String dato =  jsonObject1.optString("name");
                list.add(dato);
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
            sal.setAdapter(adapter);

            //jsontest
            /*mensaje = "time: "+" "+jsonObject.optString("milliseconds_since_epoch")+"\n"+
                    "milliseconds_since_epoch: "+" "+jsonObject.optString("milliseconds_since_epoch") +
                    "\n" +"date: "+" "+jsonObject.optString("date")+"\n"+"\n"+"\n";*/

            // maps
            /*mensaje = "formato de dirección: "+" "+jsonObject.optString("formatted_address")+
                    "\n"+"id del sitio: "+" "+jsonObject.optString("place_id ")+"\n"
                    +"tipo de localizacion: "+" "+jsonObject.optString("location_type")+"\n"+"\n"+"\n";*/

            //sal.setText(mensaje);

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        } catch (JSONException e) {

            e.printStackTrace();

        }

    }
}
