package timelineme.service;


import timelineme.model.Agente;
import timelineme.model.Empresa;
import timelineme.dao.AgenteDao;
import timelineme.dao.DaoFactory;
import timelineme.dao.EmpresaDao;
import timelineme.dao.PersistenceException;



public class LoginService {

	public Boolean authenticate(String username, String password) throws PersistenceException {
		Boolean retorno = false;
		Agente usuarioActual = findByName(username);
		if (usuarioActual == null) {
			retorno = false;
		} else {
			retorno = usuarioActual.getPassword().equals(password);
		}
		return retorno;		
	}
	
	public Agente findByName(String username) throws PersistenceException{
		AgenteService personaSvc = new AgenteService();
		return personaSvc.findByName(username);
		
	}

	public void registrar(String username, String password, String nombreEmpresa) throws PersistenceException {
		Agente agente = new Agente();
		
		EmpresaDao miEmpresaDao = DaoFactory.getEmpresaDao();
		Empresa empresa = miEmpresaDao.findByName(nombreEmpresa);
		
		agente.setEmpresa(empresa);
		
		AgenteDao miAgenteDao = DaoFactory.getAgenteDao();
		Integer id = miAgenteDao.getMaxId();
		agente.setId(id+1);
		
		miAgenteDao.saveAgente(agente);
	}
	
}