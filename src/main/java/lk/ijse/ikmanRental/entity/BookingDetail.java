package lk.ijse.ikmanRental.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class BookingDetail {
    String bookingId;
    String vehicleNumber;
    Double fuel;
}
