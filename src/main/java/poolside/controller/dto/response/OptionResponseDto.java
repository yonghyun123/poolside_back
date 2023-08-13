package poolside.controller.dto.response;

import lombok.Getter;
import poolside.entity.Option;

@Getter
public class OptionResponseDto {
    private String description;
    private String price;

    public OptionResponseDto(Option option) {
        this.description = option.getDescription();
        this.price = option.getPrice();
    }

}
