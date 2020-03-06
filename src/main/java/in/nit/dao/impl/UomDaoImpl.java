package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IUomDao;
import in.nit.model.ShipmentType;
import in.nit.model.Uom;

@Repository
public class UomDaoImpl implements IUomDao {

	@Autowired
	private HibernateTemplate ht;
	public Integer saveUom(Uom ob) {
		return (Integer)ht.save(ob);
	}
	public List<Uom> getAllUoms(){
		return ht.loadAll(Uom.class);
	}
	public void deleteUom(Integer id) {
		 ht.delete(new Uom(id));
	}
	public Uom getOneUom(Integer id) {
		return ht.get(Uom.class, id);
	}
	@Override
	public void updateUom(Uom ob) {
		ht.update(ob);
	}
	public List<Object[]> getShipmentModeCount() {
		String hql="select shipMode,count(shipMode) from in.nit.model.Uom  group by shipMode";
		return (List<Object[]>) ht.find(hql);
	}
	@Override
	public List<Object[]> getUomModeCount() {
		// TODO Auto-generated method stub
		return null;
	}
}
