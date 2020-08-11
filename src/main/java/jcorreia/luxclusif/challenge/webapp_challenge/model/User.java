package jcorreia.luxclusif.challenge.webapp_challenge.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    private String userName;
    private String password;

    @OneToOne
    private Client client;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
