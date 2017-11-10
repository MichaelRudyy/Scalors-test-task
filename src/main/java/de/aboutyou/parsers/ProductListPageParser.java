package de.aboutyou.parsers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * ProductListPageParser
 * Class implements functionality that helps to get
 * data from product page
 *
 * @author Michael Rudyy
 * @version 1.5
 */

public class ProductListPageParser {
    private static Document document;
    private static ArrayList<String> listOfURL;

    public static ArrayList<String> getListFromProductPage(String siteURL, String pageURL) {
        listOfURL = new ArrayList<>();
        String nextPageUrl = pageURL;
        do {
            addProductUrlFromSearchPage(siteURL, nextPageUrl);
            try {
                nextPageUrl = siteURL + document.getElementsByClass("btn btn-category-next").first().attr("href");
            } catch (NullPointerException e) {
                nextPageUrl = "";
            }
        } while (nextPageUrl != "");

        return listOfURL;
    }

    private static void addProductUrlFromSearchPage(String siteURL, String pageURL) {
        try {
            document = Jsoup.connect(pageURL).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements divs = document.getElementsByClass("product-image").select("a:not([target=_blank])");

        String path;

        for (Element div : divs) {
            path = div.getElementsByTag("a").attr("href");
            if (!path.startsWith("/o")) listOfURL.add(siteURL + path);
        }
    }
}
