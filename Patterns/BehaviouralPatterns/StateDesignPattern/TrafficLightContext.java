public class TrafficLightContext {
    TrafficLightState curState;

    TrafficLightContext() {
        curState = new RedState();
    }

    public void next() {
        curState.next(this);
    }

    public void setState(TrafficLightState trafficLightState) {
        curState = trafficLightState;
    }

    public String getColour() {
        return curState.getColour();
    }
}
