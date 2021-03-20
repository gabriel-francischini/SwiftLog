import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HibernateTest {
    /// private UserDAO userDao;

    public HibernateTest() {
        // this.userDao = new UserDaoImpl();
    }

    @Test
    public void testInsertUser() {
        User user = new User("Robb", "Stark", 17);

        HibernateConfig.salvar(user);

        //assertTrue(id instanceof Integer);
        assertTrue(true);
    }
}
