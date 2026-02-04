package WeddingPlanner.Project.model;

public class Guest {
    private final String name;
    private boolean confirmed = false;

    public Guest(String name) {
        this.name = name;
    }

    public void confirm() {
        this.confirmed = true;
    }

    public String getName() {
        return name;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    @Override
    public String toString() {
        return name + (confirmed ? " ✅" : "");
    }
}
