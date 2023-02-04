/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.util.*;

/**
 *
 * @author albaraa
 */
public class UsersNavigableMap {

    NavigableMap users = new TreeMap();

    public String addUser(User user) {
        String s = null;
        if (exist(user.getId())) {
            s = "This user already exists";
        } else {
            users.put(user.getId(), user);
        }
        return s;
    }

    public boolean exist(int id) {
        return users.containsKey(id);
    }
    
    public User serach(int id){
        return (User)users.get(id);
    }
}
