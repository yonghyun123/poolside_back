package poolside.controller.dto.request;

import lombok.Getter;
import poolside.entity.Price;
import poolside.entity.Product;

@Getter
public class PriceSaveRequestDto {
    private Long productId;
    private String seasonDvcd; // 계절구분코드 00:비수기, 01:성수기, 02:준성수기
    private String description;
    private String startDate;
    private String endDate;
    private String childPrice; // 아이 추가 요금
    private String addPrice; //성인 추가 요금
    private String totPrice; // 총 요금

    public PriceSaveRequestDto(Long productId, String seasonDvcd, String description, String startDate, String endDate, String childPrice, String addPrice, String totPrice) {
        this.productId = productId;
        this.seasonDvcd = seasonDvcd;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.childPrice = childPrice;
        this.addPrice = addPrice;
        this.totPrice = totPrice;
    }

    public Price toEntity() {
        return Price.builder()
                .productId(productId)
                .seasonDvcd(seasonDvcd)
                .description(description)
                .startDate(startDate)
                .endDate(endDate)
                .childPrice(childPrice)
                .addPrice(addPrice)
                .totPrice(totPrice)
                .build();
    }
}
