public class RecoverBottle extends Bottle implements Commodity {
    private double ratio;

    public RecoverBottle(int id, String name, int capacity, long price, String type, double ratio) {
        super(id, name, capacity, price, type);
        this.ratio = ratio;
    }

    @Override
    public int getBottleGain(int hitNow) {
        if (super.getBottleCapacity() == 0) {
            return 0;
        } else {
            int gain = (int) (ratio * hitNow);
            return gain;
        }

    }
}
