package Project_1_3.Task_2;

public class AgeDistribution {
    final int AMOUNT = 1000;
    int distribution[][] = {
            {6, 18}, // 6%
            {10, 19}, // 4%
            {22, 20}, // 12%
            {29, 21}, // 7%
            {48, 22}, // 19%
            {59, 23}, // 11%
            {65, 24}, // 6%
            {71, 25}, // 6%
            {79, 26}, // 8%
            {85, 27}, // 6%
            {90, 28}, // 5%
            {93, 29}, // 3%
            {97, 30}, // 4%
            {100, 31} // 3%
    };

    public int getDistribution(int x, int y) {
        return distribution[x][y];
    }

    public int getAMOUNT() {
        return AMOUNT;
    }

    public static void main(String[] args) {
        AgeDistribution ageDistribution = new AgeDistribution();
        int generatedAges[] = new int[35];

        for (int i = 1; i < ageDistribution.getAMOUNT(); i++) {
            int x = (int) (Math.random() * 100) + 1;
            int j = 0;
            while (x > ageDistribution.getDistribution(j, 0)) j++;
            generatedAges[ageDistribution.getDistribution(j, 1)]++;
        }
        System.out.println("Result of simulation:");
        System.out.println("Age  count     %-share");
        for (int i = 0; i < generatedAges.length; i++) {
            if(generatedAges[i] != 0) {
                String str = "%-4d %-8d %-8.2f\n";
                System.out.printf(str, i, generatedAges[i], ((double)generatedAges[i])/ ageDistribution.getAMOUNT()*100 );
            }
        }
    }


}
