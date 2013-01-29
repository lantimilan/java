// DataManager.java

// The Abstract Factory
interface ConnectionFactory {
    Local getLocalConnection();
    Remote getRemoteConnection();
}

class DataManager implements ConnectionFactory {
    boolean local = false;
    DataInfo[] data;

    public Local getLocalConnection() {
        return new LocalMode();
    }
    public Remote getRemoteConnection() {
        return new RemoteMode();
    }
    public void loadData() {
        if (local) {
            Local conn = getLocalConnection();
            data = conn.loadDB("db.db");
        } else {
            Remote conn = getRemoteConnection();
            conn.connect2WWW("www.somewhere.com");
            data = conn.loadDB("db.db");
        }
    }
    // work on data
    public void setConnection(boolean b) {
        local = b;
    }
}

