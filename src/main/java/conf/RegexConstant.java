package conf;

public interface RegexConstant {

    String PARENTHESES1 = "(?<=\\().*(?=\\))";
    String PARENTHESES2 = "\\[(.*?)\\]|\\((.*?)\\)";
}
