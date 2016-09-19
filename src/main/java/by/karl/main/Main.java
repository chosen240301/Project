package by.karl.main;

import by.karl.entities.MessageEntity;
import by.karl.entities.UserEntity;
import by.karl.intf.MessageService;
import by.karl.intf.UserService;
import com.google.common.collect.Lists;
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

        MessageService messageService = ctx.getBean("jpaMessageService", MessageService.class);
        UserService userService = ctx.getBean("jpaUserService", UserService.class);
        List<UserEntity> users = userService.findAll();
        printAllUsers(users);


    }

    private static void printAllMessages(List<MessageEntity> messages) {
        if (messages == null) {
            System.out.println("Нет сообщений");
            return;
        }
        for (MessageEntity message : messages) {
            System.out.println("\t" + message);
        }
    }


    private static void printAllUsers(List<UserEntity> users) {
        System.out.println("printAllUsers: ");
        if (users == null) {
            System.out.println("Нет пользователей");
            return;
        }
        for (UserEntity user : users) {
            System.out.println(user);
            printAllMessages(Lists.newArrayList(user.getMessagesById()));
        }
    }
}
