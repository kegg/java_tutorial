package javaTutorial;

public class Item {
    
    private long id;
    private String value;

    public Item(long id, String value) {
        this.id = id;
        this.value = value;
    }

    public long getId() {
        return this.id;
    }

    public String toString() {
        return this.value;
    }
}
