import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> inputInfo = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        Operation operation = new Operation();
        for (int i = 0; i < n; i++) {
            String nextLine = scanner.nextLine();
            String[] strings = nextLine.trim().split(" +");
            inputInfo.add(new ArrayList<>(Arrays.asList(strings)));
            if (inputInfo.get(i).get(0).equals("14"))
            {
                int k = Integer.parseInt(inputInfo.get(i).get(2));
                for (int j = 0; j < k; j++)
                {
                    String log = scanner.nextLine();
                    inputInfo.get(i).add(log);
                }
            }
        }
        for (int i = 0;i < n;i++)
        {
            operation.op1(inputInfo.get(i));
            operation.op2(inputInfo.get(i));
            operation.op3(inputInfo.get(i));
            operation.op4(inputInfo.get(i));
        }
    }
}