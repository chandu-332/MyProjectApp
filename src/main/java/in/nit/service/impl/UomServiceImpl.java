package in.nit.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IUomDao;
import in.nit.model.Uom;
import in.nit.service.IUomService;
@Service
public class UomServiceImpl implements IUomService {
	@Autowired
	private IUomDao dao;
	@Transactional
	public Integer saveUom(Uom ob) {
		return dao.saveUom(ob);
	}
	@Transactional(readOnly=true)
	public List<Uom> getAllUoms() {

		List<Uom> list=dao.getAllUoms();
		Collections.sort(list,(o1,o2)->o1.getuId()-o2.getuId());
		return list;

	}
	@Override
	@Transactional
	public void deleteUom(Integer id) {
		dao.deleteUom(id);	
	}
	@Override
	@Transactional(readOnly=true)
	public Uom getOneUom(Integer id) {
		return dao.getOneUom(id);
	}
	@Transactional
	public void updateUom(Uom ob) {
		dao.updateUom(ob);
	}
	@Transactional
	public List<Object[]> getUomModeCount() {
		return dao.getUomModeCount();
	}
}

