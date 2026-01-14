public class GreenState implements TrafficLightState {

    public void next(TrafficLightContext trafficLightContext) {
        System.out.println("Light will turns to yellow, slow down");
        trafficLightContext.setState(new YellowState());
    }

    public String getColour() {
        return "Green";
    }
}
