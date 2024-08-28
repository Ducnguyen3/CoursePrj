/*
 *@ {#} CourseList.java     1.0 8/28/2024
 */

package iuh.fit.khdl;

import java.util.*;

/**
 * This class represents a list of courses and provides methods to manage them.
 *
 * @version 1.0
 * @author Nguyen Ba Duc
 * 8/28/2024
 */
public class CourseList {
    private Course[] courses; // Array to store the list of courses
    private int count = 0;    // Number of courses currently in the list

    /**
     * Constructs a CourseList with a specified size.
     *
     * @param n The size of the course list.
     * @throws IllegalArgumentException if the size is less than or equal to 0.
     */
    public CourseList(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("Length of the array must be greater than 0");
        courses = new Course[n]; // Initialize the course array
    }

    /**
     * Returns the list of courses.
     *
     * @return The array of courses.
     */
    public Course[] getCourses() {
        return courses;
    }

    /**
     * Adds a course to the list.
     *
     * @param course The course to be added.
     * @return {@code true} if the course is added successfully, {@code false} otherwise.
     * @throws IllegalArgumentException if the course is null, the course already exists, or the array is full.
     */
    public boolean addCourse(Course course) {
        if (course == null)
            return false;
        if (Exists(course))
            return false;
        if (count == courses.length) // Check if the list is full
            return false;
        courses[count++] = course; // Add the course and increment the count
        return true;
    }

    /**
     * Checks if the course exists in the list, based on the course ID.
     *
     * @param course The course to check for existence.
     * @return {@code true} if the course exists, {@code false} otherwise.
     */
    private boolean Exists(Course course) {
        for (int i = 0; i < count; i++) {
            if (courses[i] != null && courses[i].getId().equalsIgnoreCase(course.getId()))
                return true; // Course exists if the IDs match
        }
        return false;
    }

    /**
     * Finds the department that manages the most courses.
     *
     * @return The name of the department with the most courses.
     */
    public String findDepartmentWithCourses() {
        int maxTitle = 0;
        String res = "";
        HashMap<String, Integer> mp = new HashMap<>();

        // Count the number of courses in each department
        for (int i = 0; i < count; i++) {
            mp.put(courses[i].getDepartment(), mp.getOrDefault(courses[i].getDepartment(), 0) + 1);
        }

        // Find the department with the maximum number of courses
        for (Map.Entry<String, Integer> entry : mp.entrySet()) {
            if (entry.getValue() > maxTitle) {
                maxTitle = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }

    /**
     * Finds courses with the highest number of credits.
     *
     * @return An array of courses with the highest number of credits.
     */
    public Course[] findMaxCreditCourses() {
        Course[] res = new Course[count];
        int j = 0, maxCredit = 0;

        // Find the maximum credit value
        for (int i = 0; i < count; i++) {
            maxCredit = Math.max(maxCredit, courses[i].getCredit());
        }

        // Collect courses with the maximum credit value
        for (int i = 0; i < count; i++) {
            if (courses[i].getCredit() == maxCredit) {
                res[j++] = courses[i];
            }
        }
        return Arrays.copyOf(res, j); // Return the array with only the matched courses
    }

    /**
     * Removes a course from the list by course name.
     *
     * @param courseName The name of the course to be removed.
     * @return {@code true} if the course was successfully removed, {@code false} otherwise.
     */
    public boolean removeCourse(String courseName) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getTitle().equalsIgnoreCase(courseName)) {
                // Shift the remaining courses left to fill the gap
                for (int j = i; j < count - 1; j++) {
                    courses[j] = courses[j + 1];
                }
                courses[--count] = null; // Decrement count and clear the last element
                return true;
            }
        }
        return false;
    }

    /**
     * Searches for courses by course name.
     *
     * @param courseName The name of the course to search for.
     * @return An array of courses that match the given course name.
     */
    public Course[] searchCourse(String courseName) {
        Course[] res = new Course[count];
        int j = 0;
        for (int i = 0; i < count; i++) {
            if (courses[i].getTitle().equalsIgnoreCase(courseName)) {
                res[j++] = courses[i];
            }
        }
        return Arrays.copyOf(res, j); // Return the array with only the matched courses
    }

    /**
     * Searches for courses managed by a specific department.
     *
     * @param nameDepartment The name of the department to search for.
     * @return An array of courses managed by the specified department.
     */
    public Course[] searchCourseByDepartment(String nameDepartment) {
        Course[] res = new Course[count];
        int j = 0;
        for (int i = 0; i < count; i++) {
            if (courses[i].getDepartment().equalsIgnoreCase(nameDepartment)) {
                res[j++] = courses[i];
            }
        }
        return Arrays.copyOf(res, j); // Return the array with only the matched courses
    }

    /**
     * Searches for a course by course ID.
     *
     * @param courseID The ID of the course to search for.
     * @return The course with the given ID, or {@code null} if not found.
     */
    public Course searchCourseByID(String courseID) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equalsIgnoreCase(courseID)) {
                return courses[i]; // Return the course if the ID matches
            }
        }
        return null; // Return null if no course matches the ID
    }

    /**
     * Sorts the list of courses by their title.
     *
     * @return An array of courses sorted by title in ascending order.
     */
    public Course[] sortCourses() {
        Arrays.sort(courses, 0, count, new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return o1.getTitle().compareTo(o2.getTitle()); // Compare titles
            }
        });
        return courses;
    }
}
