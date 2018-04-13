package tests;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.jndi.JndiTemplate;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceTest {
    @Test
    public void shouldReturnNotNull() throws SQLException, NamingException {
        Context initContext = new InitialContext();
        Context envContext = (Context) initContext.lookup("java:comp/env");
        DataSource ds = (DataSource) envContext.lookup("jdbc/spitterdb");
        Connection conn = ds.getConnection();
        Assert.assertNotNull(ds);

    }
    }

