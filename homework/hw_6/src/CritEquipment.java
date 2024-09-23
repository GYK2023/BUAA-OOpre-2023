public class CritEquipment extends Equipment implements Commodity {
    private int critical;

    public CritEquipment(int id, String name, int star, long price, String type, int critical) {
        super(id, name, star, price, type);
        this.critical = critical;
    }

    @Override
    public int getHitDec(int level, int hitNow) {
        return super.getStar() * level + critical;
    }
}
