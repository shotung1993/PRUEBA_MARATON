package pe.lacafetalab.pao.shared.utils.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import pe.lacafetalab.base.ddd.domain.exception.LoginException;
import pe.lacafetalab.pao.shared.utils.EncriptService;
import pe.lacafetalab.pao.shared.utils.JsonWebTokenEncriptService;

@RunWith(MockitoJUnitRunner.class)
@TestMethodOrder(OrderAnnotation.class)
public class JsonWebTokenEncriptServiceTest {

	static EncriptService encriptService01 = new JsonWebTokenEncriptService("encriptService01");
	static EncriptService encriptService02 = new JsonWebTokenEncriptService("encriptService02");

	@BeforeAll
	public static void beforeAll() {

	}

	@Test
	@Order(1)
	public void test01_encript() {
		assertThrows(LoginException.class, () -> encriptService01.decript("aaa"));
	}

	@Test
	@Order(2)
	public void test01_computeSHA1256() {
		String secure = encriptService01.computeSHA1256("aaa");
		assertNotNull(secure);
	}

	@Test
	@Order(3)
	public void test01_generate() {
		String secure = encriptService01.generate();
		assertNotNull(secure);
	}

}
