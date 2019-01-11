package com.example.demo.java8;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * @author hongjin.zhu
 * @description
 * @date 2019年01月11日 14:49
 * @modified By
 */
public class LambdaExpressionTest {

    @Test
    public void testLambdaBase() throws InterruptedException {
        //不带参的lambda
        new Thread(() -> System.out.println(" 直接new一个新的Thread ")).start();
        //带参的lambda
        List<String> list = Lists.newArrayList("I", "love", "you", "too");
        Collections.sort(list, (o1, o2) -> {
            if (o1 == null) {
                return -1;
            }
            if (o2 == null) {
                return 1;
            }
            return o1.length() - o2.length();
        });
        System.out.println(" === " + list);
        //lambda函数的this指向哪里,都是指向外部的引用
        new Thread(() -> System.out.println(this)).start();
        new Thread(() -> System.out.println(toString())).start();
    }

    public String toString() {
        return "Hello Hoolee";
    }

    @Test
    public void testCollection() {
        // 使用forEach()结合Lambda表达式迭代
        ArrayList<String> list = Lists.newArrayList("I", "love", "you", "too");
        list.stream().filter(s -> s.length() >= 3).forEach(System.out::println);
        //Stream接口的部分常见方法
        // 中间操作	concat() distinct() filter() flatMap() limit() map() peek()
        //          skip() sorted() parallel() sequential() unordered()
        // 结束操作	allMatch() anyMatch() collect() count() findAny() findFirst()
        //          forEach() forEachOrdered() max() min() noneMatch() reduce() toArray()
        Stream<String> stream = Stream.of("I", "love", "you", "too", "too");
        stream.distinct()
                .forEach(System.out::println);

        Stream.of("I", "love", "you", "too", "too").map(String::toUpperCase).forEach(System.out::println);

        Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4, 5)).flatMap(Collection::stream)
                .forEach(System.out::println);

        Optional<String> optional = Stream.of("I", "love", "you", "too", "too").reduce(((s1, s2) -> s1.length() >= s2.length() ? s1 : s2));
        System.out.println(" === " + optional.get());
    }


}
