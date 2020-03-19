import java.util.*;

public class LinkedList2 {
    public Node head;
    public Node tail;

    public LinkedList2() {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item) {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public Node find(int _value) {
        Node _resNode = this.head;
        while (_resNode != null) {
            if (_resNode.value == _value) return _resNode;
            _resNode = _resNode.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node resNode = this.head;
        while (resNode != null) {
            if (resNode.value == _value)
                nodes.add(resNode);
            resNode = resNode.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        Node resNode = this.find(_value);
        if (resNode == null) {
            return false;
        }
        if (resNode.prev == null) {
            if (resNode.next == null) {
                this.head = null;
                this.tail = null;
                return true;
            }
            this.head = resNode.next;
            this.head.prev = null;
            return true;
        }
        if (resNode.next == null) {
            this.tail = resNode.prev;
            this.tail.next = null;
            return true;
        }
        Node prev = resNode.prev;
        Node next = resNode.next;
        prev.next = next;
        next.prev = prev;
        return true;
    }

    public void removeAll(int _value) {
        while (this.remove(_value)) ;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
    }

    public int count() {
        int count = 0;
        Node node = this.head;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    public void addInHead(Node _item) {
        if (this.tail == null) {
            this.tail = _item;
            this.tail.next = null;
            this.tail.prev = null;
        } else {
            this.head.prev = _item;
            _item.next = head;
        }
        this.head = _item;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        Node node = _nodeAfter != null ? this.find(_nodeAfter.value) : null;
        if (node == null) {
            this.addInHead(_nodeToInsert);
            return;
        }
        if (node.next == null) {
            this.addInTail(_nodeToInsert);
            return;
        }
        _nodeToInsert.prev = node;
        _nodeToInsert.next = node.next;
        node.next = _nodeToInsert;
    }
}

class Node {
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value) {
        value = _value;
        next = null;
        prev = null;
    }
}