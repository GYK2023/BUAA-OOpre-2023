import org.junit.Test;

import static org.junit.Assert.*;

public class BottleTest {

    @Test
    public void getBottleName() {
        Bottle bottle = new Bottle(1,"water",5);
        assert(bottle.getBottleName().equals("water"));
    }

    @Test
    public void getBottleId() {
        Bottle bottle = new Bottle(2,"wind",4);
        assert(bottle.getBottleId()==2);
    }

    @Test
    public void getBottleCapacity() {
        Bottle bottle = new Bottle(2,"wind",3);
        assert(bottle.getBottleCapacity()==3);
    }
}