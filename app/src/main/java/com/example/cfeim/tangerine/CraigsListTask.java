package com.example.cfeim.tangerine;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.commons.io.IOUtils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class CraigsListTask extends AsyncTask<String, Void, ArrayList<CraigslistItem>> {

    @Override
    protected ArrayList<CraigslistItem> doInBackground(String... params) {

        HttpURLConnection connection = null;
        ArrayList<CraigslistItem> result = new ArrayList<>();

        try
        {
            URL url = new URL(params[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK)
            {
                String xml = IOUtils.toString(connection.getInputStream(), "UTF8");
                Log.d("xml", "xml : " + xml);
            }
            else
            {
                //do something
            }
        } catch (Exception e)
        {
            Log.d("cr", "Error : " + e.toString());
        }

        return result;
    }

    @Override
    protected void onPostExecute(ArrayList<CraigslistItem> result) {
        //do something
    }
}
