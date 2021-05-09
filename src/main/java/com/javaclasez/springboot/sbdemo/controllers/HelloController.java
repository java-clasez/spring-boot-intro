package com.javaclasez.springboot.sbdemo.controllers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    static Map<Integer, Item> itemsMap = new HashMap<>();

    static {
        itemsMap.put(1, new Item("Milk", 3));
        itemsMap.put(2, new Item("Candy", 1));
        itemsMap.put(3, new Item("Cake", 20));
        itemsMap.put(4, new Item("Pizza", 30));
        itemsMap.put(5, new Item("Sugar", 5));
    }


    @GetMapping(path = "/hello")
    public Map<String, String> helloWorld() {
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("message", "Hello World!");

        return resultMap;
    }


    /**
     * Request Parameter Demo
     * @param name
     * @return
     */
    @GetMapping(path="/sayhello")
    public Map<String, String> sayHelloTo(@RequestParam(name="guestName", required = false) String name) {
        Map<String, String> resultMap = new HashMap<>();
        if(name == null) {
            resultMap.put("message", "Hello Guest");
        } else {
            resultMap.put("message", "Hello " + name);
        }

        return resultMap;
    }

    @GetMapping(path = "/hello2/{firstName}/{guestLastName}")
    public Map<String, String> sayHelloToPath(@PathVariable String firstName, @PathVariable String guestLastName) {
        Map<String, String> resultMap = new HashMap<>();
        if(firstName == null) {
            resultMap.put("message", "Hello Guest");
        } else {
            resultMap.put("message", "Hello " + firstName + " " + guestLastName);
        }

        return resultMap;
    }


    @GetMapping(path = "/item/{id}")
    public Item getItemByPathVariable(@PathVariable Integer id) {
        return itemsMap.get(id);
    }

    @GetMapping(path = "/getItem")
    public Item getItemByRequestParam(@RequestParam(name = "id", required = true) Integer id) {
        return itemsMap.get(id);
    }
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Item {
    private String name;
    private int price;
}