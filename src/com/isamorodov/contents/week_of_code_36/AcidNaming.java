package com.isamorodov.contents.week_of_code_36;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xaxtix on 05.02.2018.
 */
public class AcidNaming {

    static void acidNaming(String acid_name) {

        if(acid_name.endsWith("in")){
            if(acid_name.startsWith("hydro")) System.out.println("non-metal acid");
            else System.out.println("polyatomic acid");
        }else {
            System.out.println("not an acid");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String acid_name = in.next();
            acidNaming(acid_name);
        }
        in.close();
    }
}
