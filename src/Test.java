import java.lang.reflect.Array;
import java.util.ArrayList;

public class Test {
    static Node n1 = new Node(1);
    static Node n2 = new Node(2);
    static Node n3 = new Node(3);
    static Node n4 = new Node(1);
    static Node n5 = new Node(5);
    static Node n6 = new Node(6);
    static Node nInsert = new Node(66);

    static Node[] testData = {n1, n2, n3, n4, n5, n6};

    static LinkedList2 testList = new LinkedList2();

    static void testAddInTail(LinkedList2 _testList, Node[] _nodes, int _quantityNodes) {
        System.out.println("=== Test AddInTail ===");

        for (int i = 0; i < _quantityNodes; i++) {
            _testList.addInTail(_nodes[i]);
        }

        Node testNode = _testList.head;
        int count = 0;
        while (testNode != null) {
            count++;
            testNode = testNode.next;
        }

        if (count == _quantityNodes)
            System.out.println("OK");
        else
            System.out.println("FAIL");
    }
    static void testAddInHead(LinkedList2 _testList, Node[] _nodes, int _quantityNodes) {
        System.out.println("=== Test Add In Head ===");

        for (int i = 0; i < _quantityNodes; i++) {
            _testList.addInHead(_nodes[i]);
        }

        Node testNode = _testList.head;
        int count = 0;
        while (testNode != null) {
            count++;
            testNode = testNode.next;
        }

        if (count == _quantityNodes)
            System.out.println("OK");
        else
            System.out.println("FAIL");
    }

    static void testFind(int _findV, LinkedList2 _testList) {
        System.out.println("=== Test Find ===");
        if (_testList.find(_findV) != null)
            System.out.println("OK");
        else
            System.out.println("FAIL");
    }

    static void testFindAll(int _findV, LinkedList2 _testList, int _countFindV) {
        System.out.println("=== Test Find All ===");
        ArrayList<Node> resList = _testList.findAll(_findV);
        if (resList.size() == _countFindV)
            System.out.println("OK");
        else
            System.out.println("FAIL");
    }

    static void testRemove(int _remV, LinkedList2 _testList) {
        System.out.println("=== Test Remove ===");

        if (_testList.remove(_remV))
            System.out.println("OK");
        else
            System.out.println("FAIL");
    }

    static void testRemoveAll(int _remV, LinkedList2 _testList) {
        System.out.println("=== Test Remove All ===");
        _testList.removeAll(_remV);
        if (_testList.find(_remV) == null)
            System.out.println("OK");
        else
            System.out.println("FAIL");
    }

    static void testInsertAfter(Node _nodeAfter, Node _nodeToInsert, LinkedList2 _testDLL) {
        System.out.println("=== Test Insert After ===");

        _testDLL.insertAfter(_nodeAfter, _nodeToInsert);

    }

    public static void main(String[] args) {
        testAddInTail(testList, testData, 4);
        //testAddInHead(testList, testData, 2);

        System.out.println("==================");
        Node node = testList.head;
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
        System.out.println("==================");

        //testFind(3, testList);
        //testFindAll(1, testList, 2);
        //testRemove(2, testList);
        testRemoveAll(1, testList);
        testInsertAfter(n3, nInsert, testList);


        System.out.println("==================");

        node = testList.head;
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }

        System.out.println("==================");

        System.out.println(testList.head);
        System.out.println(testList.head.prev);
        System.out.println(testList.head.value);
        System.out.println(testList.head.next);
        System.out.println(testList.tail.prev);
        System.out.println(testList.tail.value);
        System.out.println(testList.tail.next);
    }
}
