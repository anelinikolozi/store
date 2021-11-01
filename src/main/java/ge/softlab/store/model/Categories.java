package ge.softlab.store.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@SequenceGenerator(name = "categoriesIdGenerator",sequenceName = "categories_id_seq",allocationSize = 1)
@Table(name = "categories")
public class Categories {
    @Id
    @GeneratedValue(generator = "categoriesIdGenerator",strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    Long id;

    @Column(name = "parent_id")
    Long parentId;

    @Column(name = "category_name")
    String categoryName;
}
