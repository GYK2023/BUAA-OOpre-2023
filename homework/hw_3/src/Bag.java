import java.util.Comparator;
import java.util.HashMap;
import java.util.ArrayList;

public class Bag {
    private HashMap<String,ArrayList<Integer>> bottles =
            new HashMap<String,ArrayList<Integer>>();
    private HashMap<String,Integer> equipments = new HashMap<String,Integer>();
    private HashMap<String,ArrayList<Integer>> foods =
            new HashMap<String,ArrayList<Integer>>();

    public Bag()
    {

    }

    public void takeEqu(Equipment equ)
    {
        equipments.put(equ.getEquName(),equ.getEquId());
    }

    public void removeBagEqu(String name,int id)
    {
        if (equipments.containsKey(name))
        {
            equipments.remove(name);
        }
    }

    public void takeBottle(Bottle bottle,int max)
    {
        //考虑maxBottle
        if (bottles.containsKey(bottle.getBottleName()))
        {
            if (bottles.get(bottle.getBottleName()).size() == max)
            {
                //nothing happen
            }
            else
            {
                if (!bottles.get(bottle.getBottleName()).contains(bottle.getBottleId()))
                {
                    bottles.get(bottle.getBottleName()).add(bottle.getBottleId());
                    bottles.get(bottle.getBottleName()).sort(Comparator.naturalOrder());
                }
            }
        }
        else {
            ArrayList<Integer> innerList = new ArrayList<>();
            bottles.put(bottle.getBottleName(),innerList);
            innerList.add(bottle.getBottleId());
        }

    }

    public void takeFood(Food food)
    {
        if (foods.containsKey(food.getFoodName()))
        {
            if (!foods.get(food.getFoodName()).contains(food.getFoodId()))
            {
                foods.get(food.getFoodName()).add(food.getFoodId());
                foods.get(food.getFoodName()).sort(Comparator.naturalOrder());
            }
        }
        else {
            ArrayList<Integer> innerList = new ArrayList<>();
            foods.put(food.getFoodName(),innerList);
            innerList.add(food.getFoodId());
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
}
