/*
 *@ {#} TestCourse.java     1.0 8/28/2024
 */

package iuh.fit.khdl;

import java.util.Scanner;

/**
 * A test class for demonstrating the functionality of the Course and CourseList classes.
 *
 * @version 1.0
 * @author Nguyen Ba Duc
 * 8/28/2024
 */
public class TestCourse {

    /**
     * Initializes the CourseList with some predefined courses.
     *
     * @param courseList The CourseList object to be initialized with sample data.
     */
    private static void initData(CourseList courseList) {
        Course course1 = new Course("FIT101", "Java Programming", 3, "z");
        Course course2 = new Course("FIT102", "Web Programming", 4, "ds");
        Course course3 = new Course("FIT103", "Database Programming", 5, "DA");
        Course course4 = new Course("FIT104", "Mobile Programming", 3, "WS");
        Course course5 = new Course("FIT105", "Software Engineering", 3, "Q");
        Course course6 = new Course("FIT106", "Data Science", 3, "C");
        Course course7 = new Course("FIT107", "Machine Learning", 3, "G");
        Course course8 = new Course("FIT108", "Artificial Intelligence", 3, "CNTT");

        courseList.addCourse(course1);
        courseList.addCourse(course2);
        courseList.addCourse(course3);
        courseList.addCourse(course4);
        courseList.addCourse(course5);
        courseList.addCourse(course6);
        courseList.addCourse(course7);
        courseList.addCourse(course8);
    }

    /**
     * The main method that runs the test program.
     * It provides a menu for users to interact with the CourseList.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourseList courseList = new CourseList(10);

        initData(courseList);

        int choice;
        do {
            System.out.println("1. Add a course");
            System.out.println("2. Display all courses");
            System.out.println("3. Remove a course");
            System.out.println("4. Find ID of a course");
            System.out.println("5. Find courses by name");
            System.out.println("6. Find courses by department");
            System.out.println("7. Sort courses by name");
            System.out.println("8. Find courses with the highest number of credits");
            System.out.println("9. Find department with the maximum number of courses");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter course id: ");
                    String id = sc.nextLine();
                    System.out.print("Enter course title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter course credit: ");
                    int credit = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter course department: ");
                    String department = sc.nextLine();
                    Course course = new Course(id, title, credit, department);
                    if (courseList.addCourse(course)) {
                        System.out.println("Course added successfully!");
                    } else {
                        System.out.println("Course not added!");
                    }
                }
                case 2 -> {
                    System.out.println("Course List : ");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println(String.format("%-10s%-20s%-10s%-10s", "ID", "Title", "Department", "Credit"));
                    System.out.println("-------------------------------------------------------------");
                    for (Course c : courseList.getCourses()) {
                        if (c != null) {
                            System.out.println(c);
                        }
                    }
                    System.out.println("-------------------------------------------------------------");
                }
                case 3 -> {
                    System.out.print("Enter the name of the course to delete: ");
                    String nameCourse = sc.nextLine();
                    if (courseList.removeCourse(nameCourse)) {
                        System.out.println("Course deleted successfully!");
                    } else {
                        throw new IllegalArgumentException("Course does not exist!\n");
                    }
                }
                case 4 -> {
                    System.out.println("Enter the ID of a course: ");
                    String id = sc.nextLine();
                    Course res = courseList.searchCourseByID(id);
                    if (res != null) {
                        System.out.println(res);
                    } else {
                        throw new IllegalArgumentException("Course does not exist!\n");
                    }
                }
                case 5 -> {
                    System.out.println("Enter the name of the courses: ");
                    String nameCourses = sc.nextLine();
                    Course[] res = courseList.searchCourse(nameCourses);
                    for (Course c : res) {
                        if (c != null) {
                            System.out.println(c);
                        }
                    }
                }
                case 6 -> {
                    System.out.println("Enter the name of the department: ");
                    String nameDepartment = sc.nextLine();
                    Course[] res = courseList.searchCourseByDepartment(nameDepartment);
                    for (Course c : res) {
                        if (c != null) {
                            System.out.println(c);
                        }
                    }
                }
                case 7 -> {
                    Course[] arr = courseList.sortCourses();
                    System.out.println("Courses sorted successfully!");
                    for (Course c : arr) {
                        if (c != null) {
                            System.out.println(c);
                        }
                    }
                }
                case 8 -> {
                    Course[] arr = courseList.findMaxCreditCourses();
                    for (Course c : arr) {
                        if (c != null) {
                            System.out.println(c);
                        }
                    }
                }
                case 9 -> {
                    System.out.print("Department with the maximum number of courses: ");
                    System.out.println(courseList.findDepartmentWithCourses());
                }
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }
}
