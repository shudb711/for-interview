package all.javalearn.jdk8;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Function:
 * @Author:shudb
 * @Date:2018/10/30 17:56
 **/
public class HashMapStudy
{
    public static void main(String[] args) {
        Key key = new Key("11","12");
        System.out.println("11,12的hashcode=" + key.hashCode());
        Map<Object, String> map = new HashMap<>();
        map.put(key, "2222");

        key.setValue1("13");
        System.out.println("11,12的hashcode=" + key.hashCode());
        String s = map.get(key);
        System.out.println(s);//为null  map的key应该不可变的，比如String

    }

    static class Key
    {
        private String value1;
        private String value2;

        public Key(String value1, String value2) {
            this.value1 = value1;
            this.value2 = value2;
        }

        public String getValue1() {
            return value1;
        }

        public void setValue1(String value1) {
            this.value1 = value1;
        }

        public String getValue2() {
            return value2;
        }

        public void setValue2(String value2) {
            this.value2 = value2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return Objects.equals(value1, key.value1) &&
                    Objects.equals(value2, key.value2);
        }

        @Override
        public int hashCode() {

            return Objects.hash(value1, value2);


        }
    }
}
