package libraries.list;

public class SinglyLinkedListNode {
    public int val;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode() {
    }

    public SinglyLinkedListNode(int val) {
        this.val = val;
    }

    public SinglyLinkedListNode(int val, SinglyLinkedListNode next) {
        this.val = val;
        this.next = next;
    }

}
