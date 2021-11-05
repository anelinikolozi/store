package ge.softlab.store.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@SequenceGenerator(name = "makerIdSequenceGenerator",sequenceName = "makers_id_seq",allocationSize = 1)
@Table(name = "makers")
public class Makers {
    @Id
    @GeneratedValue(generator = "makerIdSequenceGenerator",strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "maker_name")
    private String makerName;

}
