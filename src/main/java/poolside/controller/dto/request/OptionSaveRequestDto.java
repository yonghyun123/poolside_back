package poolside.controller.dto.request;

import lombok.Getter;
import poolside.entity.Option;
import poolside.entity.Product;

@Getter
public class OptionSaveRequestDto {

    private String description;
    private String price;

    public OptionSaveRequestDto(String description, String price){
        this.description = description;
        this.price = price;
    }

    public Option toEntity() {
        return Option.builder()
                .description(description)
                .price(price)
                .build();
    }
}
