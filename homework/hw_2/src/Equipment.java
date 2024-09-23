public class Equipment {
    private int id;
    private String name;
    private int star;

    public Equipment(int id,String name,int star)
    {
        this.id = id;
        this. name = name;
        this.star = star;
    }

    public void addStar()
    {
        star++;
    }
    //基本测试函数

    public String getEquName()
    {
        return name;
    }

    public int getStar()
    {
        return star;
    }

    public int getEquId()
    {
        return id;
    }
}
