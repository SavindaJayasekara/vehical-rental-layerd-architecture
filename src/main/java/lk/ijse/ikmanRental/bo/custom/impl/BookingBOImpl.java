package lk.ijse.ikmanRental.bo.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.ikmanRental.bo.custom.BookingBO;
import lk.ijse.ikmanRental.dao.DAOFactory;
import lk.ijse.ikmanRental.dao.custom.*;
import lk.ijse.ikmanRental.db.DBConnection;
import lk.ijse.ikmanRental.dto.*;
import lk.ijse.ikmanRental.entity.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingBOImpl implements BookingBO {

    private final BookingDAO bookingDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BOOKING);
    private final DriverScheduleDAO driverScheduleDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.DRIVERSCHEDULE);
    private final BookingDetailDAO detailDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BOOKINGDETAIL);
    private final BillDAO billDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BILL);
    private final DriverPaymentDAO paymentDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.DRIVERPAYMENT);
    private final DriverDAO driverDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.DRIVER);
    private final CustomerDAO customerDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    private final VehicleDAO vehicleDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.VEHICLE);


    @Override
    public List<String> getBookingIDs() throws SQLException {
        return  bookingDAO.getBookingIds();
    }

    @Override
    public List<BookingDTO> getAllBookings() throws SQLException {
        List<BookingDTO>bookingDTOS=new ArrayList<>();
        List<Booking> allBookings = bookingDAO.getAll();
        for (Booking booking : allBookings){
            bookingDTOS.add(new BookingDTO(booking.getBookingID(),booking.getStatus(),booking.getAmountsCost(),booking.getRequiredDate(),booking.getRideTo(),booking.getDistance(),booking.getCustomerNic()));
        }
        return bookingDTOS;
    }

    @Override
    public String getDriverNICFromDriverSchedul(String bookingID) throws SQLException {
        return driverScheduleDAO.getDriverNic(bookingID);
    }

    @Override
    public String getVehicleNumberFromBookingDetail(String bookingID) throws SQLException {
        return detailDAO.getVehicleNumber(bookingID);
    }

    @Override
    public String getNextBillIdFromBill() throws SQLException {
        return billDAO.getNextID();
    }

    @Override
    public String getNextIdFromDriverPayment() throws SQLException {
        return paymentDAO.getnextID();
    }

    @Override
    public String getNextBookingID() throws SQLException {
        return bookingDAO.getNextBookingID();
    }

    @Override
    public List<String> loadDriverNICFromDriver() throws SQLException {
        return driverDAO.loadNic();
    }

    @Override
    public List<String> getAllCustomerNICFromCustomer() throws SQLException {
        return customerDAO.getCustomerNic();
    }

    @Override
    public boolean saveBooking(SaveBookingDTO saveBookingDTO) throws SQLException {
        // use customize DTO object
        BookingDTO booking=saveBookingDTO.getBooking();
        BillDTO bill=saveBookingDTO.getBill();
        DriverPaymentDTO driverPay=saveBookingDTO.getDriverPay();
        DriverScheduleDTO driverSchedule=saveBookingDTO.getDriverSchedule();
        BookingDetailDTO bookingDetail=saveBookingDTO.getBookingDetail();

//        transaction save
        Connection connection=null;
        try {
            connection=DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            if (!bookingDAO.save(new Booking(
                    booking.getBookingID(),
                    booking.getStatus(),
                    booking.getAmountsCost(),
                    booking.getRequiredDate(),
                    booking.getRideTo(),
                    booking.getDistance(),
                    booking.getCustomerNic()
            ))){
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            if (!billDAO.save(new Bill(
                    bill.getBillID(),
                    bill.getBookingID(),
                    bill.getCustomerNIC(),
                    bill.getDriverNic(),
                    bill.getCost(),
                    bill.getVehicleNumber(),
                    bill.getCurrentDate()
            ))){
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            if (!paymentDAO.save(new DriverPayment(driverPay.getPaymentID(),
                    driverPay.getStatus(),
                    driverPay.getPaymentCost(),
                    driverPay.getDriverNic()

            ))){
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            if (!vehicleDAO.updateAvailability(bookingDetail.getVehicleNumber())){
                connection.setAutoCommit(true);
                connection.rollback();
                return false;
            }

            if (!driverScheduleDAO.save(new DriverSchedule(
                    driverSchedule.getBookingID(),
                    driverSchedule.getDriverNic()
            ))){
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            if (!detailDAO.save(new BookingDetail(
                    bookingDetail.getBookingId(),
                    bookingDetail.getVehicleNumber(),
                    bookingDetail.getFuel()
            ))){
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            connection.commit();
            connection.setAutoCommit(true);
            return true;

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            return false;
        }finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public CustomerDTO getAllCustomerDetail(String customerNic) throws SQLException {
        Customer customer = customerDAO.getIdes(customerNic);
        return new CustomerDTO(customer.getNic(),customer.getGmail(),customer.getContact(),customer.getName(),customer.getAdminNic());
    }

    @Override
    public String getDriverGmail(String driverNic) throws SQLException {
        return driverDAO.getGmail(driverNic);
    }

    @Override
    public VehicleDTO getFuelToKmFromVehicle(String vehicleNumber) throws SQLException {
        Vehicle vehicle = vehicleDAO.getFuelToKm(vehicleNumber);
        return new VehicleDTO(vehicle.getVehicleNumber(),vehicle.getName(),vehicle.getType(),vehicle.getFuelToKm(),vehicle.getKmh(),vehicle.getAvailability(),vehicle.getStatus(),vehicle.getCondition());
    }

    @Override
    public Double getStatusFromDriver(String driverNic) throws SQLException {
        return driverDAO.getStatus(driverNic);
    }

    @Override
    public List<String> getAvailbleTypeFromVehicle(String type) throws SQLException {
        return vehicleDAO.getAvailbleType(type);
    }

    @Override
    public String getNameFromCustomer(String customerNic) throws SQLException {
        return customerDAO.getName(customerNic);
    }

    @Override
    public String getDriverNameFromDriver(String driverNic) throws SQLException {
        return driverDAO.getName(driverNic);
    }

    @Override
    public String getBillIdFromBill(String bookingID) throws SQLException {
        return billDAO.getBillid(bookingID);
    }

    @Override
    public String getPaymentIDFromDriverPayment(String driverNic) throws SQLException {
        return paymentDAO.getPaymentID(driverNic);
    }

    @Override
    public boolean update(BookingDTO booking, BillDTO bill, DriverPaymentDTO driverPay, DriverScheduleDTO driverSchedule, BookingDetailDTO bookingDetail) throws SQLException {
//        transaction update
        Connection connection=null;

        try {
            connection= DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            if (!bookingDAO.update(new Booking(
                    booking.getBookingID(),
                    booking.getStatus(),
                    booking.getAmountsCost(),
                    booking.getRequiredDate(),
                    booking.getRideTo(),
                    booking.getDistance(),
                    booking.getCustomerNic())))
            {
                connection.setAutoCommit(true);
                connection.rollback();
                return false;
            }

            if (!billDAO.update(new Bill(
                    bill.getBillID(),bill.getBookingID(),
                    bill.getCustomerNIC(),
                    bill.getDriverNic(),
                    bill.getCost(),
                    bill.getVehicleNumber(),
                    bill.getCurrentDate())))
            {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
            if (!paymentDAO.update(new DriverPayment(
                    driverPay.getPaymentID(),
                    driverPay.getStatus(),
                    driverPay.getPaymentCost(),
                    driverPay.getDriverNic())))
            {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
            if (!driverScheduleDAO.update(new DriverSchedule(
                    driverSchedule.getBookingID(),
                    driverSchedule.getDriverNic())))
            {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
            if (!detailDAO.update(new BookingDetail(
                    bookingDetail.getBookingId(),
                    bookingDetail.getVehicleNumber(),
                    bookingDetail.getFuel())))
            {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            connection.commit();
            connection.setAutoCommit(true);
            return true;

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            return false;
        }finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public boolean deleteBooking(String bookingID) throws SQLException {

        DriverSchedule scheduleDTO=driverScheduleDAO.getIdes(bookingID);
        BookingDetail bookingDetail=detailDAO.getIdes(bookingID);

//        transaction !
        Connection connection=null;
        try {
            connection=DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            if (!driverScheduleDAO.delete(bookingID))
            {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
            if (!detailDAO.delete(bookingID))
            {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
            if (!paymentDAO.delete(scheduleDTO.getDriverNic()))
            {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
            if (!bookingDAO.delete(bookingID))
            {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
            if (!vehicleDAO.updateAvailabilityDelete(bookingDetail.getVehicleNumber()))
            {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
            connection.commit();
            connection.setAutoCommit(true);
            return true;
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            return false;
        }finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public BookingDTO getAllBookingFromID(String bookingID) throws SQLException {
        Booking booking = bookingDAO.getIdes(bookingID);
        return new BookingDTO(booking.getBookingID(),booking.getStatus(),booking.getAmountsCost(),booking.getRequiredDate(),booking.getRideTo(),booking.getDistance(),booking.getCustomerNic());
    }

    @Override
    public BookingDetailDTO getAllbookingDetail(String bookingId) throws SQLException {
        BookingDetail bookingDetail = detailDAO.getIdes(bookingId);
        return new BookingDetailDTO(bookingDetail.getBookingId(),bookingDetail.getVehicleNumber(),bookingDetail.getFuel());
    }

    @Override
    public DriverScheduleDTO getDriverScheduleFromId(String bookingID) throws SQLException {
        DriverSchedule ides = driverScheduleDAO.getIdes(bookingID);
        return new DriverScheduleDTO(ides.getBookingID(),ides.getDriverNic());
    }

    @Override
    public BillDTO getBillFromID(String bookingID) throws SQLException {
        Bill bill = billDAO.getIdes(bookingID);
        return new BillDTO(bill.getBillID(),bill.getBookingID(),bill.getCustomerNIC(),bill.getDriverNic(),bill.getCost(),bill.getVehicleNumber(),bill.getCurrentDate());
    }

    @Override
    public DriverPaymentDTO getAllFromDriverPayment(String driverNIC) throws SQLException {
        DriverPayment payment = paymentDAO.getIdes(driverNIC);
        return new DriverPaymentDTO(payment.getPaymentID(),payment.getStatus(),payment.getPaymentCost(),payment.getDriverNic());
    }

    @Override
    public String getTypeFromDriver(String driverId) throws SQLException {
        return driverDAO.getType(driverId);
    }
}
