package mmilan.MilanWebsite.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
public class Account {
    
//accountID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long accountID;

//username
    @Getter
    @Setter
    private String username;

//FOR SIMPLICITY, I AM STORING THIS AS A STRING
//  - Look into encryption
//password
    @Getter
    @Setter
    private String password;

//Public Constructor
    public Account(){}

//Parameterized Constructor
    public Account(String username, String password){
        this.username = username;
        this.password = password;
    }
}
