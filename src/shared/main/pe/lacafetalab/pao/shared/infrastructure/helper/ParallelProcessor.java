package pe.lacafetalab.pao.shared.infrastructure.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import reactor.core.Disposable;

@Component
public class ParallelProcessor {

	private static Logger LOGGER = LoggerFactory.getLogger(ParallelProcessor.class);

	public void waitUntilFinish(Disposable subscribe) {
		while (!subscribe.isDisposed()) {
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			LOGGER.info("Waiting......");
		}
		LOGGER.info("Processing finished {}", subscribe.isDisposed());
	}
}