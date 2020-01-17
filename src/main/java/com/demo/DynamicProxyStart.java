package com.demo;

import java.lang.reflect.Proxy;

/**
 * 动态代理实现分表的处理
 *
 * @author 袁毅雄
 * @description
 * @date 2018/11/2
 */
public class DynamicProxyStart {
    public static void main(String[] args) {
        EventService eventService = EventServiceDynamicProxy.getObj(new EventServiceImpl());
        eventService.print("hello", 2);
    }
}

interface EventService {

    void print(String text, Integer groupTypeValue);
}

class EventServiceImpl implements EventService {

    @Override
    public void print(String text, Integer groupTypeValue) {
        BaseServiceHolder.get().getBaseEventService().print(text);
    }
}

interface BaseEventService {
    void print(String text);
}

abstract class BaseEventServiceImpl implements BaseEventService {
    @Override
    public void print(String text) {
        System.out.println("text:" + getClass());
    }
}

class FamilyEventServiceImpl extends BaseEventServiceImpl {
}

class CommonEventServiceImpl extends BaseEventServiceImpl {
}

class BaseServiceHolder {

    private BaseEventService baseEventService;

    public BaseEventService getBaseEventService() {
        return baseEventService;
    }

    private static ThreadLocal<BaseServiceHolder> currentBaseServiceHolder = new ThreadLocal<>();

    public BaseServiceHolder(Integer groupTypeValue) {
        if (groupTypeValue == 1) {
            baseEventService = new FamilyEventServiceImpl();
        }
        if (groupTypeValue == 2) {
            baseEventService = new CommonEventServiceImpl();
        }
    }

    public static BaseServiceHolder set(Integer groupTypeValue) {
        BaseServiceHolder baseServiceHolder = new BaseServiceHolder(groupTypeValue);
        BaseServiceHolder.currentBaseServiceHolder.set(baseServiceHolder);
        return baseServiceHolder;
    }

    public static BaseServiceHolder get() {
        return currentBaseServiceHolder.get();
    }

    public static void remove() {
        currentBaseServiceHolder.remove();
    }

}

class EventServiceDynamicProxy {
    public static EventService getObj(final EventService target) {
        return (EventService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    //约定最后一个参数为groupTypeValue，初始化BaseServiceHolder.
                    Object groupTypeValue = args[args.length - 1];
                    BaseServiceHolder.set(Integer.parseInt(String.valueOf(groupTypeValue)));
                    //具体业务
                    Object result = method.invoke(target, args);
                    //避免threadLocal内存泄露
                    BaseServiceHolder.remove();
                    return result;
                }
        );
    }
}