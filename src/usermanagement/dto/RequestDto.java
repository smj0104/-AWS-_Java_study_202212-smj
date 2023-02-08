package usermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class RequestDto<T> {
	private String resource;
	private T body;
}
