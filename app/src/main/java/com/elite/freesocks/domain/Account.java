package com.elite.freesocks.domain;

/**
 * Created by wjc133.
 * Date: 2016/2/24
 * Time: 0:40
 * Description:
 */
public class Account {
    private String url;
    private int port;
    private String password;
    private String encryption;
    private String status;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncryption() {
        return encryption;
    }

    public void setEncryption(String encryption) {
        this.encryption = encryption;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account{" +
                "url='" + url + '\'' +
                ", port=" + port +
                ", password='" + password + '\'' +
                ", encryption='" + encryption + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
