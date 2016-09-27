package by.karl.controller;

import by.karl.entities.MessageEntity;
import by.karl.entities.UserEntity;
import by.karl.intf.MessageService;
import by.karl.intf.UserService;
import org.apache.log4j.Logger;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.List;


@Controller
public class MainController {
    private MessageSource messageSource;
    private Logger logger = Logger.getLogger(MainController.class);
    /*First method on start application*/
    /*Попадаем сюда на старте приложения (см. параметры аннтоции и настройки пути после деплоя) */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userJSP", new Integer(3));
        
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /*как только на index.jsp подтвердится форма
    <spring:form method="post"  modelAttribute="userJSP" action="check-user">,
    то попадем вот сюда
     */
    @RequestMapping(value = "/check-user")
    public ModelAndView checkUser(@ModelAttribute("userJSP") UserEntity user) {
        ModelAndView modelAndView = new ModelAndView();

        //имя представления, куда нужно будет перейти
        modelAndView.setViewName("secondPage");

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring-config.xml"); //move from src.main.java to src.main.resources
        ctx.refresh();

        UserService userService = ctx.getBean("jpaUserService", UserService.class);
        List<UserEntity> users = userService.findAll();

        //записываем в атрибут userJSP (используется на странице *.jsp объект user
        modelAndView.addObject("userJSP", users);
        logger.info("QQQQQ: " + messageSource.getClass());
        return modelAndView; //после уйдем на представление, указанное чуть выше, если оно будет найдено.
    }

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}
