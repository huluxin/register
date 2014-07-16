package com.IsoftStone.harvest.from4GPOS;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-7-16
 * Time: 上午11:54
 * To change this template use File | Settings | File Templates.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class ToolXmlBySAX {

    public static List<HashMap<String, String>> _readXml(InputStream input, String nodeName) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser parser = spf.newSAXParser();
            SaxHandler handler = new SaxHandler(nodeName);
            parser.parse(input, handler);
            input.close();
            return handler.getList();
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            FileInputStream input = new FileInputStream(new File("E:\\privilege.xml"));
            List<HashMap<String, String>> list = _readXml(input, "privilege");
            Map<String,String> data = new HashMap<String,String>();
            for (HashMap<String, String> p : list) {
             //   System.out.println(p.toString());
                for (Map.Entry<String, String> entry: p.entrySet()) {

                    String key = entry.getKey();

                   /* if("id".equals(key)){
                        System.out.println(entry.getValue());
                    }*/
                    if("name".equals(key)){
                        System.out.println(entry.getValue());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
