package com.hedesil.nativehttp;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

import org.json.JSONArray;
import org.json.JSONObject;

@NativePlugin()
public class NativeHttp extends Plugin {

    @PluginMethod()
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", value);
        call.success(ret);
    }

    @PluginMethod()
    public void capacitorGetRequest(PluginCall call) {
        try {
            AndroidNetworking.get("https://fierce-cove-29863.herokuapp.com/getAllUsers/{pageNumber}")
                    .addPathParameter("pageNumber", "0")
                    .addQueryParameter("limit", "3")
                    .setPriority(Priority.LOW)
                    .build()
                    .getAsJSONObject(new JSONObjectRequestListener() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Log.d("TagObligatorio", "Response: " + response.toString());
                        }

                        @Override
                        public void onError(ANError anError) {
                            Log.d("TagObligatorio", "Error: " + anError.toString());
                        }
                    });

        } catch (Exception e) {
            e.printStackTrace();
        }

        JSObject ret = new JSObject();
        ret.put("url", url);
        call.success(ret);
    }
}
