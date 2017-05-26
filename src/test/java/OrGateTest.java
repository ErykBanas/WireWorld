import core.Coordinate;
import core.OrGate;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrGateTest {

    private OrGate orGate;

    @Before
    public void prepare(){
        orGate = new OrGate(3,2);
    }
    
    @Test
    public void isListCreated(){
        for (Coordinate coord: orGate.getObjectCells()) {
            System.out.println(coord);
        }
        assertEquals(orGate.getObjectCells().get(0),new Coordinate(3,3));
        assertEquals(orGate.getObjectCells().get(1),new Coordinate(3,4));
        assertEquals(orGate.getObjectCells().get(2),new Coordinate(3,5));
        assertEquals(orGate.getObjectCells().get(3),new Coordinate(2,4));
        assertEquals(orGate.getObjectCells().get(4),new Coordinate(4,4));
    }
    
}
