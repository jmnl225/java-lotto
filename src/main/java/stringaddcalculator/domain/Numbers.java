package stringaddcalculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : byungkyu
 * @date : 2020/12/11
 * @description :
 **/
public class Numbers {
	private static final String REGEX = ",|:";
	private static final String CUSTOM_REGEX_START = "//";
	private static final String CUSTOM_REGEX_END = "\n";

	private List<Integer> numbers;

	public Numbers(String target) {
		String[] splits = split(target);
		numbers = Arrays.stream(splits)
			.map(this::parser)
			.collect(Collectors.toList());
	}

	private int parser(String str) {
		try {
			int result = Integer.parseInt(str);
			checkPositiveNumber(result);
			return result;
		} catch (NumberFormatException e) {
			throw new RuntimeException("입력된 숫자가 올바르지 않습니다.");
		}
	}

	private void checkPositiveNumber(int result) {
		if (result < 0)
			throw new RuntimeException("음수는 사용할 수 없습니다.");
	}

	private String[] split(String target) {
		String regex = extractRegex(target);
		target = target.substring(target.indexOf(CUSTOM_REGEX_END) + 1);
		return target.split(regex);
	}

	private String extractRegex(String target) {
		if (isInvalidCustomRegexRange(target)) {
			return combineCustomRegex(target);
		}
		return REGEX;
	}

	private String combineCustomRegex(String target) {
		return target.substring(target.indexOf(CUSTOM_REGEX_START) + 2, target.indexOf(CUSTOM_REGEX_END));
	}

	private boolean isInvalidCustomRegexRange(String target) {
		return target.indexOf(CUSTOM_REGEX_START) == 0
			&& target.indexOf(CUSTOM_REGEX_END) > target.indexOf(CUSTOM_REGEX_START) + 1;
	}

	public int sum() {
		return numbers.stream()
			.reduce((x, y) -> x + y)
			.orElseThrow(() -> new RuntimeException("연산을 수행할 수 없습니다."));
	}
}