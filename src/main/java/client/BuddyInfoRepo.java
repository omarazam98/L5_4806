package client;

import client.addressbook.BuddyInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "buddy", path = "buddy")
public interface BuddyInfoRepo extends CrudRepository<BuddyInfo, Long> {
}
