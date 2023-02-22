package com.example.Student.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StudentEntityTest {
    /**
     * Method under test: {@link StudentEntity#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new StudentEntity()).canEqual("Other"));
    }

    /**
     * Method under test: {@link StudentEntity#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        StudentEntity StudentEntity = new StudentEntity();

        StudentEntity StudentEntity1 = new StudentEntity();
        StudentEntity1.setEmailId("42");
        StudentEntity1.setFirstName("Jane");
        StudentEntity1.setId(123L);
        StudentEntity1.setLastName("Doe");
        assertTrue(StudentEntity.canEqual(StudentEntity1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link StudentEntity}
     *   <li>{@link StudentEntity#setEmailId(String)}
     *   <li>{@link StudentEntity#setFirstName(String)}
     *   <li>{@link StudentEntity#setId(long)}
     *   <li>{@link StudentEntity#setLastName(String)}
     *   <li>{@link StudentEntity#toString()}
     *   <li>{@link StudentEntity#getEmailId()}
     *   <li>{@link StudentEntity#getFirstName()}
     *   <li>{@link StudentEntity#getId()}
     *   <li>{@link StudentEntity#getLastName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        StudentEntity actualStudentEntity = new StudentEntity();
        actualStudentEntity.setEmailId("42");
        actualStudentEntity.setFirstName("Jane");
        actualStudentEntity.setId(123L);
        actualStudentEntity.setLastName("Doe");
        String actualToStringResult = actualStudentEntity.toString();
        assertEquals("42", actualStudentEntity.getEmailId());
        assertEquals("Jane", actualStudentEntity.getFirstName());
        assertEquals(123L, actualStudentEntity.getId());
        assertEquals("Doe", actualStudentEntity.getLastName());
        assertEquals("StudentEntity(id=123, firstName=Jane, lastName=Doe, emailId=42)", actualToStringResult);
    }

    /**
     * Method under test: {@link StudentEntity#equals(Object)}
     */
    @Test
    void testEquals() {
        StudentEntity StudentEntity = new StudentEntity();
        StudentEntity.setEmailId("42");
        StudentEntity.setFirstName("Jane");
        StudentEntity.setId(123L);
        StudentEntity.setLastName("Doe");
        assertNotEquals(StudentEntity, null);
    }

    /**
     * Method under test: {@link StudentEntity#equals(Object)}
     */
    @Test
    void testEquals2() {
        StudentEntity StudentEntity = new StudentEntity();
        StudentEntity.setEmailId("42");
        StudentEntity.setFirstName("Jane");
        StudentEntity.setId(123L);
        StudentEntity.setLastName("Doe");
        assertNotEquals(StudentEntity, "Different type to StudentEntity");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link StudentEntity#equals(Object)}
     *   <li>{@link StudentEntity#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        StudentEntity StudentEntity = new StudentEntity();
        StudentEntity.setEmailId("42");
        StudentEntity.setFirstName("Jane");
        StudentEntity.setId(123L);
        StudentEntity.setLastName("Doe");
        assertEquals(StudentEntity, StudentEntity);
        int expectedHashCodeResult = StudentEntity.hashCode();
        assertEquals(expectedHashCodeResult, StudentEntity.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link StudentEntity#equals(Object)}
     *   <li>{@link StudentEntity#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        StudentEntity StudentEntity = new StudentEntity();
        StudentEntity.setEmailId("42");
        StudentEntity.setFirstName("Jane");
        StudentEntity.setId(123L);
        StudentEntity.setLastName("Doe");

        StudentEntity StudentEntity1 = new StudentEntity();
        StudentEntity1.setEmailId("42");
        StudentEntity1.setFirstName("Jane");
        StudentEntity1.setId(123L);
        StudentEntity1.setLastName("Doe");
        assertEquals(StudentEntity, StudentEntity1);
        int expectedHashCodeResult = StudentEntity.hashCode();
        assertEquals(expectedHashCodeResult, StudentEntity1.hashCode());
    }

    /**
     * Method under test: {@link StudentEntity#equals(Object)}
     */
    @Test
    void testEquals5() {
        StudentEntity StudentEntity = new StudentEntity();
        StudentEntity.setEmailId("jane.doe@example.org");
        StudentEntity.setFirstName("Jane");
        StudentEntity.setId(123L);
        StudentEntity.setLastName("Doe");

        StudentEntity StudentEntity1 = new StudentEntity();
        StudentEntity1.setEmailId("42");
        StudentEntity1.setFirstName("Jane");
        StudentEntity1.setId(123L);
        StudentEntity1.setLastName("Doe");
        assertNotEquals(StudentEntity, StudentEntity1);
    }

    /**
     * Method under test: {@link StudentEntity#equals(Object)}
     */
    @Test
    void testEquals6() {
        StudentEntity StudentEntity = new StudentEntity();
        StudentEntity.setEmailId(null);
        StudentEntity.setFirstName("Jane");
        StudentEntity.setId(123L);
        StudentEntity.setLastName("Doe");

        StudentEntity StudentEntity1 = new StudentEntity();
        StudentEntity1.setEmailId("42");
        StudentEntity1.setFirstName("Jane");
        StudentEntity1.setId(123L);
        StudentEntity1.setLastName("Doe");
        assertNotEquals(StudentEntity, StudentEntity1);
    }

    /**
     * Method under test: {@link StudentEntity#equals(Object)}
     */
    @Test
    void testEquals7() {
        StudentEntity StudentEntity = new StudentEntity();
        StudentEntity.setEmailId("42");
        StudentEntity.setFirstName("Doe");
        StudentEntity.setId(123L);
        StudentEntity.setLastName("Doe");

        StudentEntity StudentEntity1 = new StudentEntity();
        StudentEntity1.setEmailId("42");
        StudentEntity1.setFirstName("Jane");
        StudentEntity1.setId(123L);
        StudentEntity1.setLastName("Doe");
        assertNotEquals(StudentEntity, StudentEntity1);
    }

    /**
     * Method under test: {@link StudentEntity#equals(Object)}
     */
    @Test
    void testEquals8() {
        StudentEntity StudentEntity = new StudentEntity();
        StudentEntity.setEmailId("42");
        StudentEntity.setFirstName(null);
        StudentEntity.setId(123L);
        StudentEntity.setLastName("Doe");

        StudentEntity StudentEntity1 = new StudentEntity();
        StudentEntity1.setEmailId("42");
        StudentEntity1.setFirstName("Jane");
        StudentEntity1.setId(123L);
        StudentEntity1.setLastName("Doe");
        assertNotEquals(StudentEntity, StudentEntity1);
    }

    /**
     * Method under test: {@link StudentEntity#equals(Object)}
     */
    @Test
    void testEquals9() {
        StudentEntity StudentEntity = new StudentEntity();
        StudentEntity.setEmailId("42");
        StudentEntity.setFirstName("Jane");
        StudentEntity.setId(1L);
        StudentEntity.setLastName("Doe");

        StudentEntity StudentEntity1 = new StudentEntity();
        StudentEntity1.setEmailId("42");
        StudentEntity1.setFirstName("Jane");
        StudentEntity1.setId(123L);
        StudentEntity1.setLastName("Doe");
        assertNotEquals(StudentEntity, StudentEntity1);
    }

    /**
     * Method under test: {@link StudentEntity#equals(Object)}
     */
    @Test
    void testEquals10() {
        StudentEntity StudentEntity = new StudentEntity();
        StudentEntity.setEmailId("42");
        StudentEntity.setFirstName("Jane");
        StudentEntity.setId(123L);
        StudentEntity.setLastName("Jane");

        StudentEntity StudentEntity1 = new StudentEntity();
        StudentEntity1.setEmailId("42");
        StudentEntity1.setFirstName("Jane");
        StudentEntity1.setId(123L);
        StudentEntity1.setLastName("Doe");
        assertNotEquals(StudentEntity, StudentEntity1);
    }

    /**
     * Method under test: {@link StudentEntity#equals(Object)}
     */
    @Test
    void testEquals11() {
        StudentEntity StudentEntity = new StudentEntity();
        StudentEntity.setEmailId("42");
        StudentEntity.setFirstName("Jane");
        StudentEntity.setId(123L);
        StudentEntity.setLastName(null);

        StudentEntity StudentEntity1 = new StudentEntity();
        StudentEntity1.setEmailId("42");
        StudentEntity1.setFirstName("Jane");
        StudentEntity1.setId(123L);
        StudentEntity1.setLastName("Doe");
        assertNotEquals(StudentEntity, StudentEntity1);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link StudentEntity#equals(Object)}
     *   <li>{@link StudentEntity#hashCode()}
     * </ul>
     */
    @Test
    void testEquals12() {
        StudentEntity StudentEntity = new StudentEntity();
        StudentEntity.setEmailId(null);
        StudentEntity.setFirstName("Jane");
        StudentEntity.setId(123L);
        StudentEntity.setLastName("Doe");

        StudentEntity StudentEntity1 = new StudentEntity();
        StudentEntity1.setEmailId(null);
        StudentEntity1.setFirstName("Jane");
        StudentEntity1.setId(123L);
        StudentEntity1.setLastName("Doe");
        assertEquals(StudentEntity, StudentEntity1);
        int expectedHashCodeResult = StudentEntity.hashCode();
        assertEquals(expectedHashCodeResult, StudentEntity1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link StudentEntity#equals(Object)}
     *   <li>{@link StudentEntity#hashCode()}
     * </ul>
     */
    @Test
    void testEquals13() {
        StudentEntity StudentEntity = new StudentEntity();
        StudentEntity.setEmailId("42");
        StudentEntity.setFirstName(null);
        StudentEntity.setId(123L);
        StudentEntity.setLastName("Doe");

        StudentEntity StudentEntity1 = new StudentEntity();
        StudentEntity1.setEmailId("42");
        StudentEntity1.setFirstName(null);
        StudentEntity1.setId(123L);
        StudentEntity1.setLastName("Doe");
        assertEquals(StudentEntity, StudentEntity1);
        int expectedHashCodeResult = StudentEntity.hashCode();
        assertEquals(expectedHashCodeResult, StudentEntity1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link StudentEntity#equals(Object)}
     *   <li>{@link StudentEntity#hashCode()}
     * </ul>
     */
    @Test
    void testEquals14() {
        StudentEntity StudentEntity = new StudentEntity();
        StudentEntity.setEmailId("42");
        StudentEntity.setFirstName("Jane");
        StudentEntity.setId(123L);
        StudentEntity.setLastName(null);

        StudentEntity StudentEntity1 = new StudentEntity();
        StudentEntity1.setEmailId("42");
        StudentEntity1.setFirstName("Jane");
        StudentEntity1.setId(123L);
        StudentEntity1.setLastName(null);
        assertEquals(StudentEntity, StudentEntity1);
        int expectedHashCodeResult = StudentEntity.hashCode();
        assertEquals(expectedHashCodeResult, StudentEntity1.hashCode());
    }
}

