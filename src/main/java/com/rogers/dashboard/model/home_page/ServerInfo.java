package com.rogers.dashboard.model.home_page;

import com.rogers.dashboard.model.enums.ServerStatus;

public class ServerInfo {
    private String serverName;
    private ServerStatus serverStatus;

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public ServerStatus getServerStatus() {
        return serverStatus;
    }

    public void setServerStatus(ServerStatus serverStatus) {
        this.serverStatus = serverStatus;
    }
}
