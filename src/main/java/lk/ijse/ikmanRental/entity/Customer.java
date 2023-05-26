package lk.ijse.ikmanRental.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
    private String Nic;
    private String gmail;
    private String contact;
    private String name;
    private String adminNic;

    public Customer(String nic, String gmail, String contact, String name, String adminNic) {
        Nic = nic;
        this.gmail = gmail;
        this.contact = contact;
        this.name = name;
        this.adminNic = adminNic;
    }

}
