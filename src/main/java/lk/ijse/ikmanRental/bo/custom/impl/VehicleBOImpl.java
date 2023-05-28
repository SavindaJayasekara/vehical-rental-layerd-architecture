package lk.ijse.ikmanRental.bo.custom.impl;

import lk.ijse.ikmanRental.bo.custom.VehicleBO;
import lk.ijse.ikmanRental.dao.DAOFactory;
import lk.ijse.ikmanRental.dao.custom.VehicleDAO;
import lk.ijse.ikmanRental.dto.VehicleDTO;
import lk.ijse.ikmanRental.entity.Vehicle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleBOImpl implements VehicleBO {
    VehicleDAO vehicleDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.VEHICLE);
    @Override
    public List<String> loadVehicleNumbers() throws SQLException {
        return vehicleDAO.loadNumbers();
    }

    @Override
    public List<VehicleDTO> getAll() throws SQLException {
        List<Vehicle> allVehicle = vehicleDAO.getAll();
        List<VehicleDTO> vehicleDTOS=new ArrayList<>();
        for (Vehicle vehicle:allVehicle){
            vehicleDTOS.add(new VehicleDTO(vehicle.getVehicleNumber(),vehicle.getName(),vehicle.getType(),vehicle.getFuelToKm(),vehicle.getKmh(),vehicle.getAvailability(),vehicle.getStatus(),vehicle.getCondition()));
        }
        return vehicleDTOS;
    }

    @Override
    public boolean saveVehicle(VehicleDTO vehicle) throws SQLException {
        return vehicleDAO.save(new Vehicle(vehicle.getVehicleNumber(),vehicle.getName(),vehicle.getType(),vehicle.getFuelToKm(),vehicle.getKmh(),vehicle.getAvailability(),vehicle.getStatus(),vehicle.getCondition()));
    }

    @Override
    public boolean deleteVehicle(String number) throws SQLException {
        return vehicleDAO.delete(number);
    }

    @Override
    public boolean updateVehicle(VehicleDTO vehicleDTO) throws SQLException {
        return vehicleDAO.update(new Vehicle(vehicleDTO.getVehicleNumber(),vehicleDTO.getName(),vehicleDTO.getType(),vehicleDTO.getFuelToKm(),vehicleDTO.getKmh(),vehicleDTO.getAvailability(),vehicleDTO.getStatus(),vehicleDTO.getCondition()));
    }

    @Override
    public VehicleDTO getAllVehicle(String number) throws SQLException {
        Vehicle ides = vehicleDAO.getIdes(number);
        return new VehicleDTO(ides.getVehicleNumber(),ides.getName(),ides.getType(),ides.getFuelToKm(),ides.getKmh(),ides.getAvailability(),ides.getStatus(),ides.getCondition());
    }
}
