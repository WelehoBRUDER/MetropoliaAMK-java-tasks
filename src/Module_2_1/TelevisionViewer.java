package Module_2_1;

public class TelevisionViewer {
    public static class Television {
        int channel = 1;
        int channelLimit = 10;
        boolean on = false;

        public int getChannel() {
            return channel;
        }

        public void setChannel(int channel) {
            this.channel = channel;
            if (this.channel > this.channelLimit) {
                this.channel = 1;
            }
        }

        public boolean isOn() {
            return on;
        }

        // Toggle between true and false
        public void pressOnOff() {
            on = !on;
        }
    }

    public static void main(String[] args) {
        Television tv = new Television();
        tv.setChannel(1);
        for (int day = 1; day <= 10; day++) {
            System.out.println("Woke up, day " + day);

            boolean tired = false;

            if (!tv.isOn())
                tv.pressOnOff();

            while (!tired) {
                System.out.println("Watching channel " + tv.getChannel());
                tv.setChannel(tv.getChannel() + 1);
                if (tv.getChannel() % 4 == 0)
                    tired = true;
            }

            tv.pressOnOff();

            System.out.println("Falling asleep");
        }
    }
}
