/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import InterFaces.studentInterFace;
import Models.Students;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

/**
 *
 * @author ShabanOkasha
 */
public class studentController implements studentInterFace {

    JdbcTemplate template;

    @Override
    public int insert(Students student) {
//        id, name, address, password, course
        System.out.println("=" + student.getId() + "=" + student.getName() + "=" + student.getAddress() + "=" + student.getPassword() + "=" + student.getCourse());
        String sql = "insert into student(id, name, address, password, course)values(?,?,?,?,?);";
        return template.update(sql, new PreparedStatementSetter() {

            @Override
            public void setValues(java.sql.PreparedStatement ps) throws SQLException {
                ps.setInt(1, student.getId());
                ps.setString(2, student.getName());
                ps.setString(3, student.getAddress());
                ps.setString(4, student.getPassword());
                ps.setString(5, student.getCourse());
//                ps.execute();
                student.setId(0);
                student.setName("");
                student.setAddress("");
                student.setPassword("");
                student.setCourse("");
            }
        });

    }

    @Override
    public int update(Students student) {

        String sql = "update student set name=? ,address=? , password=? , course=? where id=? ;";
        return template.update(sql, new PreparedStatementSetter() {

            @Override
            public void setValues(java.sql.PreparedStatement ps) throws SQLException {
                ps.setInt(5, student.getId());
                ps.setString(1, student.getName());
                ps.setString(2, student.getAddress());
                ps.setString(3, student.getPassword());
                ps.setString(4, student.getCourse());
            }
        });
    }

    @Override
    public int delete(Students student) {

        String sql = "delete  FROM student  where id=? ;";

        return template.update(sql, new PreparedStatementSetter() {

            @Override
            public void setValues(java.sql.PreparedStatement ps) throws SQLException {
                ps.setInt(1, student.getId());
            }
        });
    }

    @Override
    public List<Students> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

}
