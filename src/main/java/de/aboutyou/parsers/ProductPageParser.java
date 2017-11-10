package de.aboutyou.parsers;

import de.aboutyou.holders.ProductHolder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * ProductPageParser
 * Class that get data from web-page and return ProductHolder instance
 *
 * @author Michael Rudyy
 * @version 1.6
 */

public class ProductPageParser {

    static Document document;

    public static ProductHolder parseDataFromProductPage(String url) throws IOException {
        document = Jsoup.connect(url).get();
        ProductHolder holder = new ProductHolder();

        getName(holder);
        getArticleID(holder, url);
        getBrand(holder);
        getColor(holder);
        getDescription(holder);
        getPrice(holder);
        getShippingCosts(holder);

        return holder;
    }

    /**
     * Get name from page
     *
     * @param holder
     */
    private static void getName(ProductHolder holder) {
        Element element = document.getElementsByClass("name_1jqcvyg").first();
        if (element == null) {
            holder.setName("");
        } else {
            holder.setName(element.text());
        }
    }

    /**
     * Get brand from page
     *
     * @param holder
     */
    private static void getBrand(ProductHolder holder) {
        Element element = document.getElementsByClass("image_trzoj8").first();
        if (element == null) {
            element = document.getElementsByClass("image_1et7l3n").first();
            if (element == null) {
                holder.setBrand("");

            } else {
                holder.setBrand(element.attr("alt"));
            }
        } else {
            holder.setBrand(element.attr("alt"));
        }
    }

    /**
     * It cant get color because page dont contain data about color ,
     * exception - if there is several colors , but jSoup cant find theme
     *
     * @param holder
     */
    private static void getColor(ProductHolder holder) {
        holder.setColor("");
    }

    /**
     * Get price from page
     * There is several type of pages , so using selection program finds currect price
     * If there isnt discont initailPrice will be ""
     *
     * @param holder
     */
    private static void getPrice(ProductHolder holder) {
        Element priceElement = null;
        priceElement = document.getElementsByClass("finalPrice_klth9m").last();
        if (priceElement == null) {
            try {
                priceElement = document.selectFirst("span[class^='finalPrice']").children().last();
            } catch (NullPointerException e) {
            }
            if (priceElement == null) {
                priceElement = document.selectFirst("span[class^='finalPrice']");
            }
            if (priceElement == null) {
                holder.setPrice("");
                holder.setInitialPrice("");
                return;
            } else {
                getInitialPrice(holder);
            }
        } else {
            if (priceElement.html().contains("span")) {
                priceElement = priceElement.children().select("span").last();
            }
            holder.setInitialPrice("");
        }

        holder.setPrice(formatPrice(priceElement.html()));
    }

    /**
     * Run from {@code getPrice}
     * Contains data if there is discont
     *
     * @param holder
     */
    private static void getInitialPrice(ProductHolder holder) {
        Element element = document.select("span[class^='originalPrice']").first().children().tagName("span").last();
        if (element != null) {
            holder.setInitialPrice(formatPrice(element.html()));
        } else {
            element = document.selectFirst("span[class^='originalPrice']");
            if (element == null) {
                holder.setInitialPrice("");
            } else {
                holder.setInitialPrice(formatPrice(element.html()));
            }
        }
    }

    /**
     * Get Description
     *
     * @param holder
     */
    private static void getDescription(ProductHolder holder) {
        Element element = document.getElementsByClass("outerWrapper_gdz8cm").first();
        if (element == null) {
            holder.setDescription("");
        } else {
            holder.setDescription(element.text());
        }
    }

    /**
     * Get id from url
     *
     * @param holder
     * @param pageUrl
     */
    private static void getArticleID(ProductHolder holder, String pageUrl) {
        holder.setArticleID(pageUrl.substring(pageUrl.length() - 7, pageUrl.length()));
    }

    /**
     * All shipping is free
     *
     * @param holder
     */
    private static void getShippingCosts(ProductHolder holder) {
        holder.setShippingCosts("0");
    }

    /**
     * Delete currency symbol
     *
     * @param price
     * @return
     */
    private static String formatPrice(String price) {
        return price.substring(0, price.length() - 1);
    }
}
