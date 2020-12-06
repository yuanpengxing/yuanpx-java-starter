package basic;

import org.testng.annotations.Test;

public class RegexMgr {

    /**
     * [abc] a、b 或 c（简单类）
     * [^abc] 任何字符，除了 a、b 或 c（否定）
     * [a-zA-Z] a 到 z 或 A 到 Z，两头的字母包括在内（范围）
     * [a-d[m-p]] a 到 d 或 m 到 p：[a-dm-p]（并集）
     * [a-z&&[def]] d、e 或 f（交集）
     * [a-z&&[^bc]] a 到 z，除了 b 和 c：[ad-z]（减去）
     * [a-z&&[^m-p]] a 到 z，而非 m 到 p：[a-lq-z]（减去）
     */
    @Test
    public void test01() {
        String regex = "[a-z&&[^m-p]]";
        System.out.println("m".matches(regex));
        System.out.println("a".matches(regex));
        System.out.println("z".matches(regex));
        System.out.println("n".matches(regex));
    }

    /**
     * . 任何字符
     * \d 数字：[0-9]
     * \D 非数字： [^0-9]
     * \s 空白字符：[ \t\n\x0B\f\r]
     * \S 非空白字符：[^\s]
     * \w 单词字符：[a-zA-Z_0-9]
     * \W 非单词字符：[^\w]
     */
    @Test
    public void test02() {
        String regex = "\\W";
        System.out.println("a".matches(regex));
        System.out.println("z".matches(regex));
        System.out.println("_".matches(regex));
        System.out.println("%".matches(regex));
    }

    /**
     *         X? X，一次或一次也没有
     *         X* X，零次或多次
     *         X+ X，一次或多次
     *         X{n} X，恰好 n 次
     *         X{n,} X，至少 n 次
     *         X{n,m} X，至少 n 次，但是不超过 m 次
     */
    @Test
    public void test03() {
        String regex = "[abc]{5,15}";
        System.out.println("abcba".matches(regex));
        System.out.println("abcbaabcabbabab".matches(regex));
        System.out.println("abcb".matches(regex));
        System.out.println("abcbaabaabcbaab".matches(regex));
    }
}
