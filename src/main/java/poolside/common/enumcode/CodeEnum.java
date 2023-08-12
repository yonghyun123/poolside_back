package poolside.common.enumcode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CodeEnum {
    STATUS_SUCCESS("200", "성공하였습니다."),
    STATUS_UNKNOWN_ERROR("500", "알수없는 에러가 발생했습니다.");

    private final String code;
    private final String defaultMessage;

}
