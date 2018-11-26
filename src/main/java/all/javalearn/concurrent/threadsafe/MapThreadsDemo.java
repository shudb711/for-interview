package all.javalearn.concurrent.threadsafe;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Function:
 * @Author:shudb
 * @Date:2018/11/20 10:40
 **/
public class MapThreadsDemo
{
    private static Map<Object, Object> map;
    public static void main(String[] args) {
        map = new HashMap<>();
        //
        Key key1= new Key("1", "2", "3");
        System.out.println(key1.hashCode());
        map.put(key1, 11111);

        key1.setField1("1s");
        System.out.println(key1.hashCode());
        map.put(key1, 33333);

        Key key2= new Key("1", "2", "3");
        System.out.println(key2.hashCode());
        map.put(key2, 22222);

        System.out.println(map.size());
    }


    static class Key
    {
        String field1;

        String field2;

        String field3;

        public Key() {
        }

        public Key(String field1, String field2, String field3) {
            this.field1 = field1;
            this.field2 = field2;
            this.field3 = field3;
        }

        public String getField1() {
            return field1;
        }

        public void setField1(String field1) {
            this.field1 = field1;
        }

        public String getField2() {
            return field2;
        }

        public void setField2(String field2) {
            this.field2 = field2;
        }

        public String getField3() {
            return field3;
        }

        public void setField3(String field3) {
            this.field3 = field3;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return Objects.equals(field1, key.field1) &&
                    Objects.equals(field2, key.field2) &&
                    Objects.equals(field3, key.field3);
        }

        @Override
        public int hashCode() {

            return Objects.hash(field1, field2, field3);
        }
    }
}
