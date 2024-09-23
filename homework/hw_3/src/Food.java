public class Food {
    private int id;
    private String name;
    private int energy;

    public Food(int id, String name, int energy)
    {
        this.id = id;
        this.name = name;
        this.energy = energy;
    }

    public int getFoodId()
    {
        return this.id;
    }

    public String getFoodName()
    {
        return this.name;
    }

    public int getFoodEnergy()
    {
        return this.energy;
    }

}
