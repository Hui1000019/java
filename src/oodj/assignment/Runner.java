package oodj.assignment;
public class Runner {
    private String username;
    private String runID;
    private String passwd;

    public Runner(String username, String passwd, String runID) {
    this.username = username;
    this.passwd = passwd;
    this.runID = runID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getRunID() {
        return runID;
    }

    public void setRunID(String runID) {
        this.runID = runID;
    }    
    
}
