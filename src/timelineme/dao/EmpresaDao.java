package timelineme.dao;

import java.util.List;

import timelineme.model.Empresa;

public interface EmpresaDao {
    
    //public Empresa findByName(String empresaName) throws PersistenceException;
    
    public List<Empresa> findAll() throws PersistenceException;

	public Empresa findById(Integer idEmpresa) throws PersistenceException;

	public Empresa findByName(String nombreEmpresa) throws PersistenceException;
    	
}
