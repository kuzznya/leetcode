package space.kuzznya.leetcode.task210;

import java.util.*;

class Course {
    int id;
    List<Course> next = new ArrayList<>();

    public Course(int id) {
        this.id = id;
    }
}

public class CourseScheduleTwo {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Course> courses = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            courses.add(new Course(i));
        }
        for (int[] prerequisite : prerequisites) {
            Course c = courses.get(prerequisite[0]);
            Course prereq = courses.get(prerequisite[1]);
            c.next.add(prereq);
        }

        Map<Integer, Boolean> visited = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (Course course : courses) {
            boolean validGraph = topSort(course, visited, result);
            if (!validGraph) return new int[0];
        }

        if (result.size() != numCourses) return new int[0];
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean topSort(Course course, Map<Integer, Boolean> visited, List<Integer> result) {
        Boolean isCurrentCourseBeingVisited = visited.get(course.id);
        if (isCurrentCourseBeingVisited != null && isCurrentCourseBeingVisited) return false;
        if (isCurrentCourseBeingVisited != null) return true;
        visited.put(course.id, true);
        for (Course next : course.next) {
            boolean validGraph = topSort(next, visited, result);
            if (!validGraph) return false;
        }
        visited.put(course.id, false);
        result.add(course.id);
        return true;
    }

    public static void main(String[] args) {
        CourseScheduleTwo courseScheduleTwo = new CourseScheduleTwo();
        System.out.println(Arrays.toString(courseScheduleTwo.findOrder(2, new int[][]{{1,0}})));
    }
}
