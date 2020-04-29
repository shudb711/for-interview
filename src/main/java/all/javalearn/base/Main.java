package all.javalearn.base;/*
    created by shudb at 2020/3/9 13:47
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<School> schools = new ArrayList<>();
        List<Lesson> lessons = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < lessons.size(); i++) {
            Lesson lesson = lessons.get(i);
            if (map.get(lesson.getSchoolid()) != null) {
                map.put(lesson.getSchoolid(), map.get(lesson.getSchoolid()) + lesson.getStudentCount());
            }
        }

        Map<Integer, String> names = new HashMap<>();
        for (int i = 0; i < schools.size(); i++) {
            School school = schools.get(i);
            names.put(school.getSchoolid(), school.getSchoolname());
        }

        List<String> schoolIds = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value > 1000) {
                schoolIds.add(names.get(entry.getKey()));
            }
        }
    }
}
