package poolside.controller.dto.request;

import lombok.Getter;
import poolside.entity.Product;

@Getter
public class ProductSaveRequestDto {
    private Integer totCnt;
    private String description;
    private Integer stdCnt;
    private Integer maxCnt;

    public ProductSaveRequestDto(Integer totCnt, String description, Integer stdCnt, Integer maxCnt) {
        this.totCnt = totCnt;
        this.description = description;
        this.stdCnt = stdCnt;
        this.maxCnt = maxCnt;
    }

    public Product toEntity() {
        return Product.builder()
                .description(description)
                .maxCnt(maxCnt)
                .stdCnt(stdCnt)
                .totCnt(totCnt)
                .build();
    }
}
