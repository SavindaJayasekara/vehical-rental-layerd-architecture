package lk.ijse.ikmanRental.dto;

public class SaveBookingDTO {
    private BookingDTO booking;
    private BillDTO bill;
    private DriverPaymentDTO driverPay;
    private DriverScheduleDTO driverSchedule;
    private BookingDetailDTO bookingDetail;

    public SaveBookingDTO() {
    }

    public SaveBookingDTO(BookingDTO booking, BillDTO bill, DriverPaymentDTO driverPay, DriverScheduleDTO driverSchedule, BookingDetailDTO bookingDetail) {
        this.booking = booking;
        this.bill = bill;
        this.driverPay = driverPay;
        this.driverSchedule = driverSchedule;
        this.bookingDetail = bookingDetail;
    }

    public BookingDTO getBooking() {
        return booking;
    }

    public void setBooking(BookingDTO booking) {
        this.booking = booking;
    }

    public BillDTO getBill() {
        return bill;
    }

    public void setBill(BillDTO bill) {
        this.bill = bill;
    }

    public DriverPaymentDTO getDriverPay() {
        return driverPay;
    }

    public void setDriverPay(DriverPaymentDTO driverPay) {
        this.driverPay = driverPay;
    }

    public DriverScheduleDTO getDriverSchedule() {
        return driverSchedule;
    }

    public void setDriverSchedule(DriverScheduleDTO driverSchedule) {
        this.driverSchedule = driverSchedule;
    }

    public BookingDetailDTO getBookingDetail() {
        return bookingDetail;
    }

    public void setBookingDetail(BookingDetailDTO bookingDetail) {
        this.bookingDetail = bookingDetail;
    }

    @Override
    public String toString() {
        return "SaveBookingDTO{" +
                "booking=" + booking +
                ", bill=" + bill +
                ", driverPay=" + driverPay +
                ", driverSchedule=" + driverSchedule +
                ", bookingDetail=" + bookingDetail +
                '}';
    }
}
