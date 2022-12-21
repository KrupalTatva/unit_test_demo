package com.example.unittestdemo.Utils;

public class Utils {

    public static boolean checkIsValid(String userName ,String password , String confirmPassword){
        if (
                        userName.isEmpty() ||
                        password.isEmpty() ||
                        confirmPassword.isEmpty() ||
                        !password.equals(confirmPassword)
        ){
            return false;
        }
        return true;
    }
}
