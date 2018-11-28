package all.javalearn.jdk8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Function:
 * @Author:shudb
 * @Date:2018/11/27 17:53
 **/
public class LambdaTest
{
    public static void main(String[] args) {
        Person person1 = new Person("小明",19);
        Person person2 = new Person("李雷",10);
        Person person3 = new Person("韩梅梅",12);
        Person person4 = new Person("Amy",15);
        Person person5 = new Person("Jack",16);

        List<Person> people = Arrays.asList(person1, person2, person3, person4, person5);
        Person person = people.stream().max(new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return (o1.getAge() - o2.getAge());
            }
        }).get();

        System.out.println("年龄最大的人是:" + person.getName() + "===年龄是:" + person.getAge());

//        List<Person> collect = people.stream().sorted(new Comparator<Person>() {
//            public int compare(Person o1, Person o2) {
//                return (o1.getAge() - o2.getAge());
//            }
//        }).collect(Collectors.toList());
//        for (int i = 0; i < collect.size(); i++) {
//            System.out.println("按年龄排序:" + collect.get(i).getName() + "===年龄是:" + collect.get(i).getAge());
//        }

        people.sort(new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return (o1.getAge() - o2.getAge());
            }
        });
        for (int i = 0; i < people.size(); i++) {
            System.out.println("按年龄排序:" + people.get(i).getName() + "===年龄是:" + people.get(i).getAge());
        }
    }

    static class Person
    {
        private String name;

        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
