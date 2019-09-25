package co.simplon.airbus_shop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category implements Serializable {
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String photo;
    private String description;
    @OneToMany(mappedBy="category")
    private Collection<Product> product;

}
