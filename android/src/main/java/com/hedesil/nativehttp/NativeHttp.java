package com.hedesil.nativehttp;

import android.app.Activity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

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
    private Activity _activity;
    @PluginMethod()
    public void capacitorGetRequest(final PluginCall call) {
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
                            call.success((JSObject) response);
                        }

                        @Override
                        public void onError(ANError anError) {
                            Log.d("TagObligatorio", "Error: " + anError.toString());
                            call.error("Ha ocurrido el siguiente error: " + anError.toString());
                        }
                    });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @PluginMethod()
    public void enable(final PluginCall call) {
        this._activity = getActivity();

        getBridge().executeOnMainThread(new Runnable() {
            @Override
            public void run() {
                Window window = getActivity().getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
                int flags = window.getAttributes().flags;
                Boolean state = ((flags & WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON) != 0);
                JSObject ret = new JSObject();
                ret.put("isEnabled", state);
                call.success(ret);
            }
        });
    }

    @PluginMethod()
    public void disable(final PluginCall call) {
        this._activity = getActivity();

        getBridge().executeOnMainThread(new Runnable() {
            @Override
            public void run() {
                Window window = getActivity().getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);;
                int flags = window.getAttributes().flags;
                Boolean state = ((flags & WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON) != 0);
                JSObject ret = new JSObject();
                ret.put("isEnabled", state);
                call.success(ret);
            }
        });
    }
}
