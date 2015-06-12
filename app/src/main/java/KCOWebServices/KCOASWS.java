package KCOWebServices;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class KCOASWS extends AsyncTask<String, Integer, JSONObject>  {

    public KCOAsyncResponse delegate = null;

    public KCOASWS(KCOAsyncResponse delegate){
        this.delegate = delegate;
    }

    @Override
    protected JSONObject doInBackground(String...params) {
        String status="-1";
        KCOUserFunctions userFun = new KCOUserFunctions();
        JSONObject json=null;
        switch (Integer.parseInt(params[0])){
            case 0:
                json = userFun.REGISTER(params[1], params[2], params[3], params[4], params[5], params[6], params[7]);
                break;
            case 1:
                json = userFun.LOGIN(params[1], params[2]);
                break;
            case 2:
                json = userFun.RESETPASS(params[1]);
                break;
            case 3:
                json = userFun.REPORTS(params[1], params[2], params[3]);
                break;
            default:
                json = null;
                break;
        }

        if (json!=null && json.length() > 0){
            try {
                status = json.getString("success");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            if (status.equals("false")){
                Log.d("Status KCOASWS", "invalido");
                return json;
            }
            else if(status.equals("true")){
                Log.d("Status KCOASWS", "valido");
                return json;
            }
        }else{
            Log.e("JSON  ", "ERROR");
            return json;
        }

        return  json;

    }

    @Override
    protected void onPostExecute(JSONObject output) {
        delegate.processFinish(output);
    }


}
