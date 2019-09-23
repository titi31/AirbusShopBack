package co.simplon.airbus_shop.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Products implements Serializable {
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
        private Long id;
        private String designation;
        private double price;
        private int quantity;


    }

