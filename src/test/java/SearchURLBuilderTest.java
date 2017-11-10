import de.aboutyou.parsers.SearchURLBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Michael Rudyy on 09-Nov-17.
 */
public class SearchURLBuilderTest {
    @Test
    public void testFemaleSearch(){
        String searchURL = SearchURLBuilder.getFemaleSearchURL("aa");
        assertEquals(searchURL,"https://www.aboutyou.de/suche?fromCategory=20201&gender=female&term=aa");
    }

    @Test
    public void testMaleSearch(){
        String searchURL = SearchURLBuilder.getMaleSearchURL("aa");
        assertEquals(searchURL,"https://www.aboutyou.de/suche?fromCategory=20202&gender=male&term=aa");
    }

    @Test
    public void testKidSearch(){
        String searchURL = SearchURLBuilder.getKidSearchURL("aa");
        assertEquals(searchURL,"https://www.aboutyou.de/suche?gender=kids&fromCategory=138113&term=aa");
    }


}
