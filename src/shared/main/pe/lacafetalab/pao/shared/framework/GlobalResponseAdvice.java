package pe.lacafetalab.pao.shared.framework;

import java.util.logging.Logger;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import pe.lacafetalab.pao.shared.model.util.NumberUtils;
import pe.lacafetalab.pao.shared.response.RestResponse;

@ControllerAdvice
@SuppressWarnings("rawtypes")
public class GlobalResponseAdvice implements ResponseBodyAdvice<Object> {
	static Logger logger = Logger.getLogger(GlobalResponseAdvice.class.getName());

	@Override
	public boolean supports(MethodParameter returnType, Class converterType) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

		if (body == null || !RestResponse.class.isAssignableFrom(body.getClass())) {
			ServletServerHttpResponse servletResponse = (ServletServerHttpResponse) response;
			int statusCode = servletResponse.getServletResponse().getStatus();
			boolean successResult = statusCode < 400;
			String successMsg = successResult ? "OK" : "ERROR";
			logger.info("RESPONSE_ : " +
					" | Transaccion: " + ApplicationContext.getContext().getTransactionId() +
					" | uri __" + ApplicationContext.getContext().getUri() + "__" +
					" | url __" + request.getURI() + "__" +
					" | UserIdHeader: " + ApplicationContext.getContext().getUserId() +
					" | status: " + statusCode + " | success: " + successResult + " | code: " + NumberUtils.getFirstDigit(statusCode) +
					" | message: " + successMsg);
			return new RestResponse(successResult, statusCode, NumberUtils.getFirstDigit(statusCode), successMsg, body == null ? new Object() : body);
		}
		Class<?> clazz = body.getClass();
		try {
			var success = (boolean) clazz.getDeclaredField("success").get(body);
			var statusCode = (int) clazz.getDeclaredField("statusCode").get(body);
			var code = (int) clazz.getDeclaredField("code").get(body);
			var message = (String) clazz.getDeclaredField("message").get(body);
			logger.info("RESPONSE_ : " +
					" | Transaccion: " + ApplicationContext.getContext().getTransactionId() +
					" | uri __" + ApplicationContext.getContext().getUri() + "__" +
					" | url __" + request.getURI() + "__" +
					" | UserIdHeader: " + ApplicationContext.getContext().getUserId() +
					" | status: " + statusCode + " | success: " + success + " | code: " + code +
					" | message: " + message);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return body;
	}
}