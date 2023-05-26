package lk.ijse.ikmanRental.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DriverPaymentDTO {
    String paymentID;
    String status;
    Double paymentCost;
    String DriverNic;
}
