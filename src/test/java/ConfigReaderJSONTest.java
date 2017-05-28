import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import utils.ConfigReader;
import utils.ConfigReaderJSON;

import java.io.File;

import static junit.framework.TestCase.assertEquals;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConfigReaderJSONTest {

    File file;
    ConfigReader cr;

    @Before
    public void CreateConfigObject(){
        cr = ConfigReaderJSON.getInstance();
        file = new File("config.json");
        cr.read(file);
    }

    @Test
    public void isAnimationSpeedRead(){
        assertEquals(1000,cr.getAnimationSpeed());
    }

    @Test
    public void isNumberOfGenerationsRead(){
        assertEquals(100,cr.getNumberOfGenerations());
    }

    @Test
    public void isGridSizeXRead(){
        assertEquals(30,cr.getGridSizeX());
    }

    @Test
    public void isGridSizeYRead(){
        assertEquals(20,cr.getGridSizeY());
    }
}
