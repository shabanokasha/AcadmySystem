/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javax.faces.bean.ManagedBean;
import InterFaces.studentInterFace;
import Models.Students;
import javax.annotation.PostConstruct;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author ShabanOkasha
 */
@ManagedBean(name = "student")
public class studentBean {

    private int id;
    private String name;
    private String address;
    private String password;
    private String course;

    studentInterFace stuInterFace;
    ApplicationContext context;
    studentBean bean;

    @PostConstruct
    public void init() {
        context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        bean = (studentBean) context.getBean("studentBean");
    }

    public String addStudent() {

        Students s = new Students();
        s.setId(id);
        s.setName(name);
        s.setAddress(address);
        s.setPassword(password);
        s.setCourse(course);
        if (s.getId() == 0 & s.getName()=="" & s.getAddress()=="" & s.getPassword()=="" & s.getCourse()==""  ) {
            return "Course.xhtml";
        } else {
            bean.stuInterFace.insert(s);
            return "index.xhtml";
        }

    }

    public void updateSTudent() {
        Students s = new Students();
        s.setId(id);
        s.setName(name);
        s.setAddress(address);
        s.setPassword(password);
        s.setCourse(course);
        bean.stuInterFace.update(s);
    }

    public void deleteStudent() {
        Students s = new Students();
        s.setId(id);
        bean.stuInterFace.delete(s);
    }

    public studentInterFace getStuInterFace() {
        return stuInterFace;
    }

    public void setStuInterFace(studentInterFace stuInterFace) {
        this.stuInterFace = stuInterFace;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

}
