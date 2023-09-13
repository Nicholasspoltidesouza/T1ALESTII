public class DoubleLinkedList {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        char data;
        Node prev;
        Node next;

        Node(char data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public DoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(char data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public boolean remove(char data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void mutacoes() {
        Node current = head;

        while (current != null && current.next != null) {
            char currentChar = current.data;
            char nextChar = current.next.data;

            boolean mutacao = false;

            if ((currentChar == 'A' && nextChar == 'D') || (currentChar == 'D' && nextChar == 'A')) {
                add('N');
                mutacao = true;
            } else if ((currentChar == 'D' && nextChar == 'N') || (currentChar == 'N' && nextChar == 'D')) {
                add('A');
                mutacao = true;
            } else if ((currentChar == 'A' && nextChar == 'N') || (currentChar == 'N' && nextChar == 'A')) {
                add('D');
                mutacao = true;
            }

            if (mutacao) {
                remove(currentChar);
                remove(nextChar);
                current = head;
            } else {
                current = current.next;
            }
        }
    }

    public String toString() {
        String result = "";
        Node current = head;
        while (current != null) {
            result += current.data;
            current = current.next;
        }
        return result;
    }
}
