package crud.objectmapper.example.utils.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;


public class ResponseDTO<T> extends HttpEntity<T> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    ResponseDTO(T body, HttpStatus status) {
        super(body);
    }


    public static Builder accepted() {
        return status(HttpStatus.ACCEPTED);
    }

    public static Builder badRequest() {
        return status(HttpStatus.BAD_REQUEST);
    }

    public static Builder status(HttpStatus status) {
        return new BodyBuilder(status);
    }

    public interface Builder {
        <T> ResponseDTO<T> convertTo(Object entity, Class<T> aClass);
    }

    private static class BodyBuilder  implements Builder{
        private final HttpStatus status;

        public BodyBuilder(HttpStatus status) {
            this.status = status;
        }

        public <T> ResponseDTO<T> convertTo(Object entity, Class<T> aClass) {
            Assert.notNull(AnnotationUtils.getAnnotation(aClass, DTO.class),
                    "Object Needs to have @DTO annotation");

            return new ResponseDTO<>(objectMapper.convertValue(entity, aClass), this.status);
        }
    }

}
