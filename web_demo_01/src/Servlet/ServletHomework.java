package Servlet;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * @author buguniao
 * @version v1.0
 * @date 2019/8/13 19:35
 * @description TODO
 **/
@WebServlet("/ServletHomework")
public class ServletHomework extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* Properties pro = new Properties();
        pro.load(new FileInputStream("druid.properties"));
        DataSource dataSource = null;
        try {
            dataSource = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JdbcTemplate jt = new JdbcTemplate(dataSource);*/

        JdbcTemplate jt = new JdbcTemplate(Util.getDataSource());
        String sql="select * from biao";
        List<Person> list = jt.query(sql, new BeanPropertyRowMapper<>(Person.class));
        System.out.println(list);
    }
}