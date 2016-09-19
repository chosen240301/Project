package by.karl.main;

import by.karl.entities.MessageEntity;
import by.karl.intf.MessageService;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

/**
 * Created by Chosen on 17.09.2016.
 */
public class Main {
    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring-config.xml"); //move from src.main.java to src.main.resources
        ctx.refresh();

        MessageService service = ctx.getBean("jpaContactService", MessageService.class);
        List<MessageEntity> messages = service.findAll();
        printAll(messages);

        messages = service.findByText("Привет");
        printAll(messages);

        if ((messages!=null) && (!messages.isEmpty())) {
            messages.get(0).setText("Жопа");
            service.add(messages.get(0));
        }
        messages = service.findAll();
        printAll(messages);

    }

    private static void printAll(List<MessageEntity> messages) {
        System.out.println("printAll: ");
        if (messages == null) {
            System.out.println("Nothing to print");
            return;
        }
        for (MessageEntity message : messages) {
            System.out.println(message);
        }
    }
}
