package all.javalearn.base.test;/*
    created by shudb at 2020/3/9 13:46
*/


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class School {
    int schoolid;
    String schoolname;

    public School() {
    }

    public School(int schoolid, String schoolname) {
        this.schoolid = schoolid;
        this.schoolname = schoolname;
    }

    public int getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(int schoolid) {
        this.schoolid = schoolid;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public static void main(String[] args) {
        List<School> schools = Arrays.asList(
                new School(1, "学校1"),
                new School(1, "学校11"),
                new School(2, "学校2"),
                new School(3, "学校3"));

        Map<Integer, School> collect = schools.stream().collect(Collectors.toMap(p -> p.getSchoolid(), p -> p, (p1,p2) -> p2));
        System.out.println(collect);
    }
}
