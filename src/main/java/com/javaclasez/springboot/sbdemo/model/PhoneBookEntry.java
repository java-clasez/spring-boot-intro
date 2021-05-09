package com.javaclasez.springboot.sbdemo.model;

import lombok.Data;

@Data
public class PhoneBookEntry {
    public String id;
    public String firstName;
    public String lastName;
    public String phoneNumber;
}
