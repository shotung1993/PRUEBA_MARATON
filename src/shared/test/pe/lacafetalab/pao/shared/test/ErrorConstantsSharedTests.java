package pe.lacafetalab.pao.shared.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.lacafetalab.base.ddd.domain.exception.BadRequestException;
import pe.lacafetalab.pao.shared.domain.ErrorConstantsShared;
import pe.lacafetalab.pao.shared.utils.ConstantValuesVerifier;

@RunWith(MockitoJUnitRunner.class)
@DisplayName("Shared Tests")
public class ErrorConstantsSharedTests {

	static Logger logger = LoggerFactory.getLogger(ErrorConstantsSharedTests.class);

	@Test
	@DisplayName("Test the error constant values are not repeated")
	public void test01() {
		try {
			ConstantValuesVerifier.verifierNoDuplicatedValues(ErrorConstantsShared.class);
		} catch (BadRequestException e) {
			assertTrue(false, e.getMessage());
		}
	}

}
