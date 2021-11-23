package ge.softlab.store.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@SequenceGenerator(name = "purchaseIdGenerator",sequenceName = "purchases_id_seq",allocationSize = 1)
@Table(name = "purchases")
public class Purchases {
    @GeneratedValue(generator = "purchaseIdGenerator",strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "purchase_price")
    private Float purchasePrice;


    @Column(name = "purchase_date")
    private LocalDateTime purchaseDate;
}
