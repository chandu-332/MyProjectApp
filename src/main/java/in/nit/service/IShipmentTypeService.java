package in.nit.service;

import java.util.List;

import in.nit.model.ShipmentType;

public interface IShipmentTypeService {
	Integer saveShipmentType(ShipmentType ob);
    List<ShipmentType> getAllShipmentTypes();
    public void deleteShipmentType(Integer id);
    ShipmentType getOneShipmentType(Integer id);
    void updateShipmentType(ShipmentType ob);
	List<Object[]> getShipmentModeCount();
 }