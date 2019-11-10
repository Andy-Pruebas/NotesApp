package pe.avilca.notesapp.repositories;

import com.orm.SugarRecord;

import java.util.List;

import pe.avilca.notesapp.models.User;

public class UserRepository {
    public static List<User> list(){
        List<User> users = SugarRecord.listAll(User.class);
        return users;
    }

    public static User login(String username, String password) {
        List<User> users = SugarRecord.listAll(User.class);
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public static User read(long id){
        User user = SugarRecord.findById(User.class, id);
        return user;
    }

    public static void create(String username,String fullname, String email, String password){
        User user = new User(username,fullname, email, password);
        SugarRecord.save(user);
    }
    public static  User findByUsername(String username){
        List<User> users = SugarRecord.listAll(User.class);
        for (User u: users){
            if(u.getUsername().equals(username)){
                return u;
            }
        }
        return null;
    }
}
