/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import Daos.UserDao;
import Daos.UserDaoImplements;
import Model.User;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex
 */
@Path("/users")
public class UserService implements UserDao {

    @GET
    @Path("/all/xml")
    @Produces(MediaType.APPLICATION_XML)
    @Override
    public List<User> getUsers() { // este ya devuelve en xml
        try (UserDaoImplements udi = new UserDaoImplements()) {
            List<User> users =udi.getUsers();
            return users;
        } catch (Exception ex) {
            System.out.println("No se ha podido obtener la lista de usuarios");
            return null;
        }
    }

    @GET
    @Path("/id/{id}") // si no pongo un prefijo (/id) no sabe diferenciar de la entrada del yearBirth
    @Produces(MediaType.APPLICATION_XML)
    @Override
    public User getUserByID(@PathParam("id") String id) {
        try (UserDaoImplements udi = new UserDaoImplements()) {
            User user = udi.getUserByID(id);
            return user;
        } catch (Exception ex) {
            System.out.println("No se ha podido obtener la lista de usuarios");
            return null;
        }
    }

    @GET
    @Path("/yearBirth/{yearBirth}") // si no pongo un prefijo (/yearBirth) no sabe diferenciar de la entrada del id
    @Produces(MediaType.APPLICATION_XML)
    @Override
    public List<User> getUserByYearBirth(@PathParam("yearBirth") int yearBirth) {
        List<User> l = null;
        try (UserDaoImplements udi = new UserDaoImplements()) {
            l = udi.getUserByYearBirth(yearBirth);

        } catch (Exception ex) {
            System.out.println("No se ha podido obtener la lista de usuarios");
        }
        return l;
    }

    @GET
    @Path("/all/json")  //solo con llamar al metodo getUsers pero con el mediaType.APPLICATION_JSON ya devuelve el json
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public List<User> getUsersJSON() {
        try (UserDaoImplements udi = new UserDaoImplements()) {
            return udi.getUsers();
        } catch (Exception ex) {
            System.out.println("No se ha podido obtener la lista de usuarios");
            return null;
        }
    }

    @POST
    @Path("/insert/user/json")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public User insertJson(User user) {
        return insertUsuario(user);
    }

    @POST
    @Path("/insert/list/json")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public List<User> createUserJSON(List<User> lu) {
        return insertUsuarios(lu);
    }

    @POST
    @Path("/insert/user/xml")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    @Override
    public User insertXML(User user) {
        return insertUsuario(user);
    }

    @POST
    @Path("/insert/list/xml")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    @Override
    public List<User> createUserXML(List<User> lu) {
        List<User> uss = new ArrayList<User>();
        uss = insertUsuarios(lu);
        return uss;
    }

    private User insertUsuario(User user) {
        try (UserDaoImplements udi = new UserDaoImplements()) {
            udi.insertUser(user);
            System.out.println("insertado Usuario " + user.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }

    private List<User> insertUsuarios(List<User> lu) {
        List<User> r = new ArrayList<User>();
        {
            try (UserDaoImplements udi = new UserDaoImplements()) { //Tiene que insertar en el xml solo lo que haya funcionado
                for (User user : lu) {
                    if (UserDaoImplements.insertUser(user)) {
                        r.add(user);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return r;
    }
}
