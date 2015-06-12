package com.csf.joselo.bnmws;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.json.JSONException;
import org.json.JSONObject;

import KCOWebServices.KCOASWS;
import KCOWebServices.KCOAsyncResponse;
import KCOWebServices.KCOConfig;

public class MainActivity extends Activity {

    ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pDialog = new ProgressDialog(MainActivity.this);
        pDialog.setMessage("Por favor espere...");
        pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        resetPass();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void userRegister(){

        pDialog.show();

        new KCOASWS(new KCOAsyncResponse() {
            @Override
            public void processFinish(JSONObject json) {
                if (json!=null && json.length() > 0){
                    try {
                        String status = json.getString("success");
                        if(status.equals("true")){

                            //Obtenemos del JSON los datos
                            String service = json.getString("service");
                            String token = json.getString("token");

                            //Debug
                            Log.d("Register", "Service : " + service);
                            Log.d("Register", "Token : " + token);
                            Log.d("Register", "Complete Process To Login");
                            pDialog.dismiss();
                            //createMessageLoginOk();
                        }else if(status.equals("false")){
                            Log.d("Register", "Service : " + json.getString("service"));
                            Log.d("Register", "Message : " + json.getString("message"));
                            pDialog.dismiss();
                            //createMessageLoginNoOk();
                        }
                    }catch (JSONException e) {
                        e.printStackTrace();
                        //createMessageServiceNoOk();
                        pDialog.dismiss();
                    }
                }else{
                    Log.d("LOGIN","Estatus -1 Conexión Interrumpida");
                    pDialog.dismiss();
                    //createMessageServiceNoOk();
                }
            }
        }).execute(KCOConfig.WS_LOGIN, "joselo","joselo");

    }

    public void resetPass(){

        pDialog.show();

        new KCOASWS(new KCOAsyncResponse() {
            @Override
            public void processFinish(JSONObject json) {
                if (json!=null && json.length() > 0){
                    try {
                        String status = json.getString("success");
                        if(status.equals("true")){

                            //Obtenemos del JSON los datos
                            String service = json.getString("service");
                            String token = json.getString("password");

                            //Debug
                            Log.d("Register", "Service : " + service);
                            Log.d("Register", "Token : " + token);
                            Log.d("Register", "Complete Process To Login");
                            pDialog.dismiss();
                            //createMessageLoginOk();
                        }else if(status.equals("false")){
                            Log.d("Register", "Service : " + json.getString("service"));
                            Log.d("Register", "Message : " + json.getString("message"));
                            pDialog.dismiss();
                            //createMessageLoginNoOk();
                        }
                    }catch (JSONException e) {
                        e.printStackTrace();
                        //createMessageServiceNoOk();
                    }
                }else{
                    Log.d("LOGIN", "Estatus -1 Conexión Interrumpida");
                    pDialog.dismiss();
                    //createMessageServiceNoOk();
                }
            }
        }).execute(KCOConfig.WS_RESETPASS, "joselo");

    }
}
