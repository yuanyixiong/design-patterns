package com.behavior;

import java.util.ArrayList;
import java.util.List;

/**
 * 策略模式
 *
 * @ClassName: Strategy
 * @Author： yuanyixiong
 * @Date： 2019/12/10 上午10:34
 * @Description： TODO
 * @Version： 1.0
 */
public class StrategyPattern {

    public static void main(String[] args) {

        Context context = new Context();
        Strategy strategy = new QuickSortStrategy();
        context.setStrategy(strategy);
        context.sort();

        strategy = new BubbleSortStrategy();
        context.setStrategy(strategy);
        context.sort();
    }

}

/**
 * 策略的决策-通过 setStrategy 控制策略
 *
 * @ClassName: Context
 * @Author: yuanyixiong
 * @Date: 2019/12/10 上午10:44
 * @Description: TODO
 * @Version: 1.0
 */
class Context {

    private List<Integer> list = new ArrayList<>();

    private Strategy strategy;

    public void sort() {
        strategy.Sort(list);
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}

/**
 * 策略
 *
 * @ClassName: Strategy
 * @Author: yuanyixiong
 * @Date: 2019/12/10 上午10:44
 * @Description: TODO
 * @Version: 1.0
 */
interface Strategy {

    void Sort(List<Integer> list);

}

/**
 * 策略的具体实现
 *
 * @ClassName: QuickSortStrategy
 * @Author: yuanyixiong
 * @Date: 2019/12/10 上午10:44
 * @Description: TODO
 * @Version: 1.0
 */
class QuickSortStrategy implements Strategy {
    @Override
    public void Sort(List<Integer> list) {
        System.out.println("快速排序");
    }
}

/**
 * 策略的具体实现
 *
 * @ClassName: BubbleSortStrategy
 * @Author: yuanyixiong
 * @Date: 2019/12/10 上午10:44
 * @Description: TODO
 * @Version: 1.0
 */
class BubbleSortStrategy implements Strategy {
    @Override
    public void Sort(List<Integer> list) {
        System.out.println("冒泡排序");
    }
}