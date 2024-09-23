public class Food extends Product implements Commodity {
    //private int id;
    //private String name;
    private int energy;
    //private long price;

    public Food(int id, String name, int energy, long price) {
        super(id, name, price);
        //this.id = id;
        //this.name = name;
        this.energy = energy;
        // this.price = price;
    }

    /*public int getFoodId() {
        return this.id;
    }*/

    /*public String getFoodName() {
        return this.name;
    }*/

    public int getFoodEnergy() {
        return this.energy;
    }

    public long getPrice() {
        return super.getProPrice();
    }

    public long getMoney() {
        return 0;
    }
}
