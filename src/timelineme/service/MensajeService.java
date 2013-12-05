package timelineme.service;

import java.util.Date;
import java.util.List;

import timelineme.dao.AgenteDao;
import timelineme.dao.DaoFactory;
import timelineme.dao.EmpresaDao;
import timelineme.dao.MensajeDao;
import timelineme.dao.PersistenceException;
import timelineme.model.Agente;
import timelineme.model.Empresa;
import timelineme.model.Mensaje;

public class MensajeService {

	public List<Mensaje> getMensajesByAgenteName(String agenteName) throws PersistenceException {

		MensajeDao miMensajeDao = DaoFactory.getMensajeDao();
		AgenteDao miAgenteDao = DaoFactory.getAgenteDao();
		
		Agente agente = miAgenteDao.findByName(agenteName);
		
		List<Mensaje> misMensajes = miMensajeDao.findMensajesByEmpresa(agente.getEmpresa());
		
		return misMensajes;
	}

	public void saveMensaje(String contenido, Empresa empresa) throws PersistenceException {

		MensajeDao miMensajeDao = DaoFactory.getMensajeDao();
		
		Mensaje mensaje = new Mensaje();
		
		Integer id = miMensajeDao.getMaxId();
		
		mensaje.setId(id+1);
		mensaje.setContenido(contenido);
		mensaje.setEmpresa(empresa);
		mensaje.setFecha(new Date());
		
		miMensajeDao.saveMensaje(mensaje);
	}

	public List<Mensaje> findMensajesByEmpresa(Integer idEmpresa) throws PersistenceException {
		EmpresaDao miEmpresaDao = DaoFactory.getEmpresaDao();
		Empresa empresa = miEmpresaDao.findById(idEmpresa);
		
		MensajeDao miMensajeDao = DaoFactory.getMensajeDao();
		return miMensajeDao.findMensajesByEmpresa(empresa);
	}

}
