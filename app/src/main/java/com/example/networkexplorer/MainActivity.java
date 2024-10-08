package com.example.networkexplorer;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ConnectivityManager connectivityManager;
    private NetworkInfo networkInfo;
    private static String deprecated_version = "Deprecated Version";
    private Network network;
    private NetworkCapabilities networkCapabilities;
    private static String current_version = "Current Version";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        * The isConnected() method in Android is deprecated because it doesn't provide accurate information about network connectivity in all scenarios.
        * For example, it might return true even if there's no internet connectivity, or it might return false if the network is connected but there's no internet access.
        * */

        connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        networkInfo = connectivityManager.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnected()) {
            Log.d(deprecated_version, "Connected!");
        } else {
            Log.d(deprecated_version, "Not Connected!");
        }

        connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        network = connectivityManager.getActiveNetwork();
        networkCapabilities = connectivityManager.getNetworkCapabilities(network);

        if(networkCapabilities != null && networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)) {
            Log.d(current_version, "Connected!");
        } else {
            Log.d(current_version, "Not Connected!");
        }
    }
}