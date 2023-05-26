package lk.ijse.ikmanRental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class VehicleOut {
    String vehicleNumber;
    String driverNic;
    Double distance;
    String bookingId;
}
