package StreamApi;

import java.util.stream.Collectors;

public class StringReverse {
    public static void main(String[] args) {

        String str = "abcdef";

        String output = stringRev(str);
        System.out.println(output);

    }
    public static String stringRev(String str)
    {

        String output = str.chars().mapToObj(c->String.valueOf((char)c)).reduce((s1,s2)-> s2 + s1).orElse("");
        return output;
    }
}
