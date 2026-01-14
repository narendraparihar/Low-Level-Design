public class RedState implements TrafficLightState {

    public void next(TrafficLightContext trafficLightContext) {
        System.out.println("state will change to green, cars can go");
        trafficLightContext.setState(new GreenState());
    }

    public String getColour() {
        return "RED";
    }
}
