package com.company;

import org.w3c.dom.*;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class XMLtoObject {

    public ArrayList<Film> read() throws MalformedURLException {


        final String pathURL = "http://gencat.cat/llengua/cinema/provacin.xml";

        ArrayList<Film> list = new ArrayList<>();

        try {

            URL url = new URL(pathURL);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(url.openStream());

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("FILM");

            for (int i = 0; i < nList.getLength(); i++) {

                Node nNode = nList.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    try {
                        Element eElement = (Element) nNode;

                        String titol = eElement.getElementsByTagName("TITOL").item(0).getTextContent();

                        String any = eElement.getElementsByTagName("ANY").item(0).getTextContent();

                        String original = eElement.getElementsByTagName("ORIGINAL").item(0).getTextContent();

                        String direccio = eElement.getElementsByTagName("DIRECCIO").item(0).getTextContent();

                        String interprets = eElement.getElementsByTagName("INTERPRETS").item(0).getTextContent();

                        String sinopsi = eElement.getElementsByTagName("SINOPSI").item(0).getTextContent();

                        String idioma = eElement.getElementsByTagName("IDIOMA_x0020_ORIGINAL").item(0).getTextContent();


                        Film film = new Film(titol, any, original, direccio, interprets,sinopsi, idioma);

                        list.add(film);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
