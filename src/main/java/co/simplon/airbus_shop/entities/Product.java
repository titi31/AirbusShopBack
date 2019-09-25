package co.simplon.airbus_shop.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product implements Serializable {
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String description;
        private double currentprice;
        private boolean promotion;
        private boolean selected;
        private boolean available;
        private String photoName;
       // private double price;
       // private int quantity;
        @ManyToOne
        private Category category;

    }

