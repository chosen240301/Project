package by.karl.intf;

import by.karl.entities.MessageEntity;

import java.util.List;

/**
 * Created by Chosen on 17.09.2016.
 */
public interface MessageService {
    List<MessageEntity> findAll();
    List<MessageEntity> findByText(String text);
    void add(MessageEntity messageEntity);
}
