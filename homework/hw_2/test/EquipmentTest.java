import org.junit.Test;

import static org.junit.Assert.*;

public class EquipmentTest {

    @Test
    public void addStar() {
        Equipment tool = new Equipment(1,"stick",1);
        tool.addStar();
        assert(tool.getStar()==2);
    }

    @Test
    public void getEquName() {
        Equipment tool = new Equipment(1,"stick",1);
        assert(tool.getEquName().equals("stick"));
    }

    @Test
    public void getStar() {
        Equipment tool = new Equipment(1,"stick",2);
        assert(tool.getStar()==2);
    }

    @Test
    public void getEquId() {
        Equipment tool = new Equipment(1,"stick",1);
        assert(tool.getEquId()==1);
    }
}