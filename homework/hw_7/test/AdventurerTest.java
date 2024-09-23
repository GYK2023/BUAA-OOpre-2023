import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import static org.junit.Assert.*;


public class AdventurerTest {

    @Test
    public void addBottle() {
        Adventurer ad1 = new Adventurer(1,"first");
        ad1.addBottle(1,"water",123,123456,"RegularBottle",0.5);
        assertEquals(ad1.getBottleCount(),1);
        Adventurer ad2 = new Adventurer(2,"first");
        ad1.addBottle(2,"fire",1,123456,"RegularBottle",0.55);
        assertEquals(ad1.getBottleCount(),2);
        Bottle bot = new ReinforcedBottle(1,"fire",1,123456,"ReinforcedBottle",0.5);
        bot.getBottleGain(10);
        Bottle bot2 = new RecoverBottle(1,"fire",1,123456,"RecoverBottle",0.5);
        bot2.getBottleGain(10);
        bot.getPrice();

    }

    @Test
    public void deleteBottle() {
        Adventurer ad1 = new Adventurer(1,"first");
        ad1.addBottle(1,"fire",1,123456,"ReinforcedBottle",0.5);
        ad1.deleteBottle(1);
        assertEquals(ad1.getBottleCount(),0);
        ad1.deleteBottle(2);
        assertEquals(ad1.getBottleCount(),0);
    }

    @Test
    public void addEquipment() {
        Adventurer ad1 = new Adventurer(1,"first");
        ad1.addEquipment(1,"fire",1,123456,"RegularEquipment","");
        assertEquals(ad1.getEquCount(),1);
        Adventurer ad2 = new Adventurer(2,"first");
        ad1.addEquipment(2,"fire",1,123456,"EpicEquipment","0.5");
        assertEquals(ad1.getEquCount(),2);
        Equipment equ1 = new CritEquipment(2,"fire",1,123456,"CritEquipment",20);
        equ1.getHitDec(10,10);
        Equipment equ2 = new EpicEquipment(2,"fire",1,123456,"EpicEquipment",0.5);
        equ2.getHitDec(10,10);
        equ2.getPrice();
    }

    @Test
    public void deleteEquipment() {
        Adventurer ad1 = new Adventurer(1,"first");
        ad1.addEquipment(1,"fire",1,123456,"EpicEquipment","5");
        ad1.deleteEquipment(1);
        assertEquals(ad1.getBottleCount(),0);
        ad1.deleteEquipment(2);
        assertEquals(ad1.getBottleCount(),0);
    }

    @Test
    public void improveStar() {
        Adventurer ad1 = new Adventurer(1,"first");
        ad1.addEquipment(1,"fire",1,123,"RegularEquipment","0");
        ad1.improveStar(1);
    }

    @Test
    public void addFood() {
        Adventurer ad1 = new Adventurer(1,"first");
        ad1.addFood(1,"apple",1,666);
        Food food = new Food(2,"banana",6,555);
        assertEquals(food.getFoodEnergy() ,6);
        assertEquals(food.getProName(),"banana");
        assertEquals(food.getProId() , 2);
        food.getPrice();
    }

    @Test
    public void deleteFood() {
        Adventurer ad1 = new Adventurer(1,"first");
        ad1.addFood(1,"apple",1,123);
        ad1.takeFood(1);
        ad1.deleteFood(1);
        assertEquals(ad1.getFoodSize("apple") , 0);
    }

    @Test
    public void takeEqu() {
        Adventurer ad1 = new Adventurer(1,"first");
        ad1.addEquipment(1,"gun",5,444,"CritEquipment","555");
        ad1.takeEqu(1);
        //assertEquals(ad1.takenEqu("gun"),5);
        assertEquals(ad1.takenEqu("knife"),null);
        ad1.deleteEquipment(1);
    }

    @Test
    public void takeBottle() {
        Adventurer ad1 = new Adventurer(1,"first");
        ad1.addBottle(1,"water",5,123,"RegularBottle",0.5);
        ad1.addBottle(2,"water",3,123,"RecoverBottle",0.5);
        ad1.addBottle(3,"water",5,123,"RegularBottle",0.5);
        ad1.addBottle(4,"water",3,123,"RegularBottle",0.5);
        ad1.addBottle(5,"water",3,123,"RegularBottle",0.5);
        assertEquals(ad1.getBottleSize("water") , 0);
        ad1.takeBottle(1);
        ad1.addFood(86,"candy",20,555);
        ad1.takeFood(86);
        ad1.eatFood("candy");
        ad1.takeBottle(2);
        ad1.takeBottle(3);
        ad1.takeBottle(4);
        int size = ad1.getBottleSize("water");
        assertEquals(size , 4);
        ad1.takeBottle(5);
        assertEquals(ad1.getBottleSize("water"), 5);
        ad1.deleteBottle(1);

    }

    @Test
    public void takeFood() {
        Adventurer ad1 = new Adventurer(1,"first");
        ad1.addFood(1,"apple",5,123);
        ad1.takenFood("apple");
        ad1.takeFood(1);
        ad1.deleteFood(1);
        ad1.takeFood(1);
    }

    @Test
    public void useBottle() {
        Adventurer ad1 = new Adventurer(1,"first");
        ad1.addBottle(1,"water",5,123456,"RegularBottle",0);
        ad1.useBottle("water");
        ad1.takeBottle(1);
        ad1.useBottle("water");
        ad1.deleteBottle(1);
    }

    @Test
    public void eatFood() {
        Adventurer ad1 = new Adventurer(1,"first");
        ad1.addFood(1,"apple",5,123456);
        ad1.eatFood("apple");
        ad1.eatFood("banana");
        ad1.deleteFood(1);
    }

    @Test
    public void getAdvId() {
        Adventurer ad1 = new Adventurer(1,"first");
        Adventurer ad2 = new Adventurer(2,"second");
        assertEquals(ad1.getAdvName(),"first");
        assertEquals(ad1.getAdvLevel(),1);
        ad1.getPrice();
        ad1.getTotalPrice();
        ad1.getMax();
        Equipment weapon = new Equipment(1,"d",5,123,"RegularEquipment");
        ad1.getAttacked(weapon,1);
        ad1.addEquipment(1,"d",5,123,"RegularEquipment","");
        ad1.getComSize();
        ad1.searchClass(1);
        ad1.hire(1,ad2);
        ad1.sellAll();
        Store.buyInBot(12,12);
        Store.buyInEqu(11,11);
        Store.buyInFood(45,55);
        Store.equStar();
        Store.botCap();
        Store.foodEnergy();
        ArrayList<String> a = new ArrayList<String>();
        a.add("23");
        a.add("1");
        a.add("6696");
        a.add("haha");
        a.add("RegularBottle");
        Store.creat(a,ad1);
        a.clear();
        a.add("23");
        a.add("1");
        a.add("66968");
        a.add("haha8");
        a.add("RegularBottle");
        Store.creat(a,ad1);
        a.clear();
        a.add("23");
        a.add("1");
        a.add("66969");
        a.add("haha9");
        a.add("RegularEquipment");
        Store.creat(a,ad1);
        a.clear();
        a.add("23");
        a.add("1");
        a.add("669666");
        a.add("haha66");
        a.add("Food");
        Store.creat(a,ad1);
    }

    @Test
    public void getAdvName() {
        Adventurer ad1 = new Adventurer(1,"first");
        assertEquals(ad1.getAdvId(),1);
    }

    @Test
    public void operationCheck() {
        ArrayList<ArrayList<String>> inputInfo = new ArrayList<>();
        String s = "1 1 adv1";
        String[] strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "1 2 adv2";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "2 1 1 water 6 123 RegularBottle";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "2 1 556 water 6 123 ReinforcedBottle 0.56";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "2 1 88 water 6 123 RecoverBottle 0.56";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "3 1 1";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "4 1 1 cloth 6 123 RegularEquipment";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "5 1 1";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "6 1 2";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "4 1 2 gun 5 123 EpicEquipment 0.22";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "6 1 2";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "7 1 1 cake 5 123";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "8 1 1";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "9 1 1";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "9 1 2";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "10 1 556";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "10 1 88";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "11 1 2";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "13 1 cake";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "10 1 88";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "12 1 2";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "12 1 water";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "12 1 water";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "13 1 2";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "14 2 3 adv1 adv2 2022/09-adv1-bot 2022/09-adv1@adv2-gun 2022/09-adv1@#-gun";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "15 2022/09";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "16 1";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "17 1";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "18 1 2";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "22 1";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "19 1";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "20 1";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "22 1";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        Operation operation = new Operation();
        for(int i = 0; i < 26;i++){
            operation.op1(inputInfo.get(i));
            operation.op2(inputInfo.get(i));
            operation.op3(inputInfo.get(i));
        }


    }
}