import java.util.ArrayList;
import java.util.Iterator;

public class Team {
    private final ArrayList<Soldier> soldiers;

    public Team() {
        this.soldiers = new ArrayList<>();
    }

    public void addSoldier(Soldier soldier) {
        soldiers.add(soldier);
    }

    public void screen(int standard) {
        Iterator<Soldier> iterator = soldiers.iterator();
        while (iterator.hasNext())
        {
            Soldier soldier = iterator.next();
            if (soldier.notQualifiedByStandard(standard))
            {
                //make changes here
                iterator.remove();
            }
        }
    }

    public void allAddStr(String str) {
        for (Soldier soldier : soldiers) {
            soldier.appendStr2Incantation(str);
        }
    }

    public void allIntercept(int a, int b) {
        for (Soldier soldier : soldiers) {
            soldier.cutIncantation(a, b);
        }
    }

    public Team cloneSelf() {
        Team team = new Team();
        for (Soldier soldier : soldiers) {
            team.addSoldier(soldier.cloneSoldier());
        }
        return team;
    }

    public void mergeTeam(Team team) {
        for (Soldier soldier : team.soldiers) {
            boolean repeat = false;
            for (Soldier oldSoldier : this.soldiers) {
                //为了应对 复制对象的合并不能进行引用的判断
                if (oldSoldier.equal(soldier)) {
                    repeat = true;
                    break;
                }
            }
            if (!repeat) {
                this.soldiers.add(soldier);
            }
        }
    }

    public int getSize() {
        return this.soldiers.size();
    }

    public int getSizeOfHasStr(String str) {
        int count = 0;
        for (Soldier soldier : soldiers) {
            if (soldier.hasString(str)) {
                count++;
            }
        }
        return count;
    }
}

