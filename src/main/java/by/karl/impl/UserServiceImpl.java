package by.karl.impl;

import by.karl.entities.UserEntity;
import by.karl.intf.MessageService;
import by.karl.intf.UserService;
import by.karl.repository.MessageRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Chosen on 17.09.2016.
 */
@Service("jpaUserService")
@Repository
@Transactional
public class UserServiceImpl implements UserService {
/*
        @Autowired
        private MessageRepository messageRepository;

        public List<UserEntity> findAll() {
            return Lists.newArrayList(messageRepository.findAll());
        }

        public List<UserEntity> findByText(String text) {
            return messageRepository.findByText(text);
        }

        public void add(UserEntity messageEntity) {
            messageRepository.save(messageEntity);
        }
*/
    @PersistenceContext
    private EntityManager em;
    @Transactional(readOnly = true)
    public List<UserEntity> findAll() {
        List<UserEntity> users = em.createNamedQuery("User.findAll",
                UserEntity.class).getResultList() ;
        return users;
    }

    @Transactional(readOnly = true)
    public List<UserEntity> findByName(String name) {
        List<UserEntity> users = em.createNamedQuery("User.findByName",
                UserEntity.class).setParameter("name", name).getResultList() ;
        return users;
    }

    public void add(UserEntity userEntity) {
        return;
    }

}
