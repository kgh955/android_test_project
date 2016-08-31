package com.example.b.a09_xml;

import android.os.AsyncTask;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by b on 2016-08-31.
 */
public class MyDomParser extends AsyncTask<String, Void, Document> {

    TextView textView;

    private String getElementText(Element dataElement, String tag){
        NodeList hourNodeList = dataElement.getElementsByTagName(tag);
        Element hourElement = (Element)hourNodeList.item(0);

        NodeList textNodeList = hourElement.getChildNodes();
        return textNodeList.item(0).getNodeValue();
    }

    @Override
    protected void onPostExecute(Document document) {
        super.onPostExecute(document);

        String strRes = "";
        // parsing received document..
        NodeList nodeList = document.getElementsByTagName("data");
        for(int i=0; i<nodeList.getLength(); i++){
            Element element = (Element)nodeList.item(i);

            strRes += "hour : "+getElementText(element, "data");
            strRes += "day : "+getElementText(element, "day");
            strRes += "temp : "+getElementText(element, "temp");
            strRes += "wfKor : "+getElementText(element, "wfKor");
            strRes += "\n";
        }
        textView.setText(strRes);
    }

    @Override
    protected Document doInBackground(String... params) {
        String strUrl = params[0];
        URL url = null;
        Document doc = null;
        //
        try {
            url  =  new URL(strUrl);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(url.openStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc;
    }
}