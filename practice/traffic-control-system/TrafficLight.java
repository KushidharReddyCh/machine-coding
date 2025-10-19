class TrafficLights{
    // shall we make this into enum or over kill, like color class
    final int RED_DEFAULT_TIME_IN_SECONDS = 150; // time in seconds
    final int GREEN_DEFAULT_TIME_IN_SECONDS = 150;
    final int ORANGE_DEFAULT_TIME_IN_SECONDS = 5;
    int redTimeInSeconds;
    int greenTimeInSeconds;
    int orangeTimeInSeconds;
    Color currentColor;

    public TrafficLights(int redTimeInSeconds, int greenTimeInSeconds, int orangeTimeInSeconds){
        this.redTimeInSeconds = redTimeInSeconds;
        this.orangeTimeInSeconds = orangeTimeInSeconds;
        this.greenTimeInSeconds = greenTimeInSeconds;
    }

    public int getRedTimeInSeconds() {
        return redTimeInSeconds;
    }

    public void setRedTime(int redTimeInSeconds) {
        this.redTime = redTimeInSeconds;
    }

    public int getGreenTimeInSeconds() {
        return greenTimeInSeconds;
    }

    public void setGreenTime(int greenTimeInSeconds) {
        this.greenTimeInSeconds = greenTimeInSeconds;
    }

    public int getOrangeTimeInSeconds() {
        return orangeTimeInSeconds;
    }

    public void setOrangeTime(int orangeTimeInSeconds) {
        this.orangeTimeInSeconds = orangeTimeInSeconds;
    }

    public Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }

    public void reset(){
        setCurrentColor(null);
        setRedTime(RED_DEFAULT_TIME_IN_SECONDS);
        setOrangeTime(ORANGE_DEFAULT_TIME_IN_SECONDS);
        setGreenTime(GREEN_DEFAULT_TIME_IN_SECONDS);
    }

}