package lk.ijse.ikmanRental.bo;

import lk.ijse.ikmanRental.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){}

    public static BOFactory getInstance(){
        return boFactory==null ? new BOFactory() : boFactory;
    }

    public enum BOTypes{
        ADMIN,BOOKING,CUSTOMER,DRIVER,HOME,LOGIN,OTPVERIFY,VEHICLE
    }

    public <T extends SuperBO>T getBO(BOTypes boTypes){
        switch (boTypes){
            case ADMIN:
                return (T) new AdminBOImpl();
            case BOOKING:
                return (T) new BookingBOImpl();
            case CUSTOMER:
                return (T) new CustomerBOImpl();
            case DRIVER:
                return (T) new DriverBOImpl();
            case HOME:
                return (T) new HomeBOImpl();
            case LOGIN:
                return (T) new LogInBOImpl();
            case OTPVERIFY:
                return (T) new OTPVerifyBOImpl();
            case VEHICLE:
                return (T) new VehicleBOImpl();
            default:
                return null;
        }
    }
}
