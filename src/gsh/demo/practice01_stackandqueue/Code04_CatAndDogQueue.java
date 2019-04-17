package gsh.demo.practice01_stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 实现一种猫狗队列
 * 实现  add  pollall  polldog  pollcat  isEmpty isDogEmpty  isCateEmpty
 */

public class Code04_CatAndDogQueue {

    public static abstract class animal {
    }

    public static class cat extends animal {
    }

    public static class dog extends animal {
    }

    public static class Myqueue {
        private Queue<cat> catqueue;
        private Queue<dog> dogqueue;

        public Myqueue() {
            catqueue = new LinkedList<>();
            dogqueue = new LinkedList<>();
        }


        public void add(animal animal) {
            if (animal instanceof cat) {
                catqueue.add((cat) animal);
            }
            if (animal instanceof dog) {
                dogqueue.add((dog) animal);
            }
        }

        public cat pollcat() {
            if (catqueue.isEmpty()) {
                throw new RuntimeException("cat is no");
            }

            return catqueue.poll();
        }


        public dog polldog() {
            if (dogqueue.isEmpty()) {
                throw new RuntimeException("cat is no");
            }

            return dogqueue.poll();
        }


        public boolean isEmpty(){
            return catqueue.isEmpty() && dogqueue.isEmpty();
        }

    }








}
