package lk.ijse.ikmanRental.bo.custom;

import lk.ijse.ikmanRental.bo.SuperBO;
import lk.ijse.ikmanRental.dto.*;

import java.sql.SQLException;
import java.util.List;

public interface BookingBO extends SuperBO {

    List<String> getBookingIDs() throws SQLException;

    List<BookingDTO> getAllBookings()throws SQLException;

    String getDriverNICFromDriverSchedul(String bookingID) throws SQLException;

    String getVehicleNumberFromBookingDetail(String bookingID) throws SQLException;

    String getNextBillIdFromBill()throws SQLException;

    String getNextIdFromDriverPayment()throws SQLException;

    String getNextBookingID ()throws SQLException;

    List<String> loadDriverNICFromDriver()throws SQLException;

    List<String> getAllCustomerNICFromCustomer()throws SQLException;

    boolean saveBooking(BookingDTO booking, BillDTO bill, DriverPaymentDTO driverPay, DriverScheduleDTO driverSchedule, BookingDetailDTO bookingDetail) throws SQLException;

    CustomerDTO getAllCustomerDetail(String customerNic) throws SQLException;

    String getDriverGmail(String driverNic) throws SQLException;

    VehicleDTO getFuelToKmFromVehicle(String vehicleNumber) throws SQLException;

    Double getStatusFromDriver(String driverNic)throws SQLException;

    List<String> getAvailbleTypeFromVehicle(String type)throws SQLException;

    String getNameFromCustomer(String customerNic)throws SQLException;

    String getDriverNameFromDriver(String driverNic)throws SQLException;

    String getBillIdFromBill(String bookingID) throws SQLException;

    String getPaymentIDFromDriverPayment(String driverNic) throws SQLException;

    boolean update(BookingDTO booking, BillDTO bill, DriverPaymentDTO driverPay, DriverScheduleDTO driverSchedule, BookingDetailDTO bookingDetail) throws SQLException;

    boolean deleteBooking(String bookingID)throws SQLException;

    BookingDTO getAllBookingFromID(String bookingID) throws SQLException;

    BookingDetailDTO getAllbookingDetail(String bookingId) throws SQLException;

    DriverScheduleDTO getDriverScheduleFromId(String bookingID) throws SQLException;

    BillDTO getBillFromID(String bookingID) throws SQLException;

    DriverPaymentDTO getAllFromDriverPayment(String driverNIC) throws SQLException;

    String getTypeFromDriver(String vehicleNumber) throws SQLException;

}
