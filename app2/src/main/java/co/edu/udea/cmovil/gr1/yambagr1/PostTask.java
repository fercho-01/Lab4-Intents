package co.edu.udea.cmovil.gr1.yambagr1;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.thenewcircle.yamba.client.YambaClient;
//import com.marakana.android.yamba.clientlib.YambaClient;
/**
 * Created by telematica on 15/09/15.
 */
public class PostTask extends AsyncTask<String, Void, String> {
    private static final String TAG = MainActivity.class.getSimpleName();
    private ProgressDialog progress;
    Context aux;
    public PostTask(Context x){
        this.aux = x;
        progress = new ProgressDialog(x);
    }
    @Override
    protected String doInBackground(String... params) {
        try {
            SharedPreferences prefs = PreferenceManager
                    .getDefaultSharedPreferences(aux);
            String username = prefs.getString("username", "");
            String password = prefs.getString("password", "");

            // Check that username and password are not empty
            // If empty, Toast a message to set login info and bounce to
            // SettingActivity
            // Hint: TextUtils.
            if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                aux.startActivity(
                        new Intent(aux, SettingsActivity.class));
                return "Please update your username and password";
            }

            YambaClient cloud = new YambaClient(username, password);
            cloud.postStatus(params[0]);

            Log.d(TAG, "Successfully posted to the cloud: " + params[0]);
            return "Successfully posted";
        } catch (Exception e) {
            Log.e(TAG, "Failed to post to the cloud", e);
            e.printStackTrace();
            return "Failed to post";
        }


    }
    @Override
    protected void onPreExecute() {

    }

    protected void onPostExecute(String result){
        progress.dismiss();
        if (this != null && result!= null) {
            Toast.makeText(aux, result, Toast.LENGTH_LONG).show();
        }
    }
}
