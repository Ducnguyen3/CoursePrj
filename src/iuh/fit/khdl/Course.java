/*
 *@ {#} Course.java     1.0 8/28/2024
 */

package iuh.fit.khdl;

/**
 * Represents a course with an ID, title, credit, and department.
 *
 * @version 1.0
 * @author Nguyen Ba Duc
 * 8/28/2024
 */
public class Course {
    private String id;          // The ID of the course
    private String title;       // The title of the course
    private int credit;         // The credit value of the course
    private String department;  // The department that offers the course

    /**
     * Default constructor that creates an empty course object.
     */
    public Course() {
    }

    /**
     * Constructor with parameters to initialize the course object.
     *
     * @param id The ID of the course.
     * @param title The title of the course.
     * @param credit The credit value of the course.
     * @param department The department that offers the course.
     */
    public Course(String id, String title, int credit, String department) {
        this.id = id;
        this.title = title;
        this.credit = credit;
        this.department = department;
    }

    /**
     * Returns the ID of the course.
     *
     * @return The course ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the ID of the course.
     *
     * @param id The ID of the course.
     * @throws IllegalArgumentException if the ID is null, has less than 3 characters, or contains characters other than letters or digits.
     */
    public void setId(String id) {
        if (id == null || id.length() < 3)
            throw new IllegalArgumentException("ID must have at least 3 characters");
        for (int i = 0; i < id.length(); i++) {
            if (!Character.isLetterOrDigit(id.charAt(i)))
                throw new IllegalArgumentException("ID must contain only letters or digits");
        }
        this.id = id;
    }

    /**
     * Returns the title of the course.
     *
     * @return The course title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the course.
     *
     * @param title The title of the course.
     * @throws IllegalArgumentException if the title is null or empty.
     */
    public void setTitle(String title) {
        if (title == null || title.isEmpty())
            throw new IllegalArgumentException("Title must not be empty");
        this.title = title;
    }

    /**
     * Returns the credit value of the course.
     *
     * @return The course credit.
     */
    public int getCredit() {
        return credit;
    }

    /**
     * Sets the credit value of the course.
     *
     * @param credit The credit value of the course.
     * @throws IllegalArgumentException if the credit is less than 0.
     */
    public void setCredit(int credit) {
        if (credit < 0)
            throw new IllegalArgumentException("Credit must be greater than 0");
        this.credit = credit;
    }

    /**
     * Returns the department offering the course.
     *
     * @return The department name.
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the department offering the course.
     *
     * @param department The department name.
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Returns a string representation of the course.
     *
     * @return A formatted string representing the course.
     */
    @Override
    public String toString() {
        return String.format("%-10s%-30s%2d  %-10s", id, title, credit, department);
    }
}
