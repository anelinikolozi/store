package ge.softlab.store.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@SequenceGenerator(name = "purchaseIdGenerator",sequenceName = "purchases_id_seq",allocationSize = 1)
@Table(name = "purchases")
public class Purchases {
    @GeneratedValue(generator = "purchaseIdGenerator",strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "id")
    Long id;

    @Column(name = "product_id")
    Long productId;

    @Column(name = "purchase_price")
    Float purchasePrice;


    @Column(name = "purchase_date")
    String purchaseDate;
}
