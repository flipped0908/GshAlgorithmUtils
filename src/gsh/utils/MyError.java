package gsh.utils;

public class MyError  extends RuntimeException {

    public static void myerror(String msg){
        throw new RuntimeException("MY_ERROR : "+msg);
    }
}
