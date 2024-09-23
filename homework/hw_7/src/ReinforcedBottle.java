public class ReinforcedBottle extends Bottle implements Commodity {
    private double ratio;

    public ReinforcedBottle(int id,String name,int capacity,long price,String type,double ratio) {
        super(id, name, capacity, price, type);
        this.ratio = ratio;
    }

    @Override
    public int getBottleGain(int hitNow) {
        //可能存在问题 注意类型转换
        int gain = (int) ((1 + ratio) * getBottleCapacity());
        return gain;
    }
}
