package jcorreia.luxclusif.challenge.webapp_challenge.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "client")
public class Client extends GenericModel {

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "vatNumber")
    private String vatNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private String age;

    @Column(name = "phone")
    private String phone;

    @OneToMany
    @JoinTable(
            name = "client_item",
            joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id")
    )
    private List<Item> listOfItems;

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", vatNumber='" + vatNumber + '\'' +
                ", email='" + email + '\'' +
                ", age='" + age + '\'' +
                ", phone='" + phone + '\'' +
                ", listOfItems=" + listOfItems +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}