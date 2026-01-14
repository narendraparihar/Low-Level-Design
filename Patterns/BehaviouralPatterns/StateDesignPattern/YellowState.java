public class YellowState implements TrafficLightState {
    public void next(TrafficLightContext trafficLightContext) {
        System.out.println("Light will become red, stop");
        trafficLightContext.setState(new RedState());
    }

    public String getColour() {
        return "Yellow";
    }
}
