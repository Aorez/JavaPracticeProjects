package com.bjsxt;

public class RegexTest {
    public static void main(String[] args) {
        //String regex = "[^ab]*";
       /* String regex = "\\W*";
        String content = "#@￥&#####";*/
       /*String regex = "[a-z]{1}\\w{3,8}";
       String content = "a234s_df";*/
       String regex = "(\\d{3,4})-(\\d{7,8})";
       String content = "010-1231231";
        System.out.println(content.matches(regex));

        String str = "(\\d{3,4}-\\d{7,8})|([1]{1}[0-9]{10})";
        String email = "155846370211";
        System.out.println(email.matches(str));
    }
}
