package com.aros.arossdk.api;

public class Config {
    private String serverUri;
    private String userName;
    private String password;
    private String sn;

    public void setSn(String sn) {
        this.sn = sn;
    }

    public void setServerUri(String serverUri) {
        this.serverUri = serverUri;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    protected String getSn() {
        return sn;
    }
    protected String getServerUri() {
        return serverUri;
    }

    protected String getUserName() {
        return userName;
    }

    protected String getPassword() {
        return password;
    }

}
