import java.util.ArrayList;
import java.util.HashMap;

public class Operation {
    private HashMap<Integer, Adventurer> adventurers = new HashMap<>();

    public void op1(ArrayList<String> s) {
        switch (s.get(0)) {
            case "1": {
                Adventurer ad = new Adventurer(Integer.parseInt(s.get(1)), s.get(2));
                adventurers.put(Integer.parseInt(s.get(1)), ad);
                break;
            }
            case "2": {
                Adventurer adv = adventurers.get(Integer.parseInt(s.get(1)));
                adv.addBottle(Integer.parseInt(s.get(2)), s.get(3), Integer.parseInt(s.get(4)));
                break;
            }
            case "3": {
                Adventurer ad = adventurers.get(Integer.parseInt(s.get(1)));
                ad.deleteBottle(Integer.parseInt(s.get(2)));
                break;
            }
            case "4": {
                Adventurer ad = adventurers.get(Integer.parseInt(s.get(1)));
                ad.addEquipment(Integer.parseInt(s.get(2)),s.get(3), Integer.parseInt(s.get(4)));
                break;
            }
            case "5": {
                Adventurer ad = adventurers.get(Integer.parseInt(s.get(1)));
                ad.deleteEquipment(Integer.parseInt(s.get(2)));
                break;
            }
            case "6": {
                Adventurer ad = adventurers.get(Integer.parseInt(s.get(1)));
                ad.improveStar(Integer.parseInt(s.get(2)));
                break;
            }
            default: {
                break;
            }
        }
    }

    public void op2(ArrayList<String> s) {
        switch (s.get(0)) {
            case "7": {
                Adventurer ad = adventurers.get(Integer.parseInt(s.get(1)));
                ad.addFood(Integer.parseInt(s.get(2)), s.get(3), Integer.parseInt(s.get(4)));
                break;
            }
            case "8": {
                Adventurer ad = adventurers.get(Integer.parseInt(s.get(1)));
                ad.deleteFood(Integer.parseInt(s.get(2)));
                break;
            }
            case "9": {
                Adventurer ad = adventurers.get(Integer.parseInt(s.get(1)));
                ad.takeEqu(Integer.parseInt(s.get(2)));
                break;
            }

            case "10": {
                Adventurer ad = adventurers.get(Integer.parseInt(s.get(1)));
                ad.takeBottle(Integer.parseInt(s.get(2)));
                break;
            }
            case "11": {
                Adventurer ad = adventurers.get(Integer.parseInt(s.get(1)));
                ad.takeFood(Integer.parseInt(s.get(2)));
                break;
            }
            case "12": {
                Adventurer ad = adventurers.get(Integer.parseInt(s.get(1)));
                ad.useBottle(s.get(2));
                break;
            }
            case "13": {
                Adventurer ad = adventurers.get(Integer.parseInt(s.get(1)));
                ad.eatFood(s.get(2));
                break;
            }
            default: {
                break;
            }
        }
    }
}

