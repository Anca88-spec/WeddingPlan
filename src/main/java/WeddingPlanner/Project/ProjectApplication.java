package WeddingPlanner.Project;

import WeddingPlanner.Project.model.Expense;
import WeddingPlanner.Project.model.Guest;
import WeddingPlanner.Project.model.Vendor;
import WeddingPlanner.Project.model.WeddingPlan;

import java.util.Scanner;

public class ProjectApplication {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter wedding budget (RON): ");
		double budget = Double.parseDouble(scanner.nextLine());

		WeddingPlan plan = new WeddingPlan(budget);

		while (true) {
			System.out.println("\n===== Wedding Planner =====");
			System.out.println("1. Add guest");
			System.out.println("2. Confirm guest");
			System.out.println("3. Add vendor");
			System.out.println("4. Show vendors");
			System.out.println("5. Add expense");
			System.out.println("6. Show all expenses");
			System.out.println("7. Show full wedding plan");
			System.out.println("0. Exit");

			System.out.print("Choose an option: ");
			String opt = scanner.nextLine();

			switch (opt) {
				case "1" -> {
					System.out.print("Guest name: ");
					String name = scanner.nextLine();
					plan.addGuest(new Guest(name));
					System.out.println("✅ Guest added.");
				}
				case "2" -> {
					System.out.println("Guests:");
					var guests = plan.getGuests();
					for (int i = 0; i < guests.size(); i++) {
						System.out.println(i + ". " + guests.get(i));
					}
					System.out.print("Enter index of guest to confirm: ");
					int index = Integer.parseInt(scanner.nextLine());
					if (index >= 0 && index < guests.size()) {
						guests.get(index).confirm();
						System.out.println("✅ Guest confirmed.");
					} else {
						System.out.println("❌ Invalid index.");
					}
				}
				case "3" -> {
					System.out.print("Vendor type (e.g., DJ, Photographer): ");
					String type = scanner.nextLine();
					System.out.print("Vendor name: ");
					String name = scanner.nextLine();
					plan.addVendor(new Vendor(type, name));
					System.out.println("✅ Vendor added.");
				}
				case "4" -> {
					System.out.println("Vendors:");
					var vendors = plan.getVendors();
					if (vendors.isEmpty()) {
						System.out.println(" - No vendors added.");
					} else {
						vendors.forEach(v ->
								System.out.println(" - Type: " + v.type() + ", Name: " + v.name())
						);

					}
				}

				case "5" -> {
					System.out.print("Expense description: ");
					String desc = scanner.nextLine();
					System.out.print("Amount (RON): ");
					double amount = Double.parseDouble(scanner.nextLine());
					plan.addExpense(new Expense(desc, amount));
					System.out.println("✅ Expense added.");
				}
				case "6" -> {
					System.out.println("💸 Expenses:");
					var expenses = plan.getExpenses();
					if (expenses.isEmpty()) {
						System.out.println(" - No expenses added.");
					} else {
						expenses.forEach(e ->
								System.out.println(" - " + e.description() + ": " + e.amount() + " RON")
						);

					}
				}

				case "7" -> plan.showPlan();
				case "0" -> {
					System.out.println("👋 Goodbye!");
					return;
				}
				default -> System.out.println("❌ Invalid option.");
			}
		}
	}
}


