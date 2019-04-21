package gsh.demo.practice02_linklist;

public class GSHSingleNode {

    public int value;
    public GSHSingleNode next;

    public GSHSingleNode(int value) {
        this.value = value;
    }

    public boolean hasNext() {
        if (this.next == null) {
            return false;
        }
        return true;
    }

    public GSHSingleNode getNext() {
        if (this.hasNext()) {
            return this.next;
        }
        return null;
    }


}
