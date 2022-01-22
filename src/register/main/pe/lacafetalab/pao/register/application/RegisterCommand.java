package pe.lacafetalab.pao.register.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pe.lacafetalab.pao.shared.domain.bus.command.Command;

@Getter
@AllArgsConstructor
public final class RegisterCommand implements Command {
	private final String tipo;
	private final String ruc;

}
