package com.rogers.dashboard.model.home_page;

public class MQTTInfo {
    private String mqttServer;
    private TouchPanelTopics touchPanelTopics;
    private AppiumTopics appiumTopics;
    private FfmpegTopics ffmpegTopics;
    private TestManagerTopics testManagerTopics;

    public String getMqttServer() {
        return mqttServer;
    }

    public void setMqttServer(String mqttServer) {
        this.mqttServer = mqttServer;
    }

    public TouchPanelTopics getTouchPanelTopics() {
        return touchPanelTopics;
    }

    public void setTouchPanelTopics(TouchPanelTopics touchPanelTopics) {
        this.touchPanelTopics = touchPanelTopics;
    }

    public AppiumTopics getAppiumTopics() {
        return appiumTopics;
    }

    public void setAppiumTopics(AppiumTopics appiumTopics) {
        this.appiumTopics = appiumTopics;
    }

    public FfmpegTopics getFfmpegTopics() {
        return ffmpegTopics;
    }

    public void setFfmpegTopics(FfmpegTopics ffmpegTopics) {
        this.ffmpegTopics = ffmpegTopics;
    }

    public TestManagerTopics getTestManagerTopics() {
        return testManagerTopics;
    }

    public void setTestManagerTopics(TestManagerTopics testManagerTopics) {
        this.testManagerTopics = testManagerTopics;
    }
}
