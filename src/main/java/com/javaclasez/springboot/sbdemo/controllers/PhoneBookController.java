package com.javaclasez.springboot.sbdemo.controllers;

import com.javaclasez.springboot.sbdemo.model.PhoneBookEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class PhoneBookController {
    // List of all phone numbers
    private List<PhoneBookEntry> phoneBook = new ArrayList<>();

    //TODO: Create
    @PostMapping(path = "/add")
    public void createPhoneBookEntry(@RequestBody PhoneBookEntry phoneBookEntry) {
        phoneBookEntry.setId(UUID.randomUUID().toString());
        this.phoneBook.add(phoneBookEntry);
    }

    //TODO: Update
    //@RequestMapping(path = "/update", method = RequestMethod.PUT)
    @PutMapping(path = "/upate")
    public void updatePhoneBookEntry(@RequestBody PhoneBookEntry phoneBookEntry) {
        this.phoneBook.remove(phoneBookEntry);
        this.phoneBook.add(phoneBookEntry);
    }

    //TODO: Retrieve (Read All)
    @GetMapping(path = "/read")
    public List<PhoneBookEntry> readAllPhoneBookEntries() {
        return phoneBook;
    }

    //TODO: Delete
    @DeleteMapping(path = "delete")
    public void deletePhoneBookEntry(@RequestBody PhoneBookEntry phoneBookEntry) {
        this.phoneBook.remove(phoneBookEntry);
    }

}
