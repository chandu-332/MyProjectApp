package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IShipmentTypeDao;
import in.nit.model.ShipmentType;

@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao {

	@Autowired
	private HibernateTemplate ht;
	public Integer saveShipmentType(ShipmentType ob) {
		return (Integer)ht.save(ob);
	}
	public List<ShipmentType> getAllShipmentTypes(){
		return ht.loadAll(ShipmentType.class);
	}
	public void deleteShipmentType(Integer id) {
		ShipmentType s=new ShipmentType();
		s.setShipId(id);
		ht.delete(new ShipmentType(id));
	}
	public ShipmentType getOneShipmentType(Integer id) {
		return ht.get(ShipmentType.class, id);
	}
	@Override
	public void updateShipmentType(ShipmentType ob) {
		ht.update(ob);
	}
	public List<Object[]> getShipmentModeCount() {
		String hql="select shipMode,count(shipMode) from in.nit.model.ShipmentType  group by shipMode";
		return (List<Object[]>) ht.find(hql);
	}
}
