package service;

import data.UserMapper;
import java.sql.SQLException;
import java.util.List;
import service.entity.User;
import service.exceptions.PolygonException;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk created on Nov 8, 2016 
 */
public class DomainController {
    public List<User> getUsers() throws PolygonException{
        List<User> users = UserMapper.getUsers();
        return users;
    }
}
