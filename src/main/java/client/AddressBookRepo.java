package client;

import client.addressbook.AddressBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "address", path = "address")
public interface AddressBookRepo extends CrudRepository<AddressBook, Long> {
}
