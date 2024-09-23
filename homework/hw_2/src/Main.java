import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer,Adventurer> adventurers = new HashMap<>();
        ArrayList<ArrayList<String>> inputInfo = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < n;i++)
        {
            String nextLine = scanner.nextLine();
            String[] strings = nextLine.trim().split(" +");
            inputInfo.add(new ArrayList<>(Arrays.asList(strings)));
        }
        for (int i = 0;i < n;i++)
        {
            if (inputInfo.get(i).get(0).equals("1"))
            {
                int id = Integer.parseInt(inputInfo.get(i).get(1));
                String name = inputInfo.get(i).get(2);
                Adventurer ad = new Adventurer(id,name);
                adventurers.put(Integer.parseInt(inputInfo.get(i).get(1)),ad);
            }
            else if (inputInfo.get(i).get(0).equals("2"))
            {
                int id1 = Integer.parseInt(inputInfo.get(i).get(1));
                int id2 = Integer.parseInt(inputInfo.get(i).get(2));
                String name = inputInfo.get(i).get(3);
                int capacity = Integer.parseInt(inputInfo.get(i).get(4));
                Adventurer adv = adventurers.get(id1);
                adv.addBottle(id2,name,capacity);
            }
            else if (inputInfo.get(i).get(0).equals("3"))
            {
                Adventurer ad = adventurers.get(Integer.parseInt(inputInfo.get(i).get(1)));
                ad.deleteBottle(Integer.parseInt(inputInfo.get(i).get(2)));
            }
            else if (inputInfo.get(i).get(0).equals("4"))
            {
                int id1 = Integer.parseInt(inputInfo.get(i).get(1));
                int id2 = Integer.parseInt(inputInfo.get(i).get(2));
                String name = inputInfo.get(i).get(3);
                int star = Integer.parseInt(inputInfo.get(i).get(4));
                Adventurer ad = adventurers.get(id1);
                ad.addEquipment(id2,name,star);
            }
            else if (inputInfo.get(i).get(0).equals("5"))
            {
                Adventurer ad = adventurers.get(Integer.parseInt(inputInfo.get(i).get(1)));
                ad.deleteEquipment(Integer.parseInt(inputInfo.get(i).get(2)));
            }
            else if (inputInfo.get(i).get(0).equals("6"))
            {
                Adventurer ad = adventurers.get(Integer.parseInt(inputInfo.get(i).get(1)));
                ad.improveStar(Integer.parseInt(inputInfo.get(i).get(2)));
            }
        }
    }
}