package org.example.ui.datas;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankAccount {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String ssn;
    private String userName;
    private String password;
    private String repeatedPassword;
}
