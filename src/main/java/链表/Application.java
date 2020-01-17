package 链表;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @ClassName: Application
 * @Author： yuanyixiong
 * @Date： 2019/12/20 上午10:53
 * @Description： TODO
 * @Version： 1.0
 */
public class Application {

    public static void main(String[] args) {

        MyLink link = new MyLink();

        System.out.println("添加节点==================");
        link.add(12);
        link.add(14);
        link.add(10);
        link.add(9);
        link.add(50);
        link.printForeach();
        System.out.println("添加节点==================");


        System.out.println("删除(指定索引)==================");
        link.printForeach();
        System.out.println(link.length());
        System.out.println(link.delete(2));
        System.out.println(link.length());
        link.printForeach();
        System.out.println("删除(指定索引)==================");


        System.out.println("删除(指定节点)==================");
        link.printForeach();
        System.out.println(link.length());
        System.out.println(link.delete(new Node(14)));
        System.out.println(link.length());
        link.printForeach();
        System.out.println("删除(指定节点)==================");


        System.out.println("递归、排序==================");
        link.printRecursive();
        link.orderList(true);
        link.printRecursive();
        link.orderList(false);
        link.printRecursive();
        System.out.println("递归、排序==================");


        ArrayList arrayList = new ArrayList(10);
        Vector vector = new Vector(10);
        LinkedList linkedList = new LinkedList();

        HashSet hashSet = new HashSet();
        TreeSet treeSet = new TreeSet();


        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.get(null);
        concurrentHashMap.put(null, null);


        Hashtable hashtable = new Hashtable();
        hashtable.contains(null);
        hashtable.containsValue(null);
        hashtable.containsKey(null);
        hashtable.put(null, null);

        HashMap hashMap = new HashMap();
        hashMap.containsKey(null);
        hashMap.containsValue(null);
        hashMap.put(null, null);
        hashMap.get(null);


        Executor executor;
        ExecutorService executorService;
        ScheduledExecutorService scheduledExecutorService;
        ThreadPoolExecutor threadPoolExecutor;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;


        ExecutorService s = Executors.newSingleThreadExecutor();
        Executors.newFixedThreadPool(10);
        Executors.newCachedThreadPool();
        Executors.newScheduledThreadPool(100);


        s.submit(null, null);
        s.execute(null);


        s.shutdown();

        s.shutdownNow();

    }
}
