package WeddingPlanner.Project.model;

import java.util.ArrayList;
import java.util.List;

public class WeddingPlan {
    private final List<Guest> guests = new ArrayList<>();
    private final List<Vendor> vendors = new ArrayList<>();
    private final List<Expense> expenses = new ArrayList<>();
    private final double budget;

    public WeddingPlan(double budget) {
        this.budget = budget;
    }

    public void addGuest(Guest guest) {
        guests.add(guest);
    }

    public void addVendor(Vendor vendor) {
        vendors.add(vendor);
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public List<Vendor> getVendors() {
        return vendors;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public double getTotalExpenses() {
        return expenses.stream().mapToDouble(Expense::amount).sum();
    }

    public double getRemainingBudget() {
        return budget - getTotalExpenses();
    }

    public void showPlan() {
        System.out.println("\n📋 Wedding Plan:");

        System.out.println("👫 Guests:");
        if (guests.isEmpty()) {
            System.out.println(" - No guests added.");
        } else {
            guests.forEach(g ->
                    System.out.println(" - " + g.getName() + (g.isConfirmed() ? " ✅" : ""))
            );
        }

        System.out.println("\n📦 Vendors:");
        if (vendors.isEmpty()) {
            System.out.println(" - No vendors added.");
        } else {
            vendors.forEach(v ->
                    System.out.println(" - Type: " + v.type() + ", Name: " + v.name())
            );
        }

        System.out.println("\n💰 Expenses:");
        if (expenses.isEmpty()) {
            System.out.println(" - No expenses added.");
        } else {
            expenses.forEach(e -> System.out.println(" - " + e));
            System.out.println("Total expenses: " + getTotalExpenses() + " RON");
            System.out.println("Remaining budget: " + getRemainingBudget() + " RON");
        }
    }
}


