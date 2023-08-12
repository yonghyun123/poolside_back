package poolside.common.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import poolside.common.enumcode.CodeEnum;


@Getter
public class Response<T> {

    private String status;
    private String message;
    private String detailMessage;
    private String statusName;
    private ErrorInfo errorInfo;
    private Object info;
    private T result;

    public Response(String status, String statusName, String message, T result, ErrorInfo errorInfo, String detailMessage, Object info) {
        this.status = status;
        this.statusName = statusName;
        this.message = message;
        this.result = result;
        this.errorInfo = errorInfo;
        this.detailMessage = detailMessage;
        this.info = info;
    }

    // Factory
    public static <T> Response<T> ok(T body) {
        return new ResponseBuilder<T>().result(body).build();
    }

    public static <T> Response<T> ok() {
        return new ResponseBuilder<T>().build();
    }

    public static <T> ResponseBuilder<T> builder() {
        return new ResponseBuilder<>();
    }

    // Builder
    public static class ResponseBuilder<T> {
        private static final CodeEnum DEFAULT_STATUS = CodeEnum.STATUS_SUCCESS;
        private String status = DEFAULT_STATUS.getCode();
        private String statusName = DEFAULT_STATUS.name();
        private String message = DEFAULT_STATUS.getDefaultMessage();
        private String detailMessage = StringUtils.EMPTY;
        private T result;
        private ErrorInfo errorInfo;
        private Object info;

        public Response.ResponseBuilder<T> status(String code, String name, String message) {
            this.status = code;
            this.statusName = name;
            this.message = message;
            return this;
        }

        public Response.ResponseBuilder<T> statusAndMessage(String status, String message) {
            return status(status, null, message);
        }


        public Response.ResponseBuilder<T> errorInfo(ErrorInfo errorInfo) {
            this.errorInfo = errorInfo;
            return this;
        }

        public Response.ResponseBuilder<T> result(T result) {
            this.result = result;
            return this;
        }

        public Response.ResponseBuilder<T> detailMessage(String detailMessage) {
            this.detailMessage = detailMessage;
            return this;
        }

        public Response.ResponseBuilder<T> info(Object info) {
            this.info = info;
            return this;
        }

        public Response<T> build() {
            return new Response<>(status, statusName, message, result, errorInfo, detailMessage, info);
        }
    }

    @Getter
    @Setter
    @Builder
    public static class ErrorInfo {
        private String errCd;
        private String errMsgCtnt;
        private String errMsgDesc;
    }
}