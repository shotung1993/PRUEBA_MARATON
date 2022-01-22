package pe.lacafetalab.pao.shared.domain.bus.command;

public final class CommandNotRegisteredError extends Exception {

	private static final long serialVersionUID = 1L;

	public CommandNotRegisteredError(Class<? extends Command> command) {
		super(String.format("The command <%s> hasn't a command handler associated", command.toString()));
	}
}
