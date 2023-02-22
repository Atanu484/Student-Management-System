package com.example.Student.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StudentTest {
    /**
     * Method under test: {@link Student#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new Student(123L, "Jane", "Doe", "42")).canEqual("Other"));
    }

    /**
     * Method under test: {@link Student#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        Student Student = new Student(123L, "Jane", "Doe", "42");
        assertTrue(Student.canEqual(new Student(123L, "Jane", "Doe", "42")));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Student#Student()}
     *   <li>{@link Student#setEmailId(String)}
     *   <li>{@link Student#setFirstName(String)}
     *   <li>{@link Student#setId(long)}
     *   <li>{@link Student#setLastName(String)}
     *   <li>{@link Student#toString()}
     *   <li>{@link Student#getEmailId()}
     *   <li>{@link Student#getFirstName()}
     *   <li>{@link Student#getId()}
     *   <li>{@link Student#getLastName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Student actualStudent = new Student();
        actualStudent.setEmailId("42");
        actualStudent.setFirstName("Jane");
        actualStudent.setId(123L);
        actualStudent.setLastName("Doe");
        String actualToStringResult = actualStudent.toString();
        assertEquals("42", actualStudent.getEmailId());
        assertEquals("Jane", actualStudent.getFirstName());
        assertEquals(123L, actualStudent.getId());
        assertEquals("Doe", actualStudent.getLastName());
        assertEquals("Student(id=123, firstName=Jane, lastName=Doe, emailId=42)", actualToStringResult);
    }

    /**
     * Method under test: {@link Student#Student(long, String, String, String)}
     */
    @Test
    void testConstructor2() {
        Student actualStudent = new Student(123L, "Jane", "Doe", "42");

        assertEquals("42", actualStudent.getEmailId());
        assertEquals("Doe", actualStudent.getLastName());
        assertEquals(123L, actualStudent.getId());
        assertEquals("Jane", actualStudent.getFirstName());
    }

    /**
     * Method under test: {@link Student#equals(Object)}
     */
    @Test
    void testEquals() {
        assertNotEquals(new Student(123L, "Jane", "Doe", "42"), null);
        assertNotEquals(new Student(123L, "Jane", "Doe", "42"), "Different type to Student");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Student#equals(Object)}
     *   <li>{@link Student#hashCode()}
     * </ul>
     */
    @Test
    void testEquals2() {
        Student Student = new Student(123L, "Jane", "Doe", "42");
        assertEquals(Student, Student);
        int expectedHashCodeResult = Student.hashCode();
        assertEquals(expectedHashCodeResult, Student.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Student#equals(Object)}
     *   <li>{@link Student#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        Student Student = new Student(123L, "Jane", "Doe", "42");
        Student Student1 = new Student(123L, "Jane", "Doe", "42");

        assertEquals(Student, Student1);
        int expectedHashCodeResult = Student.hashCode();
        assertEquals(expectedHashCodeResult, Student1.hashCode());
    }

    /**
     * Method under test: {@link Student#equals(Object)}
     */
    @Test
    void testEquals4() {
        Student Student = new Student(1L, "Jane", "Doe", "42");
        assertNotEquals(Student, new Student(123L, "Jane", "Doe", "42"));
    }

    /**
     * Method under test: {@link Student#equals(Object)}
     */
    @Test
    void testEquals5() {
        Student Student = new Student(123L, "Doe", "Doe", "42");
        assertNotEquals(Student, new Student(123L, "Jane", "Doe", "42"));
    }

    /**
     * Method under test: {@link Student#equals(Object)}
     */
    @Test
    void testEquals6() {
        Student Student = new Student(123L, null, "Doe", "42");
        assertNotEquals(Student, new Student(123L, "Jane", "Doe", "42"));
    }

    /**
     * Method under test: {@link Student#equals(Object)}
     */
    @Test
    void testEquals7() {
        Student Student = new Student(123L, "Jane", "Jane", "42");
        assertNotEquals(Student, new Student(123L, "Jane", "Doe", "42"));
    }

    /**
     * Method under test: {@link Student#equals(Object)}
     */
    @Test
    void testEquals8() {
        Student Student = new Student(123L, "Jane", null, "42");
        assertNotEquals(Student, new Student(123L, "Jane", "Doe", "42"));
    }

    /**
     * Method under test: {@link Student#equals(Object)}
     */
    @Test
    void testEquals9() {
        Student Student = new Student(123L, "Jane", "Doe", "jane.doe@example.org");
        assertNotEquals(Student, new Student(123L, "Jane", "Doe", "42"));
    }

    /**
     * Method under test: {@link Student#equals(Object)}
     */
    @Test
    void testEquals10() {
        Student Student = new Student(123L, "Jane", "Doe", null);
        assertNotEquals(Student, new Student(123L, "Jane", "Doe", "42"));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Student#equals(Object)}
     *   <li>{@link Student#hashCode()}
     * </ul>
     */
    @Test
    void testEquals11() {
        Student Student = new Student(123L, null, "Doe", "42");
        Student Student1 = new Student(123L, null, "Doe", "42");

        assertEquals(Student, Student1);
        int expectedHashCodeResult = Student.hashCode();
        assertEquals(expectedHashCodeResult, Student1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Student#equals(Object)}
     *   <li>{@link Student#hashCode()}
     * </ul>
     */
    @Test
    void testEquals12() {
        Student Student = new Student(123L, "Jane", null, "42");
        Student Student1 = new Student(123L, "Jane", null, "42");

        assertEquals(Student, Student1);
        int expectedHashCodeResult = Student.hashCode();
        assertEquals(expectedHashCodeResult, Student1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Student#equals(Object)}
     *   <li>{@link Student#hashCode()}
     * </ul>
     */
    @Test
    void testEquals13() {
        Student Student = new Student(123L, "Jane", "Doe", null);
        Student Student1 = new Student(123L, "Jane", "Doe", null);

        assertEquals(Student, Student1);
        int expectedHashCodeResult = Student.hashCode();
        assertEquals(expectedHashCodeResult, Student1.hashCode());
    }
}

