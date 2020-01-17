package com.builder;

/**
 * 原型模式
 *
 * @ClassName: PrototypePattern
 * @Author： yuanyixiong
 * @Date： 2019/11/20 上午11:04
 * @Description： TODO
 * @Version： 1.0
 */
public class PrototypePattern {

    public static void main(String[] args) {


        Prototype prototype = new ConcreatePrototype1();
        prototype.setId(1L);
        System.out.println(prototype.prototypeClone());


    }
}

abstract class Prototype {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public abstract Prototype prototypeClone();
}

class ConcreatePrototype1 extends Prototype {
    @Override
    public Prototype prototypeClone() {
        try {
            return (Prototype) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class ConcreatePrototype2 extends Prototype {
    @Override
    public Prototype prototypeClone() {
        try {
            return (Prototype) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}