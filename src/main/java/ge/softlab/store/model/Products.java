package ge.softlab.store.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "products")
@SequenceGenerator(name = "eanCodeGenerator",sequenceName = "products_ean_code_seq",allocationSize = 1)
public class Products {
    @Id
    @Column(name = "ean_code")
    @GeneratedValue(generator = "eanCodeGenerator",strategy = GenerationType.SEQUENCE)
    private Long eanCode;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "maker_id")
    private Long makerId;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "sell_price")
    private Float sellPrice;

    @Column(name = "remaining")
    private Integer remaining;





}
