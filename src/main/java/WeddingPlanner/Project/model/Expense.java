package WeddingPlanner.Project.model;

public record Expense(String description, double amount) {
    @Override
    public String toString() {
        return description + ": " + amount + " RON";
    }
}
