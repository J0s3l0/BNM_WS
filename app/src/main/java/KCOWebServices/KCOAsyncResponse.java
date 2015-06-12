package KCOWebServices;

import org.json.JSONObject;

public interface KCOAsyncResponse {
    void processFinish(JSONObject output);
}
