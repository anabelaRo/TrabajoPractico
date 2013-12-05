package timelineme.service;

import java.util.List;

import timelineme.model.Agente;
import timelineme.model.Empresa;
import timelineme.dao.DaoFactory;
import timelineme.dao.EmpresaDao;
import timelineme.dao.PersistenceException;
import timelineme.dao.AgenteDao;
import timelineme.dao.SolicitudDao;

public class AgenteService {

	public Agente findByName(String username) throws PersistenceException {
	
		AgenteDao miAgenteDao = DaoFactory.getAgenteDao();
		Agente miAgente = miAgenteDao.findByName(username);
		return miAgente;
	}

	public List<Agente> findAll() throws PersistenceException {
		AgenteDao miAgenteDao = DaoFactory.getAgenteDao();
		return miAgenteDao.findAll();

	}

	public void saveSolicitud(Integer idEmpresa, String username) throws PersistenceException {
		EmpresaDao miEmpresaDao = DaoFactory.getEmpresaDao();
		Empresa empresa = miEmpresaDao.findById(idEmpresa);
		
		Agente agente = findByName(username);
		
		SolicitudDao miSolicitudDao = DaoFactory.getSolicitudDao();
		miSolicitudDao.saveSolicitud(empresa, agente);
	}

	public List<Empresa> findMisEmpresas(String agenteName) throws PersistenceException {
		AgenteDao miAgenteDao = DaoFactory.getAgenteDao();
		Agente agente = miAgenteDao.findByName(agenteName);
		
		SolicitudDao miSolicitudDao = DaoFactory.getSolicitudDao();
		return miSolicitudDao.findEmpresasByAgente(agente);
	}
}
