package gsh.demo.practice02_linklist;

public class GSHDoubleNode {

    public int value;
    public GSHDoubleNode pre;
    public GSHDoubleNode next;


    public GSHDoubleNode(int value){
        this.value = value;
    }

    public  boolean hasNext(){
        if(this.next==null){
            return false;
        }
        return true;
    }

}
