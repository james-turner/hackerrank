package LeetCode;

import java.util.Arrays;
import java.util.Collections;

public class ConvertIntToChar {

    public static void main(String[] args) {

        int i = 97;
        char c = (char)i;
        System.out.println(c);

        char b = 'b';
        int j = b;
        System.out.println(j);

        Character k = new Character('k');
        System.out.println((int)k);

        System.out.println((char)(int)new Integer(99));

        System.out.println('a' - 97);
        System.out.println((char)('a' + 2));
    }
}
