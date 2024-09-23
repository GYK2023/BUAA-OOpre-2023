import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operation {
    private HashMap<Integer, Adventurer> adventurers =
            new HashMap<>();
    private HashMap<String, ArrayList<String>> dateLog =
            new HashMap<String, ArrayList<String>>();

    private HashMap<Integer, ArrayList<String>> attackLog =
            new HashMap<Integer, ArrayList<String>>();
    private HashMap<Integer, ArrayList<String>> attackedLog =
            new HashMap<Integer, ArrayList<String>>();

    public void op1(ArrayList<String> s) {
        switch (s.get(0)) {
            case "1": {
                Adventurer ad = new Adventurer(Integer.parseInt(s.get(1)), s.get(2));
                adventurers.put(Integer.parseInt(s.get(1)), ad);
                break;
            }
            case "2": {
                Adventurer adv = adventurers.get(Integer.parseInt(s.get(1)));
                if (s.get(6).equals("RegularBottle")) {
                    adv.addBottle(Integer.parseInt(s.get(2)), s.get(3), Integer.parseInt(s.get(4)),
                            Long.parseLong(s.get(5)), s.get(6), 0);
                } else {
                    adv.addBottle(Integer.parseInt(s.get(2)), s.get(3), Integer.parseInt(s.get(4)),
                            Long.parseLong(s.get(5)), s.get(6), Double.parseDouble(s.get(7)));
                }

                break;
            }
            case "3": {
                Adventurer ad = adventurers.get(Integer.parseInt(s.get(1)));
                ad.deleteBottle(Integer.parseInt(s.get(2)));
                break;
            }
            case "4": {
                Adventurer ad = adventurers.get(Integer.parseInt(s.get(1)));
                if (s.get(6).equals("RegularEquipment")) {
                    ad.addEquipment(Integer.parseInt(s.get(2)), s.get(3),
                            Integer.parseInt(s.get(4)), Long.parseLong(s.get(5)), s.get(6), "0");
                } else if (s.get(6).equals("CritEquipment")) {
                    ad.addEquipment(Integer.parseInt(s.get(2)), s.get(3),
                            Integer.parseInt(s.get(4)),Long.parseLong(s.get(5)),s.get(6),s.get(7));
                } else if (s.get(6).equals("EpicEquipment")) {
                    ad.addEquipment(Integer.parseInt(s.get(2)), s.get(3),
                            Integer.parseInt(s.get(4)),Long.parseLong(s.get(5)),s.get(6),s.get(7));
                }
                //ad.addEquipment(Integer.parseInt(s.get(2)), s.get(3), Integer.parseInt(s.get(4)));
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
                ad.addFood(Integer.parseInt(s.get(2)), s.get(3),
                        Integer.parseInt(s.get(4)), Long.parseLong(s.get(5)));
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

    public void op3(ArrayList<String> s) {
        switch (s.get(0)) {
            case "14": {
                System.out.println("Enter Fight Mode");
                opOn14(s);
                break;
                //free arrayList;
            }
            case "15": {
                if (dateLog.containsKey(s.get(1))) {
                    for (String ss : dateLog.get(s.get(1))) {
                        System.out.println(ss);
                    }
                } else {
                    System.out.println("No Matched Log");
                }
                break;
            }
            case "16": {
                if (attackLog.containsKey(Integer.parseInt(s.get(1)))) {
                    for (String ss : attackLog.get(Integer.parseInt(s.get(1)))) {
                        System.out.println(ss);
                    }
                } else {
                    System.out.println("No Matched Log");
                }
                break;
            }
            case "17": {
                if (attackedLog.containsKey(Integer.parseInt(s.get(1)))) {
                    for (String ss : attackedLog.get(Integer.parseInt(s.get(1)))) {
                        System.out.println(ss);
                    }
                } else {
                    System.out.println("No Matched Log");
                }
                break;
            }
            default: {
                break;
            }
        }
    }

    public void op4(ArrayList<String> s) {
        switch (s.get(0)) {
            case "18": {//hire
                int id1 = Integer.parseInt(s.get(1));
                int id2 = Integer.parseInt(s.get(2));
                adventurers.get(id1).hire(id2, adventurers.get(id2));
                break;
            }
            case "19": {
                int id = Integer.parseInt(s.get(1));
                int num = adventurers.get(id).getComSize();
                long value = adventurers.get(id).getTotalPrice();
                System.out.print(num + " ");
                System.out.println(value);
                break;
            }
            case "20": {
                int id = Integer.parseInt(s.get(1));
                Adventurer ad = adventurers.get(id);
                System.out.println(ad.getMax());
                //
                break;
            }
            case "21": {
                int advId = Integer.parseInt(s.get(1));
                int comId = Integer.parseInt(s.get(2));
                String ss = adventurers.get(advId).searchClass(comId);
                System.out.println("Commodity whose id is " + comId + " belongs to " + ss);
                break;
            }
            default: {
                break;
            }
        }
    }

    public void opOn14(ArrayList<String> s) {
        String pattern01 =
                "(\\d{4}/((0[1-9])|(1[0-2])))-([^\\s@#-]{1,40})-([^\\s@#-]{1,40})";
        String pattern02 =
                "(\\d{4}/((0[1-9])|(1[0-2])))-([^\\s@#-]{1,40})@([^\\s@#-]{1,40})" +
                        "-([^\\s@#-]{1,40})";
        String pattern03 =
                "(\\d{4}/((0[1-9])|(1[0-2])))-([^\\s@#-]{1,40})@#-([^\\s@#-]{1,40})";
        Pattern pattern1 = Pattern.compile(pattern01);
        Pattern pattern2 = Pattern.compile(pattern02);
        Pattern pattern3 = Pattern.compile(pattern03);
        int m = Integer.parseInt(s.get(1));
        int k = Integer.parseInt(s.get(2));
        //ArrayList<HashMap<String, Adventurer>> advInFight = new ArrayList<>();
        HashMap<String, Adventurer> adventurerHashMap = new HashMap<>();
        for (int i = 3; i < m + 3; i++) {
            for (Map.Entry<Integer, Adventurer> entry : adventurers.entrySet()) {
                if (entry.getValue().getAdvName().equals(s.get(i))) {
                    adventurerHashMap.put(s.get(i), adventurers.get(entry.getKey()));
                    //advInFight.add(adventurerHashMap);
                }
            }
        }
        for (int i = 0; i < k; i++) {
            Matcher matcher1 = pattern1.matcher(s.get(m + 3 + i));
            Matcher matcher2 = pattern2.matcher(s.get(m + 3 + i));
            Matcher matcher3 = pattern3.matcher(s.get(m + 3 + i));
            if (matcher1.find()) {
                useBot(matcher1, s, adventurerHashMap);
                //use bottle
                //默认加入战斗的advName存在并且名字合法，否则要进行空指针判断

            } else if (matcher2.find()) {
                solo(matcher2, s, adventurerHashMap);
            } else if (matcher3.find()) {
                aoe(matcher3, s, adventurerHashMap, m);

            }
        }
    }

    public void useBot(Matcher matcher1, ArrayList<String> s,
                       HashMap<String, Adventurer> adventurerHashMap) {
        String date = matcher1.group(1);
        String name = matcher1.group(5);
        String bot = matcher1.group(6);

        if (s.contains(name)) {
            int id = adventurerHashMap.get(name).getAdvId();
            if (adventurers.get(id).takenBottle(bot)) {
                //药水使用合法
                adventurers.get(id).useBottle(bot);
                if (!dateLog.containsKey(date)) {
                    ArrayList<String> array = new ArrayList<>();
                    dateLog.put(date, array);
                }
                String newLog = date.concat(" ");
                newLog = newLog.concat(name).concat(" ");
                newLog = newLog.concat("used ").concat(bot);
                dateLog.get(date).add(newLog);
            } else {
                System.out.println("Fight log error");
            }


        } else {
            System.out.println("Fight log error");
        }
    }

    public void solo(Matcher matcher2,
                     ArrayList<String> s, HashMap<String, Adventurer> adventurerHashMap) {
        //solo
        String date = matcher2.group(1);
        String advName1 = matcher2.group(5);
        String advName2 = matcher2.group(6);
        String weapon = matcher2.group(7);
        /*if(date.equals("2000/10")){
            System.out.println("6");
        }*/
        /*if(!adventurerHashMap.containsKey(advName1)){
            System.out.println("6");
        }*/
        if (s.contains(advName1) && s.contains(advName2)) {
            int id1 = adventurerHashMap.get(advName1).getAdvId();
            int id2 = adventurerHashMap.get(advName2).getAdvId();
            Equipment check = adventurers.get(id1).takenEqu(weapon);
            if (check != null) {
                //YYYY/MM {adv_name_1} attacked {adv_name_2} with {name}
                String newLog = date.concat(" ");
                newLog = newLog.concat(advName1).concat(" ");
                newLog = newLog.concat("attacked ").concat(advName2).concat(" ");
                newLog = newLog.concat("with ").concat(weapon);
                int level = adventurers.get(id1).getAdvLevel();
                //int star = adventurers.get(id1).takenEqu(weapon).getStar();
                int newHit = adventurerHashMap.get(advName2).getAttacked(check, level);
                System.out.println(id2 + " " + newHit);
                if (!attackedLog.containsKey(id2)) {
                    ArrayList<String> array = new ArrayList<>();
                    attackedLog.put(id2, array);
                }
                attackedLog.get(id2).add(newLog);
                //攻击者日志
                if (!attackLog.containsKey(id1)) {
                    ArrayList<String> array = new ArrayList<>();
                    attackLog.put(id1, array);
                }
                attackLog.get(id1).add(newLog);
                //日期日志
                if (!dateLog.containsKey(date)) {
                    ArrayList<String> array = new ArrayList<>();
                    dateLog.put(date, array);
                }
                dateLog.get(date).add(newLog);
            } else {
                System.out.println("Fight log error");
            }

        } else {
            System.out.println("Fight log error");
        }
    }

    public void aoe(Matcher matcher3,
                    ArrayList<String> s, HashMap<String, Adventurer> adventurerHashMap, int m) {
        //aoe
        String date = matcher3.group(1);
        String advName = matcher3.group(5);
        String weapon = matcher3.group(6);
        if (s.contains(advName)) {
            int id = adventurerHashMap.get(advName).getAdvId();
            if (adventurers.get(id).takenEqu(weapon) != null) {
                //aoe战斗日志合法
                int level = adventurers.get(id).getAdvLevel();
                //int star = adventurers.get(id).takenEqu(weapon).getStar();
                String newLog = date.concat(" ");
                newLog = newLog.concat(advName).concat(" ");
                newLog = newLog.concat("AOE-attacked with ").concat(weapon);
                for (int j = 3; j < m + 3; j++) {
                    if (!s.get(j).equals(advName)) {
                        int newHit = adventurerHashMap.get(s.get(j)).
                                getAttacked(adventurers.get(id).takenEqu(weapon), level);
                        System.out.print(newHit);
                        System.out.print(" ");
                        //被攻击者日志
                        int id0 = adventurerHashMap.get(s.get(j)).getAdvId();
                        if (!attackedLog.containsKey(id0)) {
                            ArrayList<String> array = new ArrayList<>();
                            attackedLog.put(id0, array);
                        }
                        attackedLog.get(id0).add(newLog);
                    }
                }
                System.out.print("\n");
                //攻击者日志
                if (!attackLog.containsKey(id)) {
                    ArrayList<String> array = new ArrayList<>();
                    attackLog.put(id, array);
                }
                attackLog.get(id).add(newLog);
                //日期日志
                if (!dateLog.containsKey(date)) {
                    ArrayList<String> array = new ArrayList<>();
                    dateLog.put(date, array);
                }
                dateLog.get(date).add(newLog);
                //被攻击者日志
                //log.put(matcher3.group(1),)
            } else {
                System.out.println("Fight log error");
            }

        } else {
            System.out.println("Fight log error");
        }
    }
}


