// DataInfo.java
//
class DataInfo {}

interface Local {
    DataInfo[] loadDB(String filename);
}

interface Remote extends Local {
    void connect2WWW(String url);
}

class LocalMode implements Local {
    public DataInfo[] loadDB(String name) {
        System.out.println("Load from a local database");
        return null;
    }
}

class RemoteMode implements Remote {
    public void connect2WWW(String url) {
        System.out.println("Connect to a remote site");
    }
    public DataInfo[] loadDB(String name) {
        System.out.println("Load from a remote database");
        return null;
    }
}

