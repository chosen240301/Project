package by.karl.repository;

import by.karl.entities.MessageEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Chosen on 17.09.2016.
 */
public interface MessageRepository extends CrudRepository<MessageEntity, Integer> {
    List<MessageEntity> findByText(String text);
}
