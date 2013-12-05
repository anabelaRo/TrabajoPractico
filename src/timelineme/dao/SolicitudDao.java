package timelineme.dao;

import java.util.List;

import timelineme.model.Agente;
import timelineme.model.Empresa;

public interface SolicitudDao {
    
    public List<Empresa> findEmpresasByAgente(Agente agente) throws PersistenceException;
    
    public List<Agente> findSeguidoresByEmpresa(Empresa empresa) throws PersistenceException;

	public void saveSolicitud(Empresa empresa, Agente agente) throws PersistenceException;
	
	public void deleteSolicitud(Empresa empresa, Agente agente) throws PersistenceException;
}
