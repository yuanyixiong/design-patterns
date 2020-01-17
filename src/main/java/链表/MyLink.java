package 链表;

/**
 * @ClassName: MyLink
 * @Author： yuanyixiong
 * @Date： 2019/12/20 上午10:36
 * @Description： 单向链表
 * @Version： 1.0
 */
public class MyLink {

    Node head;

    /**
     * @Author: yuanyixiong
     * @Date: 2019/12/20 上午11:50
     * @Description: 链表-添加节点
     * @Param: [data]
     * @Version: 1.0
     * @Return: void
     **/
    public void add(int data) {
        Node newNode = new Node(data);
        if (null == head) {
            head = newNode;
            return;
        }
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }

    /**
     * @Author: yuanyixiong
     * @Date: 2019/12/20 上午11:50
     * @Description: 链表-根据索引删除指定节点
     * @Param: [index]
     * @Version: 1.0
     * @Return: boolean
     **/
    public boolean delete(int index) {
        if (index < 0 || index > length()) {
            return false;
        }

        if (index == 0) {
            head = head.next;
            return true;
        }

        int i = 1;
        Node preNode = head;
        Node curNode = preNode.next;

        while (curNode != null) {
            if (i == index) {
                preNode.next = curNode.next;
                return true;
            }
            preNode = curNode;
            curNode = curNode.next;
            i++;
        }

        return false;
    }

    /**
     * @Author: yuanyixiong
     * @Date: 2019/12/20 上午11:49
     * @Description: 链表-删除指定节点
     * @Param: [delNode]
     * @Version: 1.0
     * @Return: boolean
     **/
    public boolean delete(Node delNode) {
        if (delNode == null) {
            return false;
        }

        if (delNode.equals(head)) {
            head = head.next;
            return true;
        }

        Node preNode = head;
        Node curNode = preNode.next;
        while (curNode != null) {
            if (curNode.equals(delNode)) {
                preNode.next = curNode.next;
                return true;
            }
            preNode = curNode;
            curNode = curNode.next;
        }

        return false;
    }

    /**
     * @Author: yuanyixiong
     * @Date: 2019/12/20 下午12:05
     * @Description: 链表-去重
     * @Param: [head]
     * @Version: 1.0
     * @Return: void
     **/
    public void delDuplicate(Node head) {

    }

    /**
     * @Author: yuanyixiong
     * @Date: 2019/12/20 上午11:50
     * @Description: 链表-返回长度
     * @Param: []
     * @Version: 1.0
     * @Return: int
     **/
    public int length() {
        int length = 0;
        Node tmp = head;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        return length;
    }

    /**
     * @Author: yuanyixiong
     * @Date: 2019/12/20 上午11:51
     * @Description: 链表-输出所有节点(循环)
     * @Param: []
     * @Version: 1.0
     * @Return: void
     **/
    public void printForeach() {
        Node tmp = head;
        System.out.println();
        while (tmp != null) {
            System.out.print(tmp.data + "\t");
            tmp = tmp.next;
        }
        System.out.println();
    }

    /**
     * @Author: yuanyixiong
     * @Date: 2019/12/20 上午11:57
     * @Description: 链表-输出所有节点(递归)
     * @Param: []
     * @Version: 1.0
     * @Return: void
     **/
    public void printRecursive() {
        System.out.println();
        printRecursive(head);
        System.out.println();
    }

    /**
     * @Author: yuanyixiong
     * @Date: 2019/12/20 上午11:54
     * @Description: 链表-输出所有节点(递归)
     * @Param: [pListHead]
     * @Version: 1.0
     * @Return: void
     **/
    public void printRecursive(Node node) {
        if (null != node.next) {
            printRecursive(node.next);
        }
        System.out.print(node.data + "\t");
    }

    /**
     * @Author: yuanyixiong
     * @Date: 2019/12/20 上午11:51
     * @Description: 链表-排序
     * @Param: [isAsc]
     * @Version: 1.0
     * @Return: 链表.Node
     **/
    public Node orderList(boolean isAsc) {
        Node curNode = head;
        Node nextNode;
        int tmp;
        while (null != curNode.next) {
            nextNode = curNode.next;
            while (null != nextNode) {
                if (isAsc ? curNode.data > nextNode.data : curNode.data < nextNode.data) {
                    tmp = curNode.data;
                    curNode.data = nextNode.data;
                    nextNode.data = tmp;
                }
                nextNode = nextNode.next;
            }
            curNode = curNode.next;
        }
        return head;
    }

    /**
     * @Author: yuanyixiong
     * @Date: 2019/12/20 上午11:53
     * @Description: 链表-判断链表是否有环，单向链表有环时，尾节点相同
     * @Param: [head]
     * @Version: 1.0
     * @Return: boolean
     **/
    public boolean isLoop(Node head) {
        return false;
    }

    /**
     * @Author: yuanyixiong
     * @Date: 2019/12/20 上午11:53
     * @Description: 链表-找出链表环的入口
     * @Param: [head]
     * @Version: 1.0
     * @Return: 链表.Node
     **/
    public Node findLoopPort(Node head) {
        return null;
    }

}

/**
 * @ClassName: Node
 * @Author: yuanyixiong
 * @Date: 2019/12/20 上午11:51
 * @Description: 链表的每个节点
 * @Version: 1.0
 */
class Node {

    int data;

    Node next;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result += 31 * result + Integer.valueOf(data).hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (null != obj && obj instanceof Node) {
            Node tmp = (Node) obj;
            return tmp.hashCode() == this.hashCode();
        }
        return false;
    }
}


