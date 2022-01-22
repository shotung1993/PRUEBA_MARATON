package pe.lacafetalab.pao.register.application;

import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.shared.domain.bus.command.CommandHandler;

@Service
public final class RegisterCommandHandler implements CommandHandler<RegisterCommand> {

    private final Register service;

    public RegisterCommandHandler(Register service) {
        this.service = service;
    }

    @Override
    public void handle(RegisterCommand command) {

        service.execute(command.getTipo(), command.getRuc());
    }
}
