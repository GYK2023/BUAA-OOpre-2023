import org.junit.Test;

import static org.junit.Assert.*;

public class AdventurerTest {

    @Test
    public void addBottle() {
        Adventurer ad1 = new Adventurer(1,"first");
        ad1.addBottle(1,"fire",1);
        assert(ad1.getBottleCount()==1);
        Adventurer ad2 = new Adventurer(2,"first");
        ad1.addBottle(2,"fire",1);
        assert(ad1.getBottleCount()==2);
    }

    @Test
    public void deleteBottle() {
        Adventurer ad1 = new Adventurer(1,"first");
        ad1.addBottle(1,"fire",1);
        ad1.deleteBottle(1);
        assert(ad1.getBottleCount()==0);
        ad1.deleteBottle(2);
        assert(ad1.getBottleCount()==0);
    }

    @Test
    public void addEquipment() {
        Adventurer ad1 = new Adventurer(1,"first");
        ad1.addEquipment(1,"fire",1);
        assert(ad1.getEquCount()==1);
        Adventurer ad2 = new Adventurer(2,"first");
        ad1.addEquipment(2,"fire",1);
        assert(ad1.getEquCount()==2);
    }

    @Test
    public void deleteEquipment() {
        Adventurer ad1 = new Adventurer(1,"first");
        ad1.addEquipment(1,"fire",1);
        ad1.deleteEquipment(1);
        assert(ad1.getBottleCount()==0);
        ad1.deleteEquipment(2);
        assert(ad1.getBottleCount()==0);
    }

    @Test
    public void getAdvId() {
        Adventurer ad1 = new Adventurer(1,"first");
        assert(ad1.getAdvId()==1);
    }

    @Test
    public void getAdvName() {
        Adventurer ad1 = new Adventurer(1,"first");
        assert(ad1.getAdvName().equals("first"));
    }
}