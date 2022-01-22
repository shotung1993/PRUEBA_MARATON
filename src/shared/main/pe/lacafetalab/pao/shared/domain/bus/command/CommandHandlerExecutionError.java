package pe.lacafetalab.pao.shared.domain.bus.command;

public final class CommandHandlerExecutionError extends Throwable {

	private static final long serialVersionUID = 1L;

	public CommandHandlerExecutionError(Throwable cause) {
		super(cause);
	}
}
