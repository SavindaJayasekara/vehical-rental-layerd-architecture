package lk.ijse.ikmanRental.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class Admin {
    public Admin(String firstName, String lastName, String NIC, String password, String gmail) {
        this.firstName = firstName;
        LastName = lastName;
        this.NIC = NIC;
        this.password = password;
        this.gmail = gmail;
    }

    private String firstName;
    private String LastName;
    private String NIC;
    private String password;
    private String gmail;
}
