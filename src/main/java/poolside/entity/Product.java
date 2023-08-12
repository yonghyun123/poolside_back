package poolside.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "ps_product")
public class Product extends BaseEntity{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    @Column(name = "tot_cnt")
    private String totCnt;
    private String description;
    private String stdCnt;
    private Integer maxCnt;
}
