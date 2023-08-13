package poolside.controller.dto.response;

import lombok.Getter;
import poolside.entity.Product;

@Getter
public class ProductResponseDto {
    private Long id;
    private Integer totCnt; //상품개수
    private String description;
    private Integer stdCnt;
    private Integer maxCnt;

    public ProductResponseDto(Product product) {
        this.id = product.getId();
        this.totCnt = product.getTotCnt();
        this.description = product.getDescription();
        this.stdCnt = product.getStdCnt();
        this.maxCnt = product.getMaxCnt();
    }
}
