package gsh.demo.practice07_bitOperation;


/**
 * 不用额外的变量交换两个数的值
 */
public class Code01_changeNum {


    public static void change(int a , int b){

        System.out.println(a + "   "+b);
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println(a + "   "+b);

    }


    public static void main(String[] args) {

        int a = 1;
        int b = 5;

        change(a,b);

        System.out.println(a + "   "+b);




    }


}
