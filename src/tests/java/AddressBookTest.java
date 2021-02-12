import client.addressbook.AddressBook;
import client.addressbook.BuddyInfo;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AddressBookTest {
    @Test
    public void emptyAddressBookTest() {
        AddressBook book = new AddressBook();
        assertEquals(0, book.getSize());
    }

    @Test
    public void oneBuddyAddressBookTest() {
        AddressBook book = new AddressBook();
        BuddyInfo buddy = new BuddyInfo("Omar", "Ottawa", "March 14", "Shopify", "705822973");
        book.addBuddy(buddy);

        assertEquals(1, book.getSize());
    }
}