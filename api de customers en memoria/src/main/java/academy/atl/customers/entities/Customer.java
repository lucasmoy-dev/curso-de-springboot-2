package academy.atl.customers.entities;

import lombok.*;

@Data
public class Customer {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String address;

}
