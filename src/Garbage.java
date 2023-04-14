public class Garbage {
    private String garbageName;
    public String garbageType;

    public Garbage(String garbageName, String garbageType) {
        this.garbageName = garbageName;
        this.garbageType = garbageType;
    }

    public String toString() {
        return garbageName;
    }

    public boolean equals(Object obj){
        return this == obj;
    }
}
