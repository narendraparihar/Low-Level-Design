public class TrafficLightDemo {

    public static void main(String[] args) {
        TrafficLightContext trafficLightContext = new TrafficLightContext();

        String curColor = trafficLightContext.getColour();
        System.out.println("Initial state :" + curColor);

        trafficLightContext.next();
        trafficLightContext.next();
        trafficLightContext.next();
    }

}
