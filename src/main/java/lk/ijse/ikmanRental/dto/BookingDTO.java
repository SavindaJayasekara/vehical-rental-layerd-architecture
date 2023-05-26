package lk.ijse.ikmanRental.dto;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookingDTO {
    String bookingID;
    String status;
    Double amountsCost;
    Date requiredDate;
    String rideTo;
    String distance;
    String customerNic;

   public java.util.Date getDate(){
        return requiredDate;
    }

    public void setStatus(String status){
       this.status=status;
    }

    public String getStatus(){
       return this.status;
    }
}
