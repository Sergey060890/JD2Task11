package entityTest;

import courses.dao.EntityDaoImpl;
import courses.entity.Course;
import courses.entity.Student;
import courses.util.HibernateUtil;
import org.junit.Assert;
import org.junit.Test;
import utilsTest.Utils;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static constans.ConstansStudent.*;
import static constans.ConstansStudent.STUDENT_NAME;
import static org.junit.Assert.assertTrue;

public class StudentTest {
    private static Student student;
    private static Course course;
    private static List<Student> students = new ArrayList<>();
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void jpqlStudent() {
        Course course = Utils.createCourse();
        student = Utils.createStudent(Set.of(course));
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();
        entityManager.close();
        Assert.assertNotNull(student);
        Assert.assertEquals("Student name not equals", STUDENT_NAME, student.getName());
    }

    @Test
    public void insertTestStudent() {
        course = Utils.createCourse();
        student = Utils.createStudent(Set.of(course));
        EntityDaoImpl daoStudent = new EntityDaoImpl(Student.class);
        daoStudent.insert(course);
        daoStudent.insert(student);
        students.add(student);
        Assert.assertNotNull(daoStudent.getEntity(Student.class, STUDENT_INSERT_ID));
    }

    @Test
    public void deleteTestStudent() {
        course = Utils.createCourse();
        student = Utils.createStudent(Set.of(course));
        EntityDaoImpl daoStudent = new EntityDaoImpl(Student.class);
        daoStudent.insert(course);
        daoStudent.insert(student);
        students.add(student);
        daoStudent.delete(student);
        Assert.assertNotNull(student);
        System.out.println("Attention. There are dependent tables!");
    }

    @Test
    public void deleteIdTestStudent() {
        course = Utils.createCourse();
        student = Utils.createStudent(Set.of(course));
        EntityDaoImpl daoStudent = new EntityDaoImpl(Student.class);
        daoStudent.insert(course);
        daoStudent.insert(student);
        students.add(student);
        daoStudent.deleteById(STUDENT_DELETE_BYID);
        Assert.assertNotNull(student);
        System.out.println("Attention. There are dependent tables!");
    }

    @Test
    public void updateTestStudent() {
        student = Student.builder()
                .name(STUDENT_NAME)
                .surname(STUDENT_SURNAME)
                .build();
        EntityDaoImpl daoStudent = new EntityDaoImpl(Student.class);
        daoStudent.insert(student);
        student.setName(STUDENT_SET_NAME);
        students.add(student);
        daoStudent.update(student);
        Assert.assertEquals(student.getName(),
                STUDENT_SET_NAME);
    }

    @Test
    public void getEntityTestStudent() {
        course = Utils.createCourse();
        student = Utils.createStudent(Set.of(course));
        EntityDaoImpl daoStudent = new EntityDaoImpl(Student.class);
        daoStudent.insert(course);
        daoStudent.insert(student);
        students.add(student);
        Assert.assertNotNull(daoStudent.getEntity(Student.class, STUDENT_GET_ID).toString());
    }

    @Test
    public void selectTestStudent() {
        course = Utils.createCourse();
        student = Utils.createStudent(Set.of(course));
        EntityDaoImpl daoStudent = new EntityDaoImpl(Student.class);
        daoStudent.insert(course);
        daoStudent.insert(student);
        students.add(student);
        Assert.assertEquals(students.toString(), daoStudent.select().toString());
    }
}
