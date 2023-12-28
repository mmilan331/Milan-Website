package mmilan.MilanWebsite.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import mmilan.MilanWebsite.models.Account;
import mmilan.MilanWebsite.repository.AccountDatabase;

@Component
public class Loader implements CommandLineRunner{
  
  @Autowired
  AccountDatabase accountDB;

  @Override
  public void run(String... args) throws Exception {
    localSeedData();
  }

  private void localSeedData(){
    if (accountDB.count() == 0){
      Account adminAcc = new Account("admin", "admin", "test@admin.com", "1234567890");
      accountDB.save(adminAcc);
    }
  }
}
