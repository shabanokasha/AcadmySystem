/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterFaces;

import Models.Students;
import java.util.List;

/**
 *
 * @author ShabanOkasha
 */
public interface studentInterFace {

    public int insert(Students student);

    public int update(Students student);

    public int delete(Students student);

    public List<Students> findAll();
}
