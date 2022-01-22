package pe.lacafetalab.pao.shared.utils.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.lacafetalab.pao.shared.infrastructure.helper.CSVFieldsParser;
import pe.lacafetalab.pao.shared.infrastructure.helper.CSVFieldsParser.CourseIdParsed;
import pe.lacafetalab.pao.shared.infrastructure.helper.CSVFieldsParser.CourseShortNameParsed;
import pe.lacafetalab.pao.shared.infrastructure.helper.CSVFieldsParser.TermIdParsed;

@RunWith(MockitoJUnitRunner.class)
@DisplayName("ParseCSVFields Tests")
public class ParseCSVFieldsTests {

	static Logger logger = LoggerFactory.getLogger(ParseCSVFieldsTests.class);

	@Test
	@DisplayName("Tests the short name CSV parsed value")
	public void testParseCourseShortName() {

		CSVFieldsParser parser = new CSVFieldsParser();
		CourseShortNameParsed shortName = parser.parseCourseShortName("X104: 04182-[FISE--PELPOLIMAS01MP]");

		assertEquals("X104", shortName.getCatalogCode(), "course code");
		assertEquals("4182", shortName.getNroClass(), "section code ");
		assertEquals("FISE", shortName.getFacultyCode(), "faculty");
		assertEquals("PELPO", shortName.getProgramCode(), "program");
		assertEquals("LIMAS", shortName.getCampus(), "campus");
		assertEquals("01", shortName.getCycle(), "cycle");
		assertEquals("M", shortName.getTurn(), "turn");
		assertEquals("P", shortName.getModality(), "modality");

		shortName = parser.parseCourseShortName("PS49: 02556-[FACHUMPSICOAREQU07MP]");
		assertEquals("PS49", shortName.getCatalogCode(), "course code");
		assertEquals("2556", shortName.getNroClass(), "section code ");
		assertEquals("FACHUM", shortName.getFacultyCode(), "faculty");
		assertEquals("PSICO", shortName.getProgramCode(), "program");
		assertEquals("AREQU", shortName.getCampus(), "campus");
		assertEquals("07", shortName.getCycle(), "cycle");
		assertEquals("M", shortName.getTurn(), "turn");
		assertEquals("P", shortName.getModality(), "modality");
	}

	@Test
	@DisplayName("Tests the CourseId CSV parsed value")
	public void testParseCourseId() {

		CSVFieldsParser parser = new CSVFieldsParser();
		CourseIdParsed shortName = parser.parseCourseId("2201100000X1044182");

		assertEquals("2201", shortName.getPeriod(), "Period");
		assertEquals("100000X104", shortName.getCourseCode(), "CourseCode");
		assertEquals("4182", shortName.getNroClass(), "NroClass");

		shortName = parser.parseCourseId("2201100000NI075685");

		assertEquals("2201", shortName.getPeriod(), "Period");
		assertEquals("100000NI07", shortName.getCourseCode(), "CourseCode");
		assertEquals("5685", shortName.getNroClass(), "NroClass");
	}

	@Test
	@DisplayName("Tests the TermId CSV parsed value")
	public void testTermId() {

		CSVFieldsParser parser = new CSVFieldsParser();
		TermIdParsed shortName = parser.parseTermId("2201PREG001");

		assertEquals("2201", shortName.getPeriod(), "Period");
		assertEquals("PREG", shortName.getAcadCareer(), "AcadCareer");
		assertEquals("001", shortName.getModule(), "Module");
	}

	@Test
	@DisplayName("Tests the Long CSV parsed value")
	public void testLongName() {

		CSVFieldsParser parser = new CSVFieldsParser();
		String longName = parser.processLongName("COMERCIO Y NEGOCIOS GLOBALES (5580)");
		assertEquals("COMERCIO Y NEGOCIOS GLOBALES", longName, "Period");

		longName = parser.processLongName("INTRODUCCIÓN A LA VIDA UNIVERSITARIA: INGENIERÍA");
		assertEquals("INTRODUCCIÓN A LA VIDA UNIVERSITARIA: INGENIERÍA", longName, "Period");
	}
}