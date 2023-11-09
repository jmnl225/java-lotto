package calculator.support;

import java.util.List;

public class SplitSupport {

    public static final String DELIMITER = " ";

    public List<String> split(String input) {
        return List.of(input.split(DELIMITER));
    }
}
