package poolside.controller.dto.response;

import lombok.Getter;
import poolside.entity.Price;

@Getter
public class PriceResponseDto {
    private Long productId;
    private String seasonDvcd; // 계절구분코드 00:비수기, 01:성수기, 02:준성수기
    private String description;
    private String startDate;
    private String endDate;
    private String childPrice; // 아이 추가 요금
    private String addPrice; //성인 추가 요금
    private String totPrice; // 총 요금

    public PriceResponseDto(Price price) {
        this.productId = price.getProductId();
        this.seasonDvcd = price.getSeasonDvcd();
        this.description = price.getDescription();
        this.startDate = price.getStartDate();
        this.endDate = price.getEndDate();
        this.childPrice = price.getChildPrice();
        this.addPrice = price.getAddPrice();
        this.totPrice = price.getTotPrice();
    }
}
