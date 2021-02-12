import client.addressbook.BuddyInfo;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuddyInfoTest {
    @Test
    public void emptyBuddyTest() {
        BuddyInfo buddy = new BuddyInfo();

        assertNull(buddy.getName());
        assertNull(buddy.getAddress());
        assertNull(buddy.getBirthday());
        assertNull(buddy.getCompany());
        assertNull(buddy.getPhoneNumber());
    }

    @Test
    public void idBuddyTest() {
        BuddyInfo buddy = new BuddyInfo("Omar", null, null, null, null);

        assertEquals("Omar", buddy.getName());
    }

    @Test
    public void nameBuddyTest() {
        BuddyInfo buddy = new BuddyInfo("Omar", null, null, null, null);

        assertEquals("Omar", buddy.getName());
    }

    @Test
    public void addressBuddyTest() {
        BuddyInfo buddy = new BuddyInfo(null, "Ottawa", null, null, null);

        assertEquals("Ottawa", buddy.getAddress());
    }

    @Test
    public void birthdayBuddyTest() {
        BuddyInfo buddy = new BuddyInfo(null, null, "March 14", null, null);

        assertEquals("March 14", buddy.getBirthday());
    }

    @Test
    public void companyBuddyTest() {
        BuddyInfo buddy = new BuddyInfo(null, null, null, "Shopify", null);

        assertEquals("Shopify", buddy.getCompany());
    }

    @Test
    public void phoneNumberBuddyTest() {
        BuddyInfo buddy = new BuddyInfo(null, null, null, null, "70587223");

        assertEquals("70587223", buddy.getPhoneNumber());
    }
}