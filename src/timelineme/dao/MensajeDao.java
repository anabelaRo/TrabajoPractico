package timelineme.dao;

import java.util.List;

import timelineme.model.Empresa;
import timelineme.model.Mensaje;

public interface MensajeDao {
	public void saveMensaje(Mensaje mensaje) throws PersistenceException;

	public List<Mensaje> findMensajesByEmpresa(Empresa empresa) throws PersistenceException;
	
	public Integer getMaxId() throws PersistenceException;
}
