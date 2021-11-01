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
    Long eanCode;

    @Column(name = "product_name")
    String productName;

    @Column(name = "description")
    String descrioption;

    @Column(name = "maker_id")
    Long makerId;

    @Column(name = "category_id")
    Long categoryId;

    @Column(name = "sell_price")
    Float sellPrice;

    @Column(name = "remaining")
    Integer remaining;





}
