package client.addressbook;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @OneToMany(cascade = CascadeType.PERSIST)
    private final List<BuddyInfo> buddies;
    @Id
    @GeneratedValue
    private Long id;

    public AddressBook() {
        this.buddies = new ArrayList<>();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addBuddy(BuddyInfo buddy) {
        this.buddies.add(buddy);
    }

    public List<BuddyInfo> getBuddies() {
        return this.buddies;
    }

    public int getSize() {
        return this.buddies.size();
    }
}
