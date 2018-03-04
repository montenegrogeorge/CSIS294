public class TrafficLight {
    private enum TrafficLight {RED,YELLOW,GREEN}

    public static void main(final String[] args) {

        final short k =(short) (System.currentTimeMillis()%3);

        switch(TrafficLight.values()[k]) {
            case RED:
            case YELLOW:
                System.out.printf("%d : stop ",k);
                break;
            default:
                System.out.printf("%d : drive ",k);
        }
    }
}
