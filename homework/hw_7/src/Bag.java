import java.util.Comparator;
import java.util.HashMap;
import java.util.ArrayList;

public class Bag {
    private HashMap<String,ArrayList<Integer>> bottles =
            new HashMap<String,ArrayList<Integer>>();
    private HashMap<String,Equipment> equipments = new HashMap<String,Equipment>();
    private HashMap<String,ArrayList<Integer>> foods =
            new HashMap<String,ArrayList<Integer>>();

    public Bag()
    {

    }

    public void takeEqu(Equipment equ)
    {
        equipments.put(equ.getProName(),equ);
    }

    public void removeBagEqu(String name,int id)
    {
        //同名装备需要进行id校验再进行删除
        if (equipments.containsKey(name) && equipments.get(name).getProId() == id)
        {
            equipments.remove(name);
        }
    }

    public void takeBottle(Bottle bottle,int max)
    {
        //考虑maxBottle
        if (bottles.containsKey(bottle.getProName()))
        {
            if (bottles.get(bottle.getProName()).size() == max)
            {
                //nothing happen
            }
            else
            {
                if (!bottles.get(bottle.getProName()).contains(bottle.getProId()))
                {
                    bottles.get(bottle.getProName()).add(bottle.getProId());
                    bottles.get(bottle.getProName()).sort(Comparator.naturalOrder());
                }
            }
        }
        else {
            ArrayList<Integer> innerList = new ArrayList<>();
            bottles.put(bottle.getProName(),innerList);
            innerList.add(bottle.getProId());
        }

    }

    public void takeFood(Food food)
    {
        if (foods.containsKey(food.getProName()))
        {
            if (!foods.get(food.getProName()).contains(food.getProId()))
            {
                foods.get(food.getProName()).add(food.getProId());
                foods.get(food.getProName()).sort(Comparator.naturalOrder());
            }
        }
        else {
            ArrayList<Integer> innerList = new ArrayList<>();
            foods.put(food.getProName(),innerList);
            innerList.add(food.getProId());
        }
    }

    public int useBottle(String name)
    {
        if (bottles.containsKey(name))
        {
            return bottles.get(name).get(0);
        }
        else
        {
            return -1;
        }
    }

    public void removeBagBottle(String name,int id)
    {

        if (bottles.containsKey(name))
        {
            if (bottles.get(name).contains(id))
            {
                bottles.get(name).remove(Integer.valueOf(id));
                bottles.get(name).sort(Comparator.naturalOrder());
                if (bottles.get(name).isEmpty())
                {
                    bottles.remove(name);
                }

            }

        }

    }

    public int eatFood(String name)
    {
        if (foods.containsKey(name))
        {
            final int id = foods.get(name).get(0);
            foods.get(name).remove(0);
            foods.get(name).sort(Comparator.naturalOrder());
            if (foods.get(name).isEmpty())
            {
                foods.remove(name);
            }
            return id;
        }
        else
        {
            return -1;
        }
    }

    public void removeBagFood(String name, int id)
    {
        if (foods.containsKey(name))
        {
            if (foods.get(name).contains(id))
            {
                foods.get(name).remove(Integer.valueOf(id));
                foods.get(name).sort(Comparator.naturalOrder());
                if (foods.get(name).isEmpty())
                {
                    foods.remove(name);
                }
            }

        }
    }

    public int getBottleSize(String name)
    {
        if (bottles.containsKey(name))
        {
            return bottles.get(name).size();
        }
        else
        {
            return 0;
        }
    }

    public int getFoodSize(String name)
    {
        if (foods.containsKey(name))
        {
            return foods.get(name).size();
        }
        else
        {
            return 0;
        }
    }

    public HashMap<String,ArrayList<Integer>> getBotInBag()
    {
        return bottles;
    }

    public HashMap<String,Equipment> getEquInBag()
    {
        return equipments;
    }

    public HashMap<String,ArrayList<Integer>> getFoodInBag()
    {
        return foods;
    }

    public void clearAll() {
        bottles.clear();
        foods.clear();
        equipments.clear();
    }
}
