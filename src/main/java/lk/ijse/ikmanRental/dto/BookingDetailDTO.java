package lk.ijse.ikmanRental.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class BookingDetailDTO {
    String bookingId;
    String vehicleNumber;
    Double fuel;
}
