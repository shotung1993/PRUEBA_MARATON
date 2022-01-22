package pe.lacafetalab.pao.shared.response;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pe.lacafetalab.pao.shared.domain.bus.query.Response;

@Getter
@Setter
public class RestResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public boolean success = false;
	@JsonIgnore
	public int statusCode;
	public int code;
	public String message;
	public Object data;
	
	public RestResponse(boolean success, int statusCode, int code, String message, Object data) {
		this.success = success;
		this.statusCode = statusCode;
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public static ResponseEntity<RestResponse> list(List<? extends Response> list) {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(new RestResponse(true, 200, 2, "", list));
	}

	public static ResponseEntity<RestResponse> ok() {
		return RestResponse.ok("ok");
	}

	public static ResponseEntity<RestResponse> ok(Object data) {
		return ResponseEntity.status(HttpStatus.OK).body(new RestResponse(true, 200, 2, "", data));
	}
}
