package dk.controllers;

import dk.model.User;
import dk.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 52947 on 08-04-2016.
 */
@Controller
public class UserController {

    /**
     * GET /create  --> Create a new user and save it in the database.
     */
    @RequestMapping("/create")
    @ResponseBody
    public String create(String username, String password, boolean enabled) {
        String userId = "";
        try {
            User user = new User(username, password, enabled);
            userDao.save(user);
            userId = String.valueOf(user.getId());
        }
        catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created with id = " + userId;
    }

    /**
     * GET /delete  --> Delete the user having the passed id.
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(int id) {
        try {
            User user = new User(id);
            userDao.delete(user);
        }
        catch (Exception ex) {
            return "Error deleting the user:" + ex.toString();
        }
        return "User successfully deleted!";
    }

    /**
     * GET /get-by-username  --> Return the id for the user having the passed
     * username.
     */
    @RequestMapping("/get-by-username")
    @ResponseBody
    public String getByUsername(String username) {
        String userId;
        try {
            User user = userDao.findByUsername(username);
            userId = String.valueOf(user.getId());
        }
        catch (Exception ex) {
            return "User not found";
        }
        return "The user id is: " + userId;
    }

    /**
     * GET /update  --> Update the username, password and enabled for the user in the
     * database having the passed id.
     */
    @RequestMapping("/update")
    @ResponseBody
    public String updateUser(int id, String username, String password, boolean enabled) {
        try {
            User user = userDao.findOne(id);
            user.setUserName(username);
            user.setPassword(password);
            user.setEnabled(enabled);
            userDao.save(user);
        }
        catch (Exception ex) {
            return "Error updating the user: " + ex.toString();
        }
        return "User succesfully updated!";
    }

    // Private fields

    @Autowired
    private UserDao userDao;

}
