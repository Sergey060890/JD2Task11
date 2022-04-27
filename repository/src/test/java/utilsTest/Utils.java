package utilsTest;

import courses.entity.Course;
import courses.entity.Mark;
import courses.entity.Student;
import courses.entity.Task;
import courses.entity.Teacher;

import java.util.Set;

import static constans.ConstansCourse.*;
import static constans.ConstansMark.MARK;
import static constans.ConstansMark.MARK_REVIEW;
import static constans.ConstansStudent.STUDENT_NAME;
import static constans.ConstansStudent.STUDENT_SURNAME;
import static constans.ConstansTask.TASK_DESCRIPTION;
import static constans.ConstansTeacher.TEACHER_NAME;
import static constans.ConstansTeacher.TEACHER_SURNAME;

public class Utils {
    public static Course createCourse() {
        Course course = Course.builder()
                .description(COURSE_DESCRIPTION)
                .hours(COURSE_HOURS)
                .build();
        return course;
    }

    public static Student createStudent(Set<Course> courses) {
        Student student = Student.builder()
                .name(STUDENT_NAME)
                .surname(STUDENT_SURNAME)
                .courses(courses)
                .build();
        return student;
    }

    public static Teacher createTeacher(Set<Course> courses) {
        Teacher teacher = Teacher.builder()
                .name(TEACHER_NAME)
                .surname(TEACHER_SURNAME)
                .courses(courses)
                .build();
        return teacher;
    }

    public static Mark createMark() {
        Mark mark = Mark.builder()
                .mark(MARK)
                .review(MARK_REVIEW)
                .build();
        return mark;
    }

    public static Task createTask(Course course, Mark mark) {
        Task task = Task.builder()
                .description(TASK_DESCRIPTION)
                .course(course)
                .mark(mark)
                .build();
        return task;
    }
}
