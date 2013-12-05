package timelineme.dao;

import java.util.List;

import timelineme.model.Agente;

public interface AgenteDao {
    
    public Agente findByName(String agenteName) throws PersistenceException;
    
    public List<Agente> findAll() throws PersistenceException;
    
    public Agente findById(Integer idAgente) throws PersistenceException;

	public void saveAgente(Agente agente) throws PersistenceException;

	public Integer getMaxId() throws PersistenceException;
}
