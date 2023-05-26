package lk.ijse.ikmanRental.bo.custom.impl;

import lk.ijse.ikmanRental.bo.custom.BookingBO;
import lk.ijse.ikmanRental.dao.DAOFactory;
import lk.ijse.ikmanRental.dao.custom.BookingDAO;
import lk.ijse.ikmanRental.dto.*;

import java.sql.SQLException;
import java.util.List;

public class BookingBOImpl implements BookingBO {

    BookingDAO bookingDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BOOKING);


    @Override
    public List<String> getBookingIDs() throws SQLException {
        return  bookingDAO.getBookingIds();
    }

    @Override
    public List<BookingDTO> getAllBookings() throws SQLException {
        return null;
    }

    @Override
    public String getDriverNICFromDriverSchedul(String bookingID) {
        return null;
    }

    @Override
    public String getVehicleNumberFromBookingDetail(String bookingID) {
        return null;
    }

    @Override
    public String getNextBillIdFromBill() {
        return null;
    }

    @Override
    public String getNextIdFromDriverPayment() {
        return null;
    }

    @Override
    public String getNextBookingID() {
        return null;
    }

    @Override
    public List<String> loadDriverNICFromDriver() {
        return null;
    }

    @Override
    public List<String> getAllCustomerNICFromCustomer() {
        return null;
    }

    @Override
    public boolean saveBooking(BookingDTO booking, BillDTO bill, DriverPaymentDTO driverPay, DriverScheduleDTO driverSchedule, BookingDetailDTO bookingDetail) throws SQLException {
        return false;
    }

    @Override
    public CustomerDTO getAllCustomerDetail(String customerNic) {
        return null;
    }

    @Override
    public String getDriverGmail(String driverNic) {
        return null;
    }

    @Override
    public VehicleDTO getFuelToKmFromVehicle(String vehicleNumber) {
        return null;
    }

    @Override
    public Double getStatusFromDriver(String driverNic) {
        return null;
    }

    @Override
    public List<String> getAvailbleTypeFromVehicle(String type) {
        return null;
    }

    @Override
    public String getNameFromCustomer(String customerNic) {
        return null;
    }

    @Override
    public String getDriverNameFromDriver(String driverNic) {
        return null;
    }

    @Override
    public String getBillIdFromBill(String bookingID) {
        return null;
    }

    @Override
    public String getPaymentIDFromDriverPayment(String driverNic) {
        return null;
    }

    @Override
    public boolean update(BookingDTO booking, BillDTO bill, DriverPaymentDTO driverPay, DriverScheduleDTO driverSchedule, BookingDetailDTO bookingDetail) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteBooking(String bookingID) {
        return false;
    }

    @Override
    public BookingDTO getAllBookingFromID(String bookingID) {
        return null;
    }

    @Override
    public BookingDetailDTO getAllbookingDetail(String bookingId) {
        return null;
    }

    @Override
    public DriverScheduleDTO getDriverScheduleFromId(String bookingID) {
        return null;
    }

    @Override
    public BillDTO getBillFromID(String bookingID) {
        return null;
    }

    @Override
    public DriverPaymentDTO getAllFromDriverPayment(String driverNIC) {
        return null;
    }

    @Override
    public String getTypeFromDriver(String vehicleNumber) throws SQLException {
        return null;
    }
}
