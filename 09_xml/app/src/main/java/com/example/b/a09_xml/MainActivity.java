package com.example.b.a09_xml;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {

    class MyDomParser extends AsyncTask<String, Void, Document>{

        @Override
        protected void onPostExecute(Document document) {
            super.onPostExecute(document);

            NodeList nodeList = document.getElementsByTagName("data");
            for(int i=0; i<nodeList.getLength(); i++){
                Element element = (Element)nodeList.item(i);

                NodeList hourNodeList = element.getElementsByTagName("hour");
                Element hourElement = (Element)hourNodeList.item(0);

                NodeList textNodeList = hourElement.getChildNodes();
                String strHour = textNodeList.item(0).getNodeValue();


            }

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
            } catch (MalformedURLException e) {
                 e.printStackTrace();
            }
            return doc;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDomParser parser = new MyDomParser();
        parser.execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4143053000");

    }
}
