import java.util.HashMap;

public class Adventurer {
    private HashMap<Integer,Bottle> bottles = new HashMap<Integer,Bottle>();
    private HashMap<Integer,Equipment> equipments = new HashMap<Integer,Equipment>();
    private HashMap<Integer,Food> foods = new HashMap<Integer,Food>();
    private Bag bag = new Bag();

    private int id;

    private String name;
    private int level;
    private int hitPoint;
    private int maxBottle;

    public Adventurer(int id,String name)
    {
        this.id = id;
        this.name = name;
        this.level = 1;
        this.hitPoint = 500;
        this.maxBottle = 1;
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
            bag.removeBagBottle(name,id);
            bottles.remove(id);
            int size = bottles.size();
            System.out.println(size + " " + name);
        }
        else
        {
            System.out.println("Fail to find this bottle!");
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
            bag.removeBagEqu(name,id);
            equipments.remove(id);
            int size = equipments.size();
            System.out.println(size + " " + name);
        }
        else
        {
            System.out.println("Fail to find this equipment!");
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
            System.out.println("Fail to find this equipment!");
        }
    }

    public void addFood(int id, String name, int energy)
    {
        Food food = new Food(id,name,energy);
        foods.put(id,food);
    }

    public void deleteFood(int id)
    {
        if (foods.containsKey(id))
        {
            String name = foods.get(id).getFoodName();
            bag.removeBagFood(name,id);
            foods.remove(id);
            int size = foods.size();
            System.out.println(size + " " + name);
        }
        else
        {
            System.out.println("Fail to find this food!");
        }
    }

    public void takeEqu(int id)
    {
        if (equipments.containsKey(id))
        {
            bag.takeEqu(equipments.get(id));
        }
        else
        {
            //待完善
        }
    }

    public void takeBottle(int id)
    {
        if (bottles.containsKey(id))
        {
            bag.takeBottle(bottles.get(id),maxBottle);
        }
        else {
            //
        }
    }

    public void takeFood(int id)
    {
        if (foods.containsKey(id))
        {
            bag.takeFood(foods.get(id));
        }
        else {
            //
        }
    }

    public void useBottle(String name)
    {
        int target = bag.useBottle(name);
        if (target != -1)
        {
            if (bottles.get(target).getBottleCapacity() == 0)
            {
                //药水瓶为空，丢弃
                bottles.remove(target);
                bag.removeBagBottle(name,target);
            }
            else
            {
                //使用药水并将容量清空
                hitPoint += bottles.get(target).getBottleCapacity();
                bottles.get(target).clearBottle();
            }
            System.out.println(target + " " + hitPoint);
        }
        else
        {
            System.out.println("fail to use " + name);
        }
    }

    public void eatFood(String name)
    {
        int target = bag.eatFood(name);
        if (target != -1)
        {
            level += foods.get(target).getFoodEnergy();
            foods.remove(target);
            maxBottle = level / 5 + 1;
            System.out.println(target + " " + level);
        }
        else
        {
            System.out.println("fail to eat " + name);
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

    public int getBottleSize(String name)
    {
        return bag.getBottleSize(name);
    }

    public int getFoodSize(String name)
    {
        return bag.getFoodSize(name);
    }

}
