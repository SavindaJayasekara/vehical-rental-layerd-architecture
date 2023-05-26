package lk.ijse.ikmanRental.dto;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BillDTO {
    String billID;
    String bookingID;
    String customerNIC;
    String driverNic;
    Double cost;
    String vehicleNumber;
    Date currentDate;
}
