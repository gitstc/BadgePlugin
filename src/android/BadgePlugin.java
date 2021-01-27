package com.stc.BadgePlugin;

import android.content.pm.PackageInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import java.util.List;
import android.content.pm.ResolveInfo;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.stc.BadgePlugin.BadgePlugin;

public class BadgePlugin extends CordovaPlugin {
    Context context;
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        context = this.cordova.getActivity().getApplicationContext();
        if(action.equals("setBadgeNumber")){
            try {
                ShortcutBadger.setBadge(context, args.getInt(0));

                callbackContext.success();
            }
            catch(Exception e){
                callbackContext.error(e.getMessage());
            }

            return true;
        }
        return false;  // Returning false results in a "MethodNotFound" error.
    }
}