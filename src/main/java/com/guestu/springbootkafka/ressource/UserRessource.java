package com.guestu.springbootkafka.ressource;

import com.guestu.springbootkafka.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class UserRessource {

    @Autowired
    KafkaTemplate<String, User> kafkaTemplate;

    @GetMapping ("/publish/{message}")
    public String post(@PathVariable("message") final String message){
        kafkaTemplate.send("TestTopic",new User("peter","cArch",5000L));

        System.out.println("published message: "+message);
        return "published sussessfully";
    }
}
