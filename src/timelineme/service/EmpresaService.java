package timelineme.service;

import java.util.List;

import timelineme.dao.DaoFactory;
import timelineme.dao.EmpresaDao;
import timelineme.dao.PersistenceException;
import timelineme.model.Empresa;

public class EmpresaService {

	public List<Empresa> findAll() throws PersistenceException {
		EmpresaDao miEmpresaDao = DaoFactory.getEmpresaDao();
		
		return miEmpresaDao.findAll();
	}

}
