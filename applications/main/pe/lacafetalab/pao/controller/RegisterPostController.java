package pe.lacafetalab.pao.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pe.lacafetalab.pao.register.application.RegisterCommand;
import pe.lacafetalab.pao.shared.domain.bus.command.CommandBus;
import pe.lacafetalab.pao.shared.domain.bus.command.CommandHandlerExecutionError;
import pe.lacafetalab.pao.shared.domain.bus.command.CommandNotRegisteredError;
import pe.lacafetalab.pao.shared.domain.bus.query.QueryBus;
import pe.lacafetalab.pao.shared.framework.ApiController;
import pe.lacafetalab.pao.shared.response.RestResponse;


@RestController
public final class RegisterPostController extends ApiController {
    public RegisterPostController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<RestResponse> index(@RequestBody RequestSave request)
            throws CommandHandlerExecutionError, CommandNotRegisteredError {
        dispatch(new RegisterCommand(request.getTipo(), request.getRuc()));
        return RestResponse.ok();
    }

}

@Setter
@Getter
final class RequestSave {
    private String tipo;
    private String ruc;
}


