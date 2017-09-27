package laosiji.tech.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Whyte on 2017/9/8.
 */
public class SortTest {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        Person person = new Person();
        person.setAge(1);
        person.setName("a");
        person.setId("1111");
        Person person1 = new Person();
        person1.setAge(1);
        person1.setName("b");
        person1.setId("2222");
        Person person2 = new Person();
        person2.setAge(1);
        person2.setName("a");
        person2.setId("3333");
        Person person3 = new Person();
        person3.setAge(1);
        person3.setName("a");
        person3.setId("4444");
        Person person4 = new Person();
        person4.setAge(1);
        person4.setName("a");
        person4.setId("5555");
        list.add(person);
        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        Collections.sort(list);
        for (Person p : list) {
            System.out.println(p.getId());
        }
    }

    static class Person implements Comparable<Person> {
        private String id;
        private String name;
        private int age;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public int compareTo(Person o) {
            return o.getId().compareTo(this.id);
        }
    }
}
