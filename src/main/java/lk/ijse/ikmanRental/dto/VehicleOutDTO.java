package lk.ijse.ikmanRental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class VehicleOutDTO {
    String vehicleNumber;
    String driverNic;
    Double distance;
    String bookingId;
}
