package com.example.higom.ejemplowebservice;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class VerDatos extends AppCompatActivity {

    private ListView lvl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_datos);

        lvl = (ListView) findViewById(R.id.listaView);
        //invocarServicio();
//        invocarServicioObtenerDatos  webService = new invocarServicioObtenerDatos();
//        webService.execute();
    }

    /*private class invocarServicioObtenerDatos extends AsyncTask<String, String, String> {

        private String resp;

        HttpURLConnection urlConnection;

        @Override
        protected String doInBackground(String... strings) {

            StringBuilder result =  new StringBuilder();

            try {

                URL url = new URL("https://jsonplaceholder.typicode.com/users");
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;

                while ((line = reader.readLine()) != null){
                    result.append(line);
                }

            } catch (Exception e){
                Toast.makeText(VerDatos.this, "Error:", Toast.LENGTH_SHORT).show();

            } finally {
                urlConnection.disconnect();
            }
            return result.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            //super.onPostExecute(s);
            jsonInsertLocal(s);
        }

        @Override
        protected void onPreExecute() {
            // super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(String... values) {
            //super.onProgressUpdate(values);
        }

        private void jsonInsertLocal(String msgJson){

            try{
                List<String> contes = new ArrayList<String>();
                JSONObject obj = new JSONObject(msgJson);
                JSONArray lista = obj.optJSONArray("");

                for (int i = 0; i < lista.length(); i++) {
                    JSONObject json_data = lista.getJSONObject(i);
                    String conte = json_data.getString("name") + " " + json_data.getString("email");
                    contes.add(conte);
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contes);
                lvl.setAdapter(adapter);


            } catch (Exception e){
                Toast.makeText(VerDatos.this, "Error en carga de Lista:", Toast.LENGTH_LONG).show();
            } finally {

            }
        }
    }*/

    /*private void invocarServicio(){
        String DATA_URL = "https://jsonplaceholder.typicode.com/users";
        final ProgressDialog loading = ProgressDialog.show(this,"por favor espere....", "actualizando datos", false,false);

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, DATA_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                loading.dismiss();
                showLisView(response);
            }, new Response.ErrorListener(){
                @Override
                public void onErrorResponse(VolleyError error){
                    loading.dismiss();
                    Toast.makeText(getApplicationContext(), "Error request: "+ error.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjReq);
    }

    private void showLisView(JSONObject object) {
        try {
            List<String> contes = new ArrayList<>();
            JSONArray lista = object.optJSONArray("");

            for (int i = 0; i < lista.length(); i++){
                JSONObject json_data = lista.getJSONObject(i);
                String conte = json_data.getString("name") + " " + json_data.getString("username") + " " + json_data.getString("email");
                contes.add(conte);
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contes);
            lvl.setAdapter(adapter);

        } catch (JSONException e) {

            Toast.makeText(this, "Error carga lista " + e.getMessage(), Toast.LENGTH_SHORT).show();
            //e.printStackTrace();
        } finally {

        }
    }*/
}
