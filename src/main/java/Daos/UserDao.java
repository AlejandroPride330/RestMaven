/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Daos;

import Model.User;
import jakarta.ws.rs.PathParam;
import java.util.List;

/**
 *
 * @author Alex
 */
public interface UserDao {
    public List<User> getUsers();

    public User getUserByID(@PathParam("id") String id);

    public List<User> getUserByYearBirth(@PathParam("yearBirth") int yearBirth);

    public List<User> getUsersJSON();

    public User insertXML(User user);

    public User insertJson(User user);
    
    public List<User> createUserJSON(List<User> lu);
    
    public List<User> createUserXML(List<User> lu);
}
