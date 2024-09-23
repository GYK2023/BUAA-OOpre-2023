import java.util.ArrayList;

public class Store {
    private static Store store;
    private static ArrayList<Integer> bottleLog = new ArrayList<Integer>();
    private static long bottlePrice = 0;
    private static ArrayList<Integer> equLog = new ArrayList<Integer>();
    private static long equPrice = 0;
    private static ArrayList<Integer> foodLog = new ArrayList<Integer>();
    private static long foodPrice = 0;

    public static Store getInstance() {
        if (store == null) {
            store = new Store();
        }
        return store;
    }

    public static void buyInBot(int cap, long price) {
        bottleLog.add(cap);
        bottlePrice += price;
    }

    public static void buyInEqu(int star, long price) {
        equLog.add(star);
        equPrice += price;
    }

    public static void buyInFood(int energy, long price) {
        foodLog.add(energy);
        foodPrice += price;
    }

    public static int botCap() {
        if (bottleLog.size() != 0) {
            int total = 0;
            for (Integer cap : bottleLog) {
                total += cap;
            }
            return (int) (total / bottleLog.size());
        } else {
            return 0;
        }
    }

    public static int equStar() {
        if (equLog.size() != 0) {
            int total = 0;
            for (Integer star : equLog) {
                total += star;
            }
            return (int) (total / equLog.size());
        } else {
            return 0;
        }
    }

    public static int foodEnergy() {
        if (foodLog.size() != 0) {
            int total = 0;
            for (Integer energy : foodLog) {
                total += energy;
            }
            return (int) (total / foodLog.size());
        } else {
            return 0;
        }

    }

    public static long creat(ArrayList<String> s, Adventurer adv) {
        int id = Integer.parseInt(s.get(2));
        String name = s.get(3);
        long target = 0;
        long price1 = 0;
        long price2 = 0;
        long price3 = 0;
        //bottle
        int capacity = botCap();
        if (bottleLog.size() != 0) {
            price1 = (long) (bottlePrice / bottleLog.size());
        }
        //equipment
        int star = equStar();
        if (equLog.size() != 0) {
            price2 = (long) (equPrice / equLog.size());
        }
        //food
        int energy = foodEnergy();
        if (foodLog.size() != 0) {
            price3 = (long) (foodPrice / foodLog.size());
        }

        String type = s.get(4);
        if (type.contains("Bottle")) {
            target = price1;
        } else if (type.contains("Equipment")) {
            target = price2;
        } else if (type.equals("Food")) {
            target = price3;
        }
        long money = adv.getMoney();
        if (type.equals("RegularBottle") && money >= price1) {
            adv.addBottle(id, name, capacity, price1, type, 0.0);
            return price1;
            //return new RegularBottle(id,name,capacity,price1,type);
        } else if (type.equals("RecoverBottle") && money >= price1) {
            double ratio = Double.parseDouble(s.get(5));
            adv.addBottle(id, name, capacity, price1, type, ratio);
            return price1;
            //return new RecoverBottle(id,name,capacity,price1,type,ratio);
        } else if (type.equals("ReinforcedBottle") && money >= price1) {
            double ratio = Double.parseDouble(s.get(5));
            adv.addBottle(id, name, capacity, price1, type, ratio);
            return price1;
            //return new RecoverBottle(id,name,capacity,price1,type,ratio);
        } else if (type.equals("RegularEquipment") && money >= price2) {
            adv.addEquipment(id, name, star, price2, type, "");
            return price2;
            //return new RegularEquipment(id,name,star,price2,type);
        } else if (type.equals("CritEquipment") && money >= price2) {
            //int critical = Integer.parseInt(s.get(5));
            adv.addEquipment(id, name, star, price2, type, s.get(5));
            return price2;
            //return new CritEquipment(id,name,star,price2,type,critical);
        } else if (type.equals("EpicEquipment") && money >= price2) {
            //double ratio = Double.parseDouble(s.get(5));
            adv.addEquipment(id, name, star, price2, type, s.get(5));
            return price2;
            //return new EpicEquipment(id,name,star,price2,type,ratio);
        } else if (type.equals("Food") && money >= price3) {
            adv.addFood(id, name, energy, price3);
            return price3;
            //return new Food(id,name,energy,price3);
        }
        System.out.print("failed to buy ");
        System.out.print(name);
        System.out.print(" for ");
        System.out.println(target);
        return -1;
    }

}
