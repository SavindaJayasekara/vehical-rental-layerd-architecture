package lk.ijse.ikmanRental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@AllArgsConstructor
@Data
public class VehicleIn {
    String vehicleNumber;
    String driverNic;
    Date date;
    String bookingId;
}
