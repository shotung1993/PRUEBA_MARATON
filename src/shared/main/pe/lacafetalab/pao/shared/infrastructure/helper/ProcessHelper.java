package pe.lacafetalab.pao.shared.infrastructure.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;

public class ProcessHelper {

	private static Logger LOGGER = LoggerFactory.getLogger(ProcessHelper.class);

	public static RetryActionDefinition<Void> processWithRetries(Runnable runnable) {
		return (identifier, tries) -> {
			int initial = tries;
			while (true) {
				try {
					runnable.run();
					if (tries < initial) {
						LOGGER.info("the record related with identifier[{}] processed when times left were: [{}]",
								identifier, tries);
					}
					break;
				} catch (DataIntegrityViolationException e) {
					tries--;
					LOGGER.info("the record related with identifier[{}] already exists. Times left: [{}]", identifier,
							tries);
					if (tries <= 0) {
						throw e;
					}
				}
			}
		};
	}

	public static interface RetryActionDefinition<U> {
		void execute(String identifier, Integer n);
	}
}