package KCOWebServices;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log;

public class KCOUserFunctions {

    private KCOParseJSON jsonParser;

    // constructor
    public KCOUserFunctions(){
        jsonParser = new KCOParseJSON();
    }

    public JSONObject LOGIN(String soid, String password){
        // Construimos los parametros
        List<NameValuePair> parametros = new ArrayList<>();
        //parametros.add(new BasicNameValuePair("task", KCOConfig.API_LOGIN));
        parametros.add(new BasicNameValuePair("soid", soid));
        parametros.add(new BasicNameValuePair("password", password));
        JSONObject json = jsonParser.getJSONFromUrl(KCOConfig.API_URL+KCOConfig.API_LOGIN, parametros,1);

        if(json != null){
            // return json
            Log.d("JSON RESPONSE", json.toString());
            return json;
        }else{
            JSONObject jsonR = new JSONObject();
            try {
                jsonR.put("status","-1");
                jsonR.put("message","Revisa tu conexion a Internet");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Log.d("JSON NULL RESPONSE", jsonR.toString());
            return jsonR;
        }
    }

    public JSONObject REGISTER(String email, String password, String genre, String blood_type, String hobbies, String profile_image, String full_name){
        // Construimos los parametros
        List<NameValuePair> parametros = new ArrayList<>();
        //parametros.add(new BasicNameValuePair("task", KCOConfig.API_REGISTER));
        parametros.add(new BasicNameValuePair("email", email));
        parametros.add(new BasicNameValuePair("password", password));
        parametros.add(new BasicNameValuePair("genre", genre));
        parametros.add(new BasicNameValuePair("blood_type", blood_type));
        parametros.add(new BasicNameValuePair("hobbies", hobbies));
        parametros.add(new BasicNameValuePair("profile_image", profile_image));
        parametros.add(new BasicNameValuePair("full_name", full_name));
        JSONObject json = jsonParser.getJSONFromUrl(KCOConfig.API_URL+KCOConfig.API_REGISTER, parametros,0);
        if(json!=null){
            // return json
            Log.d("JSON RESPONSE", json.toString());
            return json;
        }else{
            JSONObject jsonR = new JSONObject();
            try {
                jsonR.put("status","-1");
                jsonR.put("message","Revisa tu conexion a Internet");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Log.d("JSON NULL RESPONSE", jsonR.toString());
            return jsonR;
        }
    }

    public JSONObject RESETPASS(String soid){
        // Construimos los parametros
        List<NameValuePair> parametros = new ArrayList<>();
        //parametros.add(new BasicNameValuePair("task", KCOConfig.API_RESETPASS));
        parametros.add(new BasicNameValuePair("soid", soid));
        JSONObject json = jsonParser.getJSONFromUrl(KCOConfig.API_URL+KCOConfig.API_RESETPASS, parametros,0);
        Log.d("HTTP URLLLLLLLLLLLLLL", KCOConfig.API_URL+KCOConfig.API_RESETPASS);
        if(json!=null){
            // return json
            Log.d("JSON RESPONSE", json.toString());
            return json;
        }else{
            JSONObject jsonR = new JSONObject();
            try {
                jsonR.put("status","-1");
                jsonR.put("message","Revisa tu conexion a Internet");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Log.d("JSON NULL RESPONSE", jsonR.toString());
            return jsonR;
        }
    }

    public JSONObject REPORTS(String soid, String message, String report_cat_id){
        // Construimos los parametros
        List<NameValuePair> parametros = new ArrayList<>();
        //parametros.add(new BasicNameValuePair("task", KCOConfig.API_REPORTS));
        parametros.add(new BasicNameValuePair("soid", soid));
        parametros.add(new BasicNameValuePair("message", message));
        parametros.add(new BasicNameValuePair("report_category_id", report_cat_id));
        JSONObject json = jsonParser.getJSONFromUrl(KCOConfig.API_URL+KCOConfig.API_REPORTS, parametros,0);
        if(json!=null){
            // return json
            Log.d("JSON RESPONSE", json.toString());
            return json;
        }else{
            JSONObject jsonR = new JSONObject();
            try {
                jsonR.put("status","-1");
                jsonR.put("message","Revisa tu conexion a Internet");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Log.d("JSON NULL RESPONSE", jsonR.toString());
            return jsonR;
        }
    }


}
