package lk.ijse.ikmanRental.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class AdminDTO {
    public AdminDTO(String firstName, String lastName, String NIC, String password, String gmail) {
        this.firstName = firstName;
        LastName = lastName;
        this.NIC = NIC;
        this.password = password;
        this.gmail = gmail;
    }


    private String NIC;
    private String firstName;
    private String LastName;
    private String gmail;
    private String password;
}
