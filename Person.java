import java.io.Serializable;

public abstract class Person implements Serializable {
    String fName;
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
