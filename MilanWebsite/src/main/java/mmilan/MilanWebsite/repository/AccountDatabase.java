package mmilan.MilanWebsite.repository;

import org.springframework.data.repository.CrudRepository;
import mmilan.MilanWebsite.models.Account;

public interface AccountDatabase extends CrudRepository<Account, Long>{

  Account findByUsername(String username);
}
