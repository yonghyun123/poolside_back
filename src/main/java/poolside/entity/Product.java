package poolside.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "ps_product")
public class Product extends BaseEntity{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    @Column(name = "tot_cnt")
    private Integer totCnt; //상품개수
    private String description;
    private Integer stdCnt;
    private Integer maxCnt;

    @Builder
    public Product(Integer totCnt, String description, Integer stdCnt, Integer maxCnt) {
        this.totCnt = totCnt;
        this.description = description;
        this.stdCnt = stdCnt;
        this.maxCnt = maxCnt;
    }

    //Update dirty checking
    public void update(Integer totCnt, String description, Integer stdCnt, Integer maxCnt) {
        this.totCnt = totCnt;
        this.description = description;
        this.stdCnt = stdCnt;
        this.maxCnt = maxCnt;
    }

}
