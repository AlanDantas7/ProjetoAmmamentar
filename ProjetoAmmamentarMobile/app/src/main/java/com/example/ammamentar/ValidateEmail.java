package com.example.ammamentar;

import android.util.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateEmail {

    public static boolean isEmailValid(String txtRegEmail) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        Matcher matcher = pattern.matcher(txtRegEmail);
        return matcher.matches();
    }
}
