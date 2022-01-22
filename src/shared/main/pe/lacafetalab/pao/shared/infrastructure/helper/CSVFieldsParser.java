package pe.lacafetalab.pao.shared.infrastructure.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.Getter;
import pe.lacafetalab.base.ddd.domain.exception.BadRequestException;

@Component
public class CSVFieldsParser {

	private static Pattern PATTERN_PARSE_LONGNAME = Pattern.compile("([\\w \\-_:]{0,}+)([\\(]?)([\\w]{0,}+)([\\)]?)",
			Pattern.UNICODE_CHARACTER_CLASS);
	private static Pattern PATTERN_PARSE_COURSEID = Pattern.compile("(\\d{4})(\\w{10})(\\w{0,}+)");
	private static Pattern PATTERN_PARSE_COURSESHORTNAME = Pattern.compile(
			"(\\w{4})([: 0]{0,}+)(\\w{4,5})(-\\[)([\\w-]{6})([\\w-]{5})([\\w-]{5})([\\w-]{2})([\\w-]{1})([\\w-]{1,2})");
	private static Pattern PATTERN_SKIP_CHARS = Pattern.compile("[- ]");

	public String processLongName(String str) {

		Matcher matcher = PATTERN_PARSE_LONGNAME.matcher(str);
		if (matcher.find()) {
			return StringUtils.defaultString(matcher.group(1)).trim();
		} else {
			throw new BadRequestException(400, "Invalid long name course in csv: " + str);
		}
	}

	public CourseIdParsed parseCourseId(String str) {

		Matcher matcher = PATTERN_PARSE_COURSEID.matcher(str);
		if (matcher.find()) {
			return CourseIdParsed.builder().period(matcher.group(1)).courseCode(matcher.group(2))
					.nroClass(matcher.group(3)).build();
		} else {
			throw new BadRequestException(400, "Invalid course id in csv: " + str);
		}
	}

	public CourseShortNameParsed parseCourseShortName(String courseShortName) {

		Matcher matcher = PATTERN_PARSE_COURSESHORTNAME.matcher(courseShortName);

		if (matcher.find()) {
			CourseShortNameParsed.CourseShortNameParsedBuilder builder = CourseShortNameParsed.builder();
			builder.catalogCode(RegExUtils.removeAll(matcher.group(1), PATTERN_SKIP_CHARS));
			builder.nroClass(RegExUtils.removeAll(matcher.group(3), PATTERN_SKIP_CHARS));
			builder.facultyCode(RegExUtils.removeAll(matcher.group(5), PATTERN_SKIP_CHARS));
			builder.programCode(RegExUtils.removeAll(matcher.group(6), PATTERN_SKIP_CHARS));
			builder.campus(RegExUtils.removeAll(matcher.group(7), PATTERN_SKIP_CHARS));
			builder.cycle(RegExUtils.removeAll(matcher.group(8), PATTERN_SKIP_CHARS));
			builder.turn(RegExUtils.removeAll(matcher.group(9), PATTERN_SKIP_CHARS));
			builder.modality(RegExUtils.removeAll(matcher.group(10), PATTERN_SKIP_CHARS));
			return builder.build();
		} else {
			throw new BadRequestException(400, "Invalid course short name in csv: " + courseShortName);
		}
	}

	public TermIdParsed parseTermId(String termId) {
		Pattern pattern = Pattern.compile("(\\w{4})(\\w{3,5})(\\w{3})");
		Matcher matcher = pattern.matcher(termId);
		if (matcher.find()) {
			return TermIdParsed.builder().period(matcher.group(1)).acadCareer(matcher.group(2)).module(matcher.group(3))
					.build();
		} else {
			throw new BadRequestException(400, "Invalid Term Id in csv: " + termId);
		}
	}

	@Getter
	@Builder
	public static class TermIdParsed {
		private String period;
		private String acadCareer;
		private String module;

	}

	@Getter
	@Builder
	public static class CourseIdParsed {
		private String period;
		private String courseCode;
		private String nroClass;
	}

	@Getter
	@Builder
	public static class CourseShortNameParsed {
		private String catalogCode;
		private String nroClass;
		private String facultyCode;
		private String programCode;
		private String campus;
		private String cycle;
		private String turn;
		private String modality;
	}
}