package entityTest;

import courses.util.HibernateUtil;
import org.junit.AfterClass;

public class AppTest {
    @AfterClass
    public static void clean() throws Exception {
        HibernateUtil.close();
    }
}
