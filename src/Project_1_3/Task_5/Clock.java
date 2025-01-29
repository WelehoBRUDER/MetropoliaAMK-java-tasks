package Project_1_3.Task_5;

public class Clock {
        // Private static member to hold the unique instance
        private static Clock instance;
        private int time;

        // Private constructor to prevent instantiation from outside
        private Clock() {
            // Initialization code
        }

        // Public static method to access the unique instance
        public static Clock getInstance() {
            if (instance == null) {
                instance = new Clock();
            }
            return instance;
        }

        int getTime() {
            return time;
        }

        void setTime(int time) {
            this.time = time;
        }

        public static void main(String[] args) {
            Clock.getInstance().setTime(15);
            System.out.println("Current time: " + Clock.getInstance().getTime());
        }


}
