package de.aboutyou.parsers;

/**
 * Created by Michael Rudyy on 09-Nov-17.
 */

/**
 * SearchURLBuilder
 * Class that just helps to get search URL by gender
 *
 * @author Michael Rudyy
 * @version 1.0
 */

public class SearchURLBuilder {
    private static String MALE_SEARCH_URL = "https://www.aboutyou.de/suche?fromCategory=20202&gender=male&term=";
    private static String FEMALE_SEARCH_URL = "https://www.aboutyou.de/suche?fromCategory=20201&gender=female&term=";
    private static String KID_SEARCH_URL = "https://www.aboutyou.de/suche?gender=kids&fromCategory=138113&term=";

    public static String getMaleSearchURL(String searchRequest) {
        return MALE_SEARCH_URL + searchRequest;
    }

    public static String getFemaleSearchURL(String searchRequest) {
        return FEMALE_SEARCH_URL + searchRequest;
    }

    public static String getKidSearchURL(String searchRequest) {
        return KID_SEARCH_URL + searchRequest;
    }
}
