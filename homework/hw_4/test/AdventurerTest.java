import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import static org.junit.Assert.*;


public class AdventurerTest {

    @Test
    public void addBottle() {
        Adventurer ad1 = new Adventurer(1,"first");
        ad1.addBottle(1,"water",123);
        assertEquals(ad1.getBottleCount(),1);
        Adventurer ad2 = new Adventurer(2,"first");
        ad1.addBottle(2,"fire",1);
        assertEquals(ad1.getBottleCount(),2);
    }

    @Test
    public void deleteBottle() {
        Adventurer ad1 = new Adventurer(1,"first");
        ad1.addBottle(1,"fire",1);
        ad1.deleteBottle(1);
        assertEquals(ad1.getBottleCount(),0);
        ad1.deleteBottle(2);
        assertEquals(ad1.getBottleCount(),0);
    }

    @Test
    public void addEquipment() {
        Adventurer ad1 = new Adventurer(1,"first");
        ad1.addEquipment(1,"fire",1);
        assertEquals(ad1.getEquCount(),1);
        Adventurer ad2 = new Adventurer(2,"first");
        ad1.addEquipment(2,"fire",1);
        assertEquals(ad1.getEquCount(),2);
    }

    @Test
    public void deleteEquipment() {
        Equipment e = new Equipment(222,"name",5);
        e.getEquId();
        Adventurer ad1 = new Adventurer(1,"first");
        ad1.addEquipment(1,"fire",1);
        ad1.deleteEquipment(1);
        assertEquals(ad1.getBottleCount(),0);
        ad1.deleteEquipment(2);
        assertEquals(ad1.getBottleCount(),0);
    }

    @Test
    public void improveStar() {
        Adventurer ad1 = new Adventurer(1,"first");
        ad1.addEquipment(1,"fire",1);
        ad1.improveStar(1);
    }

    @Test
    public void addFood() {
        Adventurer ad1 = new Adventurer(1,"first");
        ad1.addFood(1,"apple",1);
        Food food = new Food(2,"banana",6);
        assertEquals(food.getFoodEnergy() ,6);
        assertEquals(food.getFoodName(),"banana");
        assertEquals(food.getFoodId() , 2);
    }

    @Test
    public void deleteFood() {
        Adventurer ad1 = new Adventurer(1,"first");
        ad1.addFood(1,"apple",1);
        ad1.takeFood(1);
        ad1.deleteFood(1);
        assertEquals(ad1.getFoodSize("apple") , 0);
    }

    @Test
    public void takeEqu() {
        Adventurer ad1 = new Adventurer(1,"first");
        ad1.addEquipment(1,"gun",5);
        ad1.takeEqu(1);
        assertEquals(ad1.takenEqu("gun"),5);
        assertEquals(ad1.takenEqu("knife"),-1);

        ad1.deleteEquipment(1);
    }

    @Test
    public void takeBottle() {
        Adventurer ad1 = new Adventurer(1,"first");
        ad1.addBottle(1,"water",5);
        ad1.addBottle(2,"water",3);
        ad1.addBottle(3,"water",5);
        ad1.addBottle(4,"water",3);
        ad1.addBottle(5,"water",3);
        ad1.takenBottle("water");
        assertEquals(ad1.getBottleSize("water") , 0);
        ad1.takeBottle(1);
        ad1.addFood(86,"candy",20);
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
        ad1.addFood(1,"apple",5);
        ad1.takenFood("apple");
        ad1.takeFood(1);
        ad1.deleteFood(1);
        ad1.takeFood(1);
    }

    @Test
    public void useBottle() {
        Adventurer ad1 = new Adventurer(1,"first");
        ad1.addBottle(1,"water",5);
        ad1.useBottle("water");
        ad1.takeBottle(1);
        ad1.useBottle("water");
        ad1.deleteBottle(1);
    }

    @Test
    public void eatFood() {
        Adventurer ad1 = new Adventurer(1,"first");
        ad1.addFood(1,"apple",5);
        ad1.eatFood("apple");
        ad1.eatFood("banana");
        ad1.deleteFood(1);
    }

    @Test
    public void getAdvId() {
        Adventurer ad1 = new Adventurer(1,"first");
        assertEquals(ad1.getAdvName(),"first");
        assertEquals(ad1.getAdvLevel(),1);
        ad1.getAttacked(1,1);
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

        s = "2 1 1 water 6";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "3 1 1";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "4 1 1 cloth 6";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "5 1 1";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "6 1 2";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "4 1 2 gun 5";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "6 1 2";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "7 1 1 cake 5";
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

        s = "10 1 1";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "11 1 2";
        strings = s.trim().split(" +");
        inputInfo.add(new ArrayList<>(Arrays.asList(strings)));

        s = "12 1 2";
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

        Operation operation = new Operation();
        for(int i = 0; i < 21;i++){
            operation.op1(inputInfo.get(i));
            operation.op2(inputInfo.get(i));
            operation.op3(inputInfo.get(i));
        }


    }
}