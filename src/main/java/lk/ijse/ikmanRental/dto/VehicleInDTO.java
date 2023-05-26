package lk.ijse.ikmanRental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@AllArgsConstructor
@Data
public class VehicleInDTO {
    String vehicleNumber;
    String driverNic;
    Date date;
    String bookingId;
}
