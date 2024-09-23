import java.util.HashMap;

public class Adventurer {
    private HashMap<Integer,Bottle> bottles = new HashMap<Integer,Bottle>();
    private HashMap<Integer,Equipment> equipments = new HashMap<Integer,Equipment>();
    private int id;

    private String name;

    public Adventurer(int id,String name)
    {
        this.id = id;
        this.name = name;
    }

    public void addBottle(int id,String name,int capacity)
    {
        Bottle bottle = new Bottle(id,name,capacity);
        bottles.put(id,bottle);
    }

    public void deleteBottle(int id)
    {
        if (bottles.containsKey(id))
        {
            String name = bottles.get(id).getBottleName();
            bottles.remove(id);
            int size = bottles.size();
            System.out.println(size + " " + name);
        }
        else
        {
            System.out.println("Don't find this bottle!");
        }
    }

    public void addEquipment(int id,String name,int star)
    {
        Equipment equipment = new Equipment(id,name,star);
        equipments.put(id,equipment);
    }

    public void deleteEquipment(int id)
    {
        if (equipments.containsKey(id))
        {
            String name = equipments.get(id).getEquName();
            equipments.remove(id);
            int size = equipments.size();
            System.out.println(size + " " + name);
        }
        else
        {
            System.out.println("Don't find this equipment!");
        }
    }

    public void improveStar(int id)
    {
        if (equipments.containsKey(id))
        {
            equipments.get(id).addStar();
            String name = equipments.get(id).getEquName();
            int star = equipments.get(id).getStar();
            System.out.println(name + " " + star);
        }
        else
        {
            System.out.println("Don't find this equipment!");
        }
    }

    //基础测试函数

    public int getAdvId()
    {
        return id;
    }

    public String getAdvName()
    {
        return name;
    }

    public int getBottleCount()
    {
        return bottles.size();
    }

    public int getEquCount()
    {
        return equipments.size();
    }

}
