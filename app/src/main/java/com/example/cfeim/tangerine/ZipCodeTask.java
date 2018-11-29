package com.example.cfeim.tangerine;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class ZipCodeTask extends AsyncTask<String, Void, ArrayList<String>> {

    @Override
    protected ArrayList<String> doInBackground(String... params) {

        Log.d("zip", "ZipCodeTask started");
        HttpsURLConnection connection = null;
        ArrayList<String> arrayList = new ArrayList<>();

        try
        {
            URL url = new URL(params[0]);
            connection = (HttpsURLConnection) url.openConnection();
            connection.connect();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK)
            {
                String json = IOUtils.toString(connection.getInputStream(), "UTF8");

                JSONObject root = new JSONObject(json);
                JSONArray zips = root.optJSONArray("zip_codes");
                JSONObject group;
                String city = "";

                for (int i = 0; i < zips.length(); i++)
                {
                    group = zips.getJSONObject(i).optJSONObject("city");
                    Log.d("zip", "group : " + group);
                    city = zips.getJSONObject(i).getString("city");
                    Log.d("zip", "city : " + city);
                    arrayList.add(city);
                }
            }
        } catch(Exception e)
        {
            Log.d("e", e.toString());
        }

        return arrayList;
    }

    @Override
    protected void onPostExecute(ArrayList<String> arrayList) {
        //super.onPostExecute(mapInfo);
//        if (mapInfo != null) {
//            MainActivity.mapInfo = mapInfo;
//
//            Log.d("b", "DownloadImageTask finished");
//        }
    }
}
