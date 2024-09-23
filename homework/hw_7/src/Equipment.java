public class Equipment extends Product implements Commodity {
    //private int id;
    //private String name;
    private int star;
    // private long price;
    private String type;

    public Equipment(int id, String name, int star, long price, String type) {
        super(id, name, price);
        //this.id = id;
        //this.name = name;
        this.star = star;
        //this.price = price;
        this.type = type;
    }

    public void addStar() {
        star++;
    }
    //基本测试函数

    /*public String getEquName() {
        return name;
    }*/

    public int getStar() {
        return star;
    }

    /*public int getEquId() {
        return id;
    }*/

    public long getPrice() {
        return super.getProPrice();
    }

    public int getHitDec(int level, int hitNow) {
        return this.star * level;
    }

    public long getMoney() {
        return 0;
    }

}
