package gsh.demo.practice03_Tree;

import java.util.List;

/**
 * 派对的最大快乐值
 * 要求： 时间复杂度为O（N）
 */
public class Code21_happiestValue {

    public class Employee {
        public int happy;
        List<Employee> subs;
    }


    public static class ReturnType {

        public int yesHeadMax;
        public int noHeadMax;

        public ReturnType(int yes, int no) {
            yesHeadMax = yes;
            noHeadMax = no;
        }

    }


    public static ReturnType process(Employee e) {

        int yesx = e.happy;
        int nox = 0;

        if (e.subs.isEmpty()) {
            return new ReturnType(yesx, nox);
        } else {
            for (Employee s : e.subs) {
                ReturnType r = process(s);
                yesx += r.noHeadMax;
                nox += Math.max(r.noHeadMax, +r.yesHeadMax);
            }
            return new ReturnType(yesx, nox);
        }

    }


}
