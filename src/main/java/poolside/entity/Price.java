package poolside.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table
public class Price extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_id")
    private Long id;

    private Long productId;
    @Column(name = "sesn_dvcd")
    private String seasonDvcd; //계절구분코드 00:비수기, 01:성수기, 02:준성수기
    private String description;
    @Column(name = "stdt")
    private String startDate;
    @Column(name = "endt")
    private String endDate;
    @Column(name = "chd_price")
    private String childPrice; //아이 추가 요금
    @Column(name = "ad_price")
    private String addPrice; //추가 요금
    private String totPrice; //총 요금

    @Builder
    public Price(Long productId, String seasonDvcd, String description, String startDate, String endDate, String childPrice, String addPrice, String totPrice) {
        this.productId = productId;
        this.seasonDvcd = seasonDvcd;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.childPrice = childPrice;
        this.addPrice = addPrice;
        this.totPrice = totPrice;
    }

    public void update(Long productId, String seasonDvcd, String description, String startDate, String endDate, String childPrice, String addPrice, String totPrice) {
        this.productId = productId;
        this.seasonDvcd = seasonDvcd;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.childPrice = childPrice;
        this.addPrice = addPrice;
        this.totPrice = totPrice;
    }
}
