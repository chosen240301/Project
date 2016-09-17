package by.karl.impl;

import by.karl.entities.MessageEntity;
import by.karl.intf.MessageService;
import by.karl.repository.MessageRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Chosen on 17.09.2016.
 */
@Service("jpaContactService")
@Repository
@Transactional
public class MessageServiceImpl implements MessageService {

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

}
