package com.bluesgao.octopus.download;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorArrayListTest {
    private static final int COUNT = 1000000;
    private static List<Person> persons = new ArrayList<Person>();

    public static void init() {
        //初始化，生成对象个数
        Person person = null;
        for (int i = 0; i < COUNT; i++) {
            person = new Person(i, "张三" + i);
            persons.add(person);
        }
    }

    //Iterator遍历
    public static long testIterator() {
        //开始编译执行时间
        long start = System.nanoTime();
        Person person = null;
        for (Iterator<Person> iterator = persons.iterator(); iterator.hasNext(); ) {
            person = (Person) iterator.next();

        }
        //执行完后的时间
        long end = System.nanoTime();
        return (end - start) / (1000);
    }

    //foEach循环遍历
    public static long testForEach() {
        //开始编译执行时间
        long start = System.nanoTime();
        Person person = null;
        for (Person p : persons) {
            person = p;
        }
        //执行完后的时间
        long end = System.nanoTime();
        return (end - start) / (1000);
    }

    //for循环遍历
    public static long testFor() {
        //开始编译执行时间
        long start = System.nanoTime();
        Person person = null;
        for (int i = 0; i < persons.size(); i++) {
            person = persons.get(i);
        }
        //执行完后的时间
        long end = System.nanoTime();
        return (end - start) / (1000);
    }

    public static void testRegxp() {
    }

    public static void main(String[] args) {
        init();
        System.out.println("Iterator迭代遍历的消耗时间为:" + testIterator());
        System.out.println("ForEach遍历的消耗时间为:" + testForEach());
        System.out.println("For循环遍历的消耗时间为:" + testFor());

    }
}

class Person {
    int id;
    String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
