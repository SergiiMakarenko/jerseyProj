package com.sm.controller;

import com.sm.domain.Message;
import com.sm.service.MessageService;
import com.sun.jersey.api.view.Viewable;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sergii Makarenko
 * Jersey controller
 */

@Path("/")
public class JerseyController {
    private static final Logger logger = Logger.getLogger(JerseyController.class);
    private ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    private MessageService service = (MessageService) context.getBean("messageServiceImpl");

    @GET
    @Produces("text/html")
    public Viewable index() {
        logger.info("Navigation - menu");
        return new Viewable("/index");
    }

    @GET
    @Path("/createMSG")
    @Produces("text/html")
    public Response send() {
        logger.info("Navigation - create messages");
        return Response.ok(new  Viewable("/createMSG")).build();
    }

    @POST
    @Path("/createMSG")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces("text/html")
    public Response hello(@FormParam("phone") String phone,@FormParam("msg") String msg ) {
        logger.info("Navigation - create messages");
        Long id = service.saveMessage(phone, msg);
        String result;
        if(id==null) result="Send message failed";
        else
        result="Send message success";
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("result",result);
        return Response.ok(new Viewable("/createMSG", map)).build();
    }

    @GET
    @Path("/viewMSGs")
    @Produces("text/html")
    public Response view() {
        logger.info("Navigation - view messages");
        List<Message> messages = service.findAllMessage();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msgs", messages);
        return Response.ok(new  Viewable("/viewMSGs", map)).build();
    }

}

