package WeddingPlanner.Project;

import WeddingPlanner.Project.model.Expense;
import WeddingPlanner.Project.model.Guest;
import WeddingPlanner.Project.model.Vendor;
import WeddingPlanner.Project.model.WeddingPlan;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WeddingPlanTest {

    @Test
    void testAddGuestAndConfirm() {
        WeddingPlan plan = new WeddingPlan(1000);
        Guest guest = new Guest("Ana");
        plan.addGuest(guest);

        assertEquals(1, plan.getGuests().size());
        assertFalse(plan.getGuests().get(0).isConfirmed());

        guest.confirm();
        assertTrue(plan.getGuests().get(0).isConfirmed());
    }

    @Test
    void testAddExpenseAndBudget() {
        WeddingPlan plan = new WeddingPlan(2000);
        plan.addExpense(new Expense("Flowers", 500));
        plan.addExpense(new Expense("Catering", 1000));

        assertEquals(2, plan.getExpenses().size());
        assertEquals(1500, plan.getTotalExpenses());
        assertEquals(500, plan.getRemainingBudget());
    }

    @Test
    void testAddVendor() {
        WeddingPlan plan = new WeddingPlan(1000);
        Vendor vendor = new Vendor("Catering", "Tasty Foods");
        plan.addVendor(vendor);

        assertEquals(1, plan.getVendors().size());
        assertEquals("Catering", plan.getVendors().get(0).type());
        assertEquals("Tasty Foods", plan.getVendors().get(0).name());
    }
}

