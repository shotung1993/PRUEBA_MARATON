package pe.lacafetalab.pao.shared.usecase.get_ruc;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.shared.infrastructure.ExternalHttpService;
import pe.lacafetalab.pao.shared.infrastructure.ExternalHttpServiceImpl;

import java.util.Map;

@Service
public final class GetRuc {

	private final ExternalHttpService externalHttpService;
	private final String searchReaderId;

	public GetRuc(ExternalHttpService externalHttpService,
								  @Value("${ruc.url}") String url) {
		super();
		this.externalHttpService = externalHttpService;
		this.searchReaderId = url + "?tipo={TIPO}&ruc={RUC}&token=cXdlcnR5bGFtYXJja19zYUBob3RtYWlsLmNvbXF3ZXJ0eQ==";
	}

	public GetRucResponse execute(String tipo, String ruc) {
		String url = searchReaderId.replace("{TIPO}", tipo);
		url = url.replace("{RUC}", ruc);;

		ExternalHttpServiceImpl.ExternalResponse<GetRucResponse> response = externalHttpService.doRequest(url, "GET",
				Map.of(ExternalHttpService.CONTENT_TYPE_NAME, ExternalHttpService.CONTENT_TYPE_VALUE), null,
				GetRucResponse.class);
		return response.getResponse();
	}
}

@Getter
@Setter
class ApiResponse {
	private GetRucResponse data;
}
