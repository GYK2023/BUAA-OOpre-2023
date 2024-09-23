public class Bottle {
    private int id;
    private String name;
    private int capacity;

    public Bottle(int id,String name,int capacity)
    {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }

    public void clearBottle()
    {
        capacity = 0;
    }
    //测试基本函数

    public String getBottleName()
    {
        return this.name;
    }

    public int getBottleId()
    {
        return id;
    }

    public int getBottleCapacity()
    {
        return capacity;
    }
}
