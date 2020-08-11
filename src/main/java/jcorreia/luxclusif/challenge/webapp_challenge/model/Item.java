package jcorreia.luxclusif.challenge.webapp_challenge.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "item")
public class Item extends GenericModel {

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "brand")
    private String brand;

    @Column(name = "isActive")
    private Boolean active;
}
