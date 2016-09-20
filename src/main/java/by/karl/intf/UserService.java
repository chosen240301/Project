package by.karl.intf;

import by.karl.entities.UserEntity;

import java.util.List;

/**
 * Created by Chosen on 17.09.2016.
 */
public interface UserService {
    List<UserEntity> findAll();
    List<UserEntity> findByName(String name);
    void add(UserEntity messageEntity);
}
