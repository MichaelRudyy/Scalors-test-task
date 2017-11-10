package de.aboutyou;

import de.aboutyou.holders.ProductHolder;
import de.aboutyou.parsers.ProductListPageParser;
import de.aboutyou.parsers.ProductPageParser;
import de.aboutyou.parsers.SearchURLBuilder;
import de.aboutyou.xml.XMLWritter;

import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static final String SITE_URL = "https://www.aboutyou.de";

    public static void main(String[] args) throws IOException {

        ArrayList<String> list = ProductListPageParser
                .getListFromProductPage(SITE_URL,
                        SearchURLBuilder.getMaleSearchURL(args[0]));

        XMLWritter writter = new XMLWritter("output.xml");
        writter.start();
        writter.addRootElement("offers");

        ProductHolder tmpHandler;
        for (int i = 0; i < list.size(); i++) {
            tmpHandler = ProductPageParser.parseDataFromProductPage(list.get(i));
            if (tmpHandler.getName() != "") {
                System.out.println(" Progress " + i + " / " + list.size());
                writter.addElement(tmpHandler);
            }
        }

        writter.end();
    }
}
