package by.karl.impl;

import by.karl.entities.UserEntity;
import by.karl.intf.MessageService;
import by.karl.intf.UserService;
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

        public List<MessageEntity> findAll() {
            return Lists.newArrayList(messageRepository.findAll());
        }

        public List<MessageEntity> findByText(String text) {
            return messageRepository.findByText(text);
        }

        public void add(MessageEntity messageEntity) {
            messageRepository.save(messageEntity);
        }
    */
    @PersistenceContext
    private EntityManager em;

    public List<UserEntity> findAll() {
        List<UserEntity> messages = em.createNamedQuery("User.findAll",
                UserEntity.class).getResultList() ;
        return messages;
    }

    public List<UserEntity> findByName(String name) {
        return null;
    }

    public void add(UserEntity messageEntity) {
        return;
    }
}
