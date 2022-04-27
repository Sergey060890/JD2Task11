package entityTest;

import courses.dao.EntityDaoImpl;
import courses.entity.Course;
import courses.entity.Teacher;
import courses.util.HibernateUtil;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import utilsTest.Utils;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import static constans.ConstansTeacher.*;
import static org.junit.Assert.assertTrue;

public class TeacherTest {
    private static Teacher teacher;
    private static List<Teacher> teachers = new ArrayList<>();

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void jpqlTeacher() {
        Course course = Utils.createCourse();
        teacher = Utils.createTeacher(Set.of(course));
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.persist(teacher);
        entityManager.getTransaction().commit();
        entityManager.close();
        Assert.assertNotNull(teacher);
        Assert.assertEquals("Teacher name not equals", TEACHER_NAME, teacher.getName());
    }

    @Test
    public void insertTestTeacher() {
        Course course = Utils.createCourse();
        teacher = Utils.createTeacher(Set.of(course));
        EntityDaoImpl daoTeacher = new EntityDaoImpl(Teacher.class);
        daoTeacher.insert(course);
        daoTeacher.insert(teacher);
        teachers.add(teacher);
        Assert.assertNotNull(teacher);
    }

    @Test
    public void deleteTestTeacher() {
        Course course = Utils.createCourse();
        teacher = Utils.createTeacher(Set.of(course));
        EntityDaoImpl daoTeacher = new EntityDaoImpl(Teacher.class);
        daoTeacher.insert(course);
        daoTeacher.insert(teacher);
        teachers.add(teacher);
        daoTeacher.delete(teacher);
        Assert.assertNotNull(teacher);
        System.out.println("Attention. There are dependent tables!");
    }

    @Test
    public void deleteIdTestTeacher() {
        Course course = Utils.createCourse();
        teacher = Utils.createTeacher(Set.of(course));
        EntityDaoImpl daoTeacher = new EntityDaoImpl(Teacher.class);
        daoTeacher.insert(course);
        daoTeacher.insert(teacher);
        teachers.add(teacher);
        daoTeacher.deleteById(TEACHER_DELETE_BYID);
        Assert.assertNotNull(teacher);
        System.out.println("Attention. There are dependent tables!");
    }

    @Test
    public void updateTestTeacher() {
        teacher = Teacher.builder()
                .name(TEACHER_NAME)
                .surname(TEACHER_SURNAME)
                .build();
        EntityDaoImpl daoTeacher = new EntityDaoImpl(Teacher.class);
        daoTeacher.insert(teacher);
        teacher.setName(TEACHER_SET_NAME);
        teachers.add(teacher);
        daoTeacher.update(teacher);
        Assert.assertEquals(teacher.getName(),
                TEACHER_SET_NAME);
    }

    @Test
    public void getEntityTestTeacher() {
        Course course = Utils.createCourse();
        teacher = Utils.createTeacher(Set.of(course));
        EntityDaoImpl daoTeacher = new EntityDaoImpl(Teacher.class);
        daoTeacher.insert(course);
        daoTeacher.insert(teacher);
        teachers.add(teacher);
        Assert.assertNotNull(teacher);
    }

    @Test
    public void selectTestStudent() {
        Course course = Utils.createCourse();
        teacher = Utils.createTeacher(Set.of(course));
        EntityDaoImpl daoTeacher = new EntityDaoImpl(Teacher.class);
        daoTeacher.insert(course);
        daoTeacher.insert(teacher);
        teachers.add(teacher);
        Assert.assertEquals(teachers.toString(), daoTeacher.select().toString());
    }
}
