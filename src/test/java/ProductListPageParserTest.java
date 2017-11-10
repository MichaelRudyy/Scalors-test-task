import de.aboutyou.holders.ProductHolder;
import de.aboutyou.parsers.ProductPageParser;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Michael Rudyy on 09-Nov-17.
 */

public class ProductListPageParserTest {
    @Test
    public void checkNormalPage() throws IOException {
        ProductHolder testHolder = new ProductHolder("Slim Fit Jeans 'TIM ORIGINAL AM 421'",
                "JACK & JONES",
                "",
                "39,99",
                "",
                "Produktdetails JACK & JONES | Slim Fit Jeans 'TIM ORIGINAL AM 421' Design Knopfleiste " +
                        "5-Pocket-Style Unifarben Extras Kontrastnähte Label Patch/Label Flag Used-Look Gürtelschlaufen " +
                        "Blue denim/washed Artikel-Nr: 5713448340922 Materialzusammensetzung Zusammensetzung: 98 % Baumwolle, " +
                        "2 % Elasthan Pflegehinweise Elastizität: Leicht elastisch Größe Länge: Lang/Maxi Passform: Regular"
                ,"3663620","0");
        assertEquals(testHolder.toString(),
                ProductPageParser.
                        parseDataFromProductPage("https://www.aboutyou.de/p/jack-und-jones/slim-fit-jeans-tim-original-am-421-3663620")
                        .toString());
    }

    @Test
    public void checkSoldPage() throws IOException {
        ProductHolder testHolder = new ProductHolder("Jeans 'Razor'",
                "DENHAM",
                "",
                "",
                "",
                ""
                ,"3673254","0");
        assertEquals(testHolder.toString(),
                ProductPageParser.
                        parseDataFromProductPage("https://www.aboutyou.de/p/denham/jeans-razor-3673254")
                        .toString());
    }

    @Test
    public void checkDiscontPage() throws IOException {
        ProductHolder testHolder = new ProductHolder("Pullover 'Italienischer Hengst V'",
                "naketano",
                "",
                "18,90",
                "27,90",
                "Produktdetails naketano | Pullover 'Italienischer Hengst V' Design Gerader Saum Gerader " +
                        "Schnitt Rippbündchen Unifarben Sweatstoff Rundhals-Ausschnitt Extras Glatter Stoff Weicher " +
                        "Griff Artikel-Nr: NAK0748004000003 Materialzusammensetzung Obermaterial: 50 % Baumwolle, 50 " +
                        "% Polyester Pflegehinweise Elastizität: Leicht elastisch 30 °C Wäsche Nicht trocknergeeignet " +
                        "Nicht chemisch reinigen Nicht heiß bügeln Nicht bleichen Größe Ärmellänge: Langarm Passform: " +
                        "Normale Passform"
                ,"3642998","0");
        assertEquals(testHolder.toString(),
                ProductPageParser.
                        parseDataFromProductPage("https://www.aboutyou.de/p/naketano/pullover-italienischer-hengst-v-3642998")
                        .toString());
    }

    @Test
    public void checkAbPage() throws IOException {
        ProductHolder testHolder = new ProductHolder("Funktionsjacke 'Limford jacket III'",
                "VAUDE",
                "",
                "199,00",
                "",
                "Produktdetails VAUDE | Funktionsjacke 'Limford jacket III' Beschreibung Die Funktionsjacke " +
                        "'Limford jacket III' von Vaude hält dich warm und trocken, ohne zu beschweren. Dabei ist sie " +
                        "natürlich atmungsaktiv und bietet optimalen Tragekomfort. Tunnelzug am Bund Abnehmbare Kapuze " +
                        "mit Tunnelzug Atmungsaktiv Verstellbare Ärmelbündchen Wasserdicht Leicht und komprimierbar " +
                        "Weich und warm, ohne schwer zu sein Artikel-Nr: VAU0007001000002 Materialzusammensetzung " +
                        "Obermaterial: 95 % Polyester, 5 % Leinen Membran: 100 % Polyurethan Futter: 100 % Nylon " +
                        "Wattierung: 100 % Polyester Größe Passform: Normale Passform"
                ,"3530237","0");
        assertEquals(testHolder.toString(),
                ProductPageParser.
                        parseDataFromProductPage("https://www.aboutyou.de/p/vaude/funktionsjacke-limford-jacket-iii-3530237")
                        .toString());
    }
}
