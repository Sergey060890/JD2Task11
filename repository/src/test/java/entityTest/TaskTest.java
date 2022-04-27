package entityTest;

import courses.dao.EntityDaoImpl;
import courses.entity.Course;
import courses.entity.Mark;
import courses.entity.Task;
import courses.util.HibernateUtil;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import utilsTest.Utils;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static constans.ConstansTask.*;
import static org.junit.Assert.assertTrue;

public class TaskTest {
    private static Task task;
    private static List<Task> tasks = new ArrayList<>();

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void jpqlTask() {
        Course course = Utils.createCourse();
        Mark mark = Utils.createMark();
        task = Utils.createTask(course,mark);
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.persist(mark);
        entityManager.persist(task);
        tasks.add(task);
        entityManager.getTransaction().commit();
        entityManager.close();
        Assert.assertNotNull(task);
        Assert.assertEquals("Task description not equals",
                TASK_DESCRIPTION, task.getDescription());
    }

    @Test
    public void insertTestTask() {
        Course course = Utils.createCourse();
        Mark mark = Utils.createMark();
        task = Utils.createTask(course,mark);
        EntityDaoImpl daoTask = new EntityDaoImpl(Task.class);
        daoTask.insert(course);
        daoTask.insert(mark);
        daoTask.insert(task);
        tasks.add(task);

        Assert.assertNotNull(daoTask.getEntity(Task.class, TASK_INSERT_ID));
    }

    @Test
    public void deleteTestTask() {
        Course course = Utils.createCourse();
        Mark mark = Utils.createMark();
        task = Utils.createTask(course,mark);
        EntityDaoImpl daoTask = new EntityDaoImpl(Task.class);
        daoTask.insert(course);
        daoTask.insert(mark);
        daoTask.insert(task);
        tasks.add(task);
        daoTask.delete(task);
        Assert.assertNotNull(task);
        System.out.println("Attention. There are dependent tables!");
    }

    @Test
    public void deleteIdTestTask() {
        Course course = Utils.createCourse();
        Mark mark = Utils.createMark();
        task = Utils.createTask(course,mark);
        EntityDaoImpl daoTask = new EntityDaoImpl(Task.class);
        daoTask.insert(course);
        daoTask.insert(mark);
        daoTask.insert(task);
        tasks.add(task);
        daoTask.deleteById(TASK_DELETE_BYID);
        Assert.assertNotNull(task);
        System.out.println("Attention. There are dependent tables!");
    }

    @Test
    public void updateTestTask() {
        Course course = Utils.createCourse();
        Mark mark = Utils.createMark();
        task = Utils.createTask(course,mark);
        EntityDaoImpl daoTask = new EntityDaoImpl(Task.class);
        task.setDescription(TASK_SET_DESCRIPTION);
        daoTask.insert(course);
        daoTask.insert(mark);
        daoTask.insert(task);
        tasks.add(task);
        daoTask.update(task);
        Assert.assertEquals(task.getDescription(),
                TASK_SET_DESCRIPTION);
    }

    @Test
    public void getEntityTestTask() {
        Course course = Utils.createCourse();
        Mark mark = Utils.createMark();
        task = Utils.createTask(course,mark);
        EntityDaoImpl daoTask = new EntityDaoImpl(Task.class);
        daoTask.insert(course);
        daoTask.insert(mark);
        daoTask.insert(task);
        tasks.add(task);
        Assert.assertNotNull(daoTask.getEntity(Task.class, TASK_GET_ID).toString());
    }

    @Test
    public void selectTestTask() {
        Course course = Utils.createCourse();
        Mark mark = Utils.createMark();
        task = Utils.createTask(course,mark);
        EntityDaoImpl daoTask = new EntityDaoImpl(Task.class);
        daoTask.insert(course);
        daoTask.insert(mark);
        daoTask.insert(task);
        tasks.add(task);
        Assert.assertEquals(tasks.toString(), daoTask.select().toString());
    }
}
