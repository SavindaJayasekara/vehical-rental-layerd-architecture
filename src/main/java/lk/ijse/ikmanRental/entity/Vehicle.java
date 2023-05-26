package lk.ijse.ikmanRental.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Vehicle {
    String vehicleNumber;
    String name;
    String type;
    double fuelToKm;
    int kmh;
    String availability;
    String status;
    String condition;
}
