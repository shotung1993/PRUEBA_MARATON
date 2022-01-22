package pe.lacafetalab.pao.shared.utils.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import pe.lacafetalab.pao.shared.domain.valueobject.Email;
import pe.lacafetalab.pao.shared.domain.valueobject.UserId;

@RunWith(MockitoJUnitRunner.class)
@TestMethodOrder(OrderAnnotation.class)
public class UserIdFromCodeTest {

	@Test
	@Order(1)
	public void test01_getUUID_from_email() {
		Email email = new Email("1021805@utp.edu.pe");
		UserId id = new UserId(email);
		assertEquals("9f1fcc2e-48ac-525a-bcb0-5e08391c5eae", id.value());
	}
}