package com.example.cfeim.tangerine;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class CraigsListTask extends AsyncTask<String, Void, ArrayList<CraigslistItem>> {

    @Override
    protected ArrayList<CraigslistItem> doInBackground(String... params) {

        HttpURLConnection connection = null;
        ArrayList<CraigslistItem> result = new ArrayList<>();

        String money = "&#x0024;";
        String title;
        String[] split;

        String itemTitle;
        String itemURL;
        String itemDesc;
        int itemPrice;
        boolean itemHide;
        String itemImage;

        Node node;
        Element element1;
        NodeList titleList;
        Element titleElement;
        NodeList urlList;
        Element urlElement;
        NodeList descList;
        Element descElement;
        NodeList imageList;
        Element imageElement;

        try
        {
            URL url = new URL(params[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK)
            {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.parse(new InputSource(url.openStream()));
                doc.getDocumentElement().normalize();

                NodeList nodeList = doc.getElementsByTagName("item");

                Log.d("list", "NodeList length : " + nodeList.getLength());

                node = nodeList.item(0);
                element1 = (Element) node;

                titleList = element1.getElementsByTagName("title");
                titleElement = (Element) titleList.item(0);
                titleList = titleElement.getChildNodes();
                title = titleList.item(0).getNodeValue();

                urlList = element1.getElementsByTagName("link");
                urlElement = (Element) urlList.item(0);
                urlList = urlElement.getChildNodes();
                itemURL = urlList.item(0).getNodeValue();

                descList = element1.getElementsByTagName("description");
                descElement = (Element) descList.item(0);
                descList = descElement.getChildNodes();
                itemDesc = descList.item(0).getNodeValue();

//                imageList = element1.getElementsByTagName("enc:enclosure");
//                Log.d("im", "imageList before : " + imageList);
//                imageElement = (Element) imageList.item(0);
//                Log.d("im", "element : " + imageElement);
//                imageList = imageElement.getChildNodes();
//                Log.d("im", "imageList after : " + imageList);
//                itemImage = imageList.item(0).getNodeValue();
//                Log.d("im", "itemImage : " + itemImage);

                split = title.split(money);
                itemTitle = split[0];
                itemPrice = Integer.parseInt(split[1]);

                Log.d("i", "title : " + itemTitle);
                Log.d("i", "url : " + itemURL);
                Log.d("i", "desc : " + itemDesc);
                Log.d("i", "price : " + itemPrice);
                //Log.d("i", "image : " + itemImage);
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
