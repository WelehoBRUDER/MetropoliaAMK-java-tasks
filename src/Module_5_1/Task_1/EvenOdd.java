package Module_5_1.Task_1;

public class EvenOdd extends Thread {
    private final int max;
    private int even;
    private int odd;
    private boolean type;

    public EvenOdd(int min, int max, boolean type) {
        this.even = isEven(min) ? min : min + 1;
        this.odd = !isEven(min) ? min : min + 1;
        this.type = type;
        this.max = max;
    }


    @Override
    public void run() {
        super.run();
        if (type) {
            while (even <= max) {
                System.out.println("Even: " + even);
                even += 2;
            }

        } else {

            while (odd <= max) {
                System.out.println("Odd: " + odd);
                odd += 2;
            }
        }
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static void main(String[] args) {
        int max = 56;
        int min = 5;

        EvenOdd evenThread = new EvenOdd(min, max, true);
        EvenOdd oddThread = new EvenOdd(min, max, false);
        evenThread.start();
        oddThread.start();
    }
}
