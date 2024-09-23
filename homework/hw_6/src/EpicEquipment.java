public class EpicEquipment extends Equipment implements Commodity {
    private double ratio;

    public EpicEquipment(int id, String name, int star, long price, String type, double ratio) {
        super(id, name, star, price, type);
        this.ratio = ratio;
    }

    @Override
    public int getHitDec(int level, int hitNow) {
        return (int) (ratio * hitNow);
    }
}
