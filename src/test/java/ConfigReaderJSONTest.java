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
        assertEquals(Long.valueOf(1000),cr.getAnimationSpeed());
    }

    @Test
    public void isNumberOfGenerationsRead(){
        assertEquals(Long.valueOf(100),cr.getNumberOfGenerations());
    }

    @Test
    public void isGridSizeXRead(){
        assertEquals(Long.valueOf(60),cr.getGridSizeX());
    }

    @Test
    public void isGridSizeYRead(){
        assertEquals(Long.valueOf(40),cr.getGridSizeY());
    }
}
