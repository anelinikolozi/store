package ge.softlab.store.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@SequenceGenerator(name = "salesIdSequenceGenerator",sequenceName = "sales_id_seq",allocationSize = 1)
@Table(name = "sales")
public class Sales {
    @Id
    @GeneratedValue(generator = "salesIdSequenceGenerator",strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "sell_price")
    private Float sellPrice;

    @Column(name = "sell_date")
    private String sellDate;





}
