import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Adventurer implements Commodity {
    private HashMap<Integer, Bottle> bottles = new HashMap<Integer, Bottle>();
    private HashMap<Integer, Equipment> equipments = new HashMap<Integer, Equipment>();
    private HashMap<Integer, Food> foods = new HashMap<Integer, Food>();
    private Bag bag = new Bag();

    private int id;

    private String name;
    private int level;
    private int hitPoint;
    private int maxBottle;
    private long money;//金钱数
    private long price;//总价值
    //private long maxPrice = 0;
    private HashMap<Integer, Commodity> commodities = new HashMap<Integer, Commodity>();
    private ArrayList<Adventurer> follower = new ArrayList<Adventurer>();

    public Adventurer(int id, String name) {
        this.id = id;
        this.name = name;
        this.level = 1;
        this.hitPoint = 500;
        this.maxBottle = 1;
        this.price = 0;
        this.money = 0;
    }

    public void addBottle(int id, String name,int capacity, long price, String type, double ratio) {
        //this.price += price;
        if (type.equals("RegularBottle")) {
            Bottle bottle = new RegularBottle(id, name, capacity, price, type);
            bottles.put(id, bottle);
            commodities.put(id, bottle);
        } else if (type.equals("RecoverBottle")) {
            Bottle bottle = new RecoverBottle(id, name, capacity, price, type, ratio);
            bottles.put(id, bottle);
            commodities.put(id, bottle);
        } else if (type.equals("ReinforcedBottle")) {
            Bottle bottle = new ReinforcedBottle(id, name, capacity, price, type, ratio);
            bottles.put(id, bottle);
            commodities.put(id, bottle);
        }
        //Bottle bottle = new Bottle(id,name,capacity);
        //bottles.put(id,bottle);
    }

    public void deleteBottle(int id) {
        if (bottles.containsKey(id)) {
            String name = bottles.get(id).getProName();
            bag.removeBagBottle(name, id);
            //更改：卖出瓶子
            this.money = this.money + bottles.get(id).getPrice();
            bottles.remove(id);
            //this.price -= commodities.get(id).getPrice();
            commodities.remove(id);
            int size = bottles.size();
            System.out.println(size + " " + name);
        } else {
            System.out.println("Fail to find this bottle!");
        }
    }

    public void addEquipment(int id,String name, int star, long price, String type, String others) {
        //this.price += price;
        if (type.equals("RegularEquipment")) {
            Equipment equipment = new RegularEquipment(id, name, star, price, type);
            equipments.put(id, equipment);
            commodities.put(id, equipment);
        } else if (type.equals("CritEquipment")) {
            Equipment equipment =
                    new CritEquipment(id, name, star, price, type, Integer.parseInt(others));
            equipments.put(id, equipment);
            commodities.put(id, equipment);
        } else if (type.equals("EpicEquipment")) {
            Equipment equipment =
                    new EpicEquipment(id, name, star, price, type, Double.parseDouble(others));
            equipments.put(id, equipment);
            commodities.put(id, equipment);
        }
        //Equipment equipment = new Equipment(id,name,star,price,type);
        //equipments.put(id,equipment);
    }

    public void deleteEquipment(int id) {
        if (equipments.containsKey(id)) {
            String name = equipments.get(id).getProName();
            bag.removeBagEqu(name, id);
            //更改
            this.money += equipments.get(id).getPrice();
            equipments.remove(id);
            //price -= commodities.get(id).getPrice();
            commodities.remove(id);
            int size = equipments.size();
            System.out.println(size + " " + name);
        } else {
            System.out.println("Fail to find this equipment!");
        }
    }

    public void improveStar(int id) {
        if (equipments.containsKey(id)) {
            equipments.get(id).addStar();
            String name = equipments.get(id).getProName();
            int star = equipments.get(id).getStar();
            System.out.println(name + " " + star);
        } else {
            System.out.println("Fail to find this equipment!");
        }
    }

    public void addFood(int id, String name, int energy, long price) {
        //this.price += price;
        Food food = new Food(id, name, energy, price);
        foods.put(id, food);
        commodities.put(id, food);
    }

    public void deleteFood(int id) {
        if (foods.containsKey(id)) {
            String name = foods.get(id).getProName();
            bag.removeBagFood(name, id);
            //更改
            this.money += foods.get(id).getPrice();
            foods.remove(id);
            //this.price -= commodities.get(id).getPrice();
            commodities.remove(id);
            int size = foods.size();
            System.out.println(size + " " + name);
        } else {
            System.out.println("Fail to find this food!");
        }
    }

    public void takeEqu(int id) {
        if (equipments.containsKey(id)) {
            bag.takeEqu(equipments.get(id));
        } else {
            //待完善
        }
    }

    public void takeBottle(int id) {
        if (bottles.containsKey(id)) {
            bag.takeBottle(bottles.get(id), maxBottle);
        } else {
            //
        }
    }

    public void takeFood(int id) {
        if (foods.containsKey(id)) {
            bag.takeFood(foods.get(id));
        } else {
            //
        }
    }

    public void useBottle(String name) {
        int target = bag.useBottle(name);
        if (target != -1) {
            if (bottles.get(target).checkEmpty()) {
                //药水瓶为空，丢弃
                bottles.remove(target);
                commodities.remove(target);
                bag.removeBagBottle(name, target);
            } else {
                //使用药水并将容量清空
                hitPoint += bottles.get(target).getBottleGain(hitPoint);
                bottles.get(target).clearBottle();
            }

            System.out.println(target + " " + hitPoint);
        } else {
            System.out.println("fail to use " + name);
        }
    }

    public void eatFood(String name) {
        int target = bag.eatFood(name);
        if (target != -1) {
            level += foods.get(target).getFoodEnergy();
            foods.remove(target);
            commodities.remove(target);
            maxBottle = level / 5 + 1;
            System.out.println(target + " " + level);
        } else {
            System.out.println("fail to eat " + name);
        }
    }
    //基础测试函数

    public int getAdvId() {
        return id;
    }

    public String getAdvName() {
        return name;
    }

    public int getAdvLevel() {
        return level;
    }

    public int getAdvHit() {
        return hitPoint;
    }

    public int getBottleCount() {
        return bottles.size();
    }

    public int getEquCount() {
        return equipments.size();
    }

    public int getBottleSize(String name) {
        return bag.getBottleSize(name);
    }

    public int getFoodSize(String name) {
        return bag.getFoodSize(name);
    }

    public boolean takenBottle(String name) {
        return bag.getBotInBag().containsKey(name);
    }

    public boolean takenFood(String name) {
        return bag.getFoodInBag().containsKey(name);
    }

    public Equipment takenEqu(String name) {
        if (bag.getEquInBag().containsKey(name)) {
            return bag.getEquInBag().get(name);
            //return bag.getEquInBag().get(name).getStar();
        } else {
            return null;
        }
    }

    public int getAttacked(Equipment weapon, int level) {
        this.hitPoint = this.hitPoint - weapon.getHitDec(level, hitPoint);
        //this.hitPoint = this.hitPoint - star * level;
        return this.hitPoint;
    }

    public long getPrice() {
        long total = money;//
        for (Map.Entry<Integer, Commodity> entry : commodities.entrySet()) {
            /*if(entry.getValue().getClass().getName().equals("Adventurer")){
                total += entry.getValue().getMoney();
            }*/
            total += entry.getValue().getPrice();
        }
        return total;
    }

    public void hire(int id, Adventurer ad) {
        //this.price += ad.getPrice();
        commodities.put(id, ad);
        //多次雇佣可能有问题
        if (!follower.contains(ad)) {
            follower.add(ad);
        }
    }

    public int getComSize() {
        return commodities.size();
    }

    public long getMax() {
        long max = 0;
        for (Map.Entry<Integer, Commodity> entry : commodities.entrySet()) {
            if (entry.getValue().getPrice() > max) {
                max = entry.getValue().getPrice();
            }
        }
        return max;
    }

    public long getTotalPrice() {
        long total = 0;
        for (Map.Entry<Integer, Commodity> entry : commodities.entrySet()) {
            total += entry.getValue().getPrice();
        }
        return total;
    }

    public String searchClass(int id) {
        Commodity com = commodities.get(id);
        return (com.getClass().getName());
    }

    public ArrayList<Adventurer> getFollowers() {
        return this.follower;
    }

    /*public Bottle getBot(int id) {
        return bottles.get(id);
    }*/

    public int getBotCap(int id) {
        return bottles.get(id).getBottleCapacity();
    }

    public long getBotPrice(int id) {
        return bottles.get(id).getPrice();
    }

    public int getEquStar(int id) {
        return equipments.get(id).getStar();
    }

    public long getEquPrice(int id) {
        return equipments.get(id).getPrice();
    }

    public int getFoodEn(int id) {
        return foods.get(id).getFoodEnergy();
    }

    public long getFoodPrice(int id) {
        return foods.get(id).getPrice();
    }

    public long sellAll() {
        ArrayList<Integer> idToBeRemove = new ArrayList<Integer>();

        //先结算再删除
        //Bottle
        long totalPrice = 0;
        for (Map.Entry<String, ArrayList<Integer>> entry : bag.getBotInBag().entrySet()) {
            for (Integer id0 : entry.getValue()) {
                int cap = getBotCap(id0);
                long p = getBotPrice(id0);
                totalPrice += p;
                Store.buyInBot(cap, p);
                idToBeRemove.add(id0);
                //deleteBottle(Id);
            }
        }
        //Equipment
        for (Map.Entry<String, Equipment> entry : bag.getEquInBag().entrySet()) {
            int star = entry.getValue().getStar();
            int id0 = entry.getValue().getProId();
            long p = getEquPrice(id0);
            totalPrice += p;
            //deleteEquipment(Id);
            Store.buyInEqu(star, p);
            idToBeRemove.add(id0);
        }
        //Food
        for (Map.Entry<String, ArrayList<Integer>> entry : bag.getFoodInBag().entrySet()) {
            for (Integer id0 : entry.getValue()) {
                int energy = getFoodEn(id0);
                long p = getFoodPrice(id0);
                totalPrice += p;
                Store.buyInFood(energy, p);
                idToBeRemove.add(id0);
                //deleteFood(Id);
            }
        }
        for (Integer id0 : idToBeRemove) {
            if (bottles.containsKey(id0)) {
                bottles.remove(id0);
            }
            if (equipments.containsKey(id0)) {
                equipments.remove(id0);
            }
            if (foods.containsKey(id0)) {
                foods.remove(id0);
            }
            commodities.remove(id0);
        }
        //清空背包
        money += totalPrice;
        bag.clearAll();
        return totalPrice;
    }

    public long getMoney() {
        return money;
    }

    public void buyPro(long price) {
        this.money -= price;
    }

    public void increaseMoney(long money) {
        this.money += money;
    }

    public void giveMoney(Adventurer adv, long a) {
        long amount = a * 10000;
        if (this.money < amount) {
            adv.increaseMoney(this.money);
            this.money = 0;
        } else {
            adv.increaseMoney(amount);
            this.money -= amount;
        }
    }

}
