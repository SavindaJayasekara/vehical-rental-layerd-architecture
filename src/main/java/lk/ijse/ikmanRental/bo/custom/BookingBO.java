package lk.ijse.ikmanRental.bo.custom;

import lk.ijse.ikmanRental.bo.SuperBO;
import lk.ijse.ikmanRental.dto.*;

import java.sql.SQLException;
import java.util.List;

public interface BookingBO extends SuperBO {

    List<String> getBookingIDs() throws SQLException;

    List<BookingDTO> getAllBookings()throws SQLException;

    String getDriverNICFromDriverSchedul(String bookingID);

    String getVehicleNumberFromBookingDetail(String bookingID);

    String getNextBillIdFromBill()throws SQLException;

    String getNextIdFromDriverPayment()throws SQLException;

    String getNextBookingID ()throws SQLException;

    List<String> loadDriverNICFromDriver()throws SQLException;

    List<String> getAllCustomerNICFromCustomer()throws SQLException;

    boolean saveBooking(BookingDTO booking, BillDTO bill, DriverPaymentDTO driverPay, DriverScheduleDTO driverSchedule, BookingDetailDTO bookingDetail) throws SQLException;

    CustomerDTO getAllCustomerDetail(String customerNic);

    String getDriverGmail(String driverNic);

    VehicleDTO getFuelToKmFromVehicle(String vehicleNumber);

    Double getStatusFromDriver(String driverNic)throws SQLException;

    List<String> getAvailbleTypeFromVehicle(String type)throws SQLException;

    String getNameFromCustomer(String customerNic)throws SQLException;

    String getDriverNameFromDriver(String driverNic)throws SQLException;

    String getBillIdFromBill(String bookingID);

    String getPaymentIDFromDriverPayment(String driverNic);

    boolean update(BookingDTO booking, BillDTO bill, DriverPaymentDTO driverPay, DriverScheduleDTO driverSchedule, BookingDetailDTO bookingDetail) throws SQLException;

    boolean deleteBooking(String bookingID)throws SQLException;

    BookingDTO getAllBookingFromID(String bookingID);

    BookingDetailDTO getAllbookingDetail(String bookingId);

    DriverScheduleDTO getDriverScheduleFromId(String bookingID);

    BillDTO getBillFromID(String bookingID);

    DriverPaymentDTO getAllFromDriverPayment(String driverNIC);

    String getTypeFromDriver(String vehicleNumber) throws SQLException;

}
