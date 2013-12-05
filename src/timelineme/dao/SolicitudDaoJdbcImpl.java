package timelineme.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import timelineme.model.Agente;
import timelineme.model.Empresa;

public class SolicitudDaoJdbcImpl implements SolicitudDao {

	private static SolicitudDao instance = new SolicitudDaoJdbcImpl();

	public static SolicitudDao getInstance() {
		return instance;
	}
	
	@Override
	public List<Empresa> findEmpresasByAgente(Agente agente) throws PersistenceException {
		
		List<Empresa> misEmpresas = new LinkedList<Empresa>();
		try {
			Connection c = ConnectionProvider.getInstance().getConnection();
			String query = "select id_empresa from AgenteEmpresa where id_agente = ?";
			PreparedStatement statement = c.prepareStatement(query);
			statement.setInt(1, agente.getId());
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				misEmpresas.add(convertEmpresa(resultSet));
			}
		} catch (SQLException sqlException) {
			throw new PersistenceException(sqlException);
		}
		return misEmpresas;
	}
	
	private Empresa convertEmpresa(ResultSet resultSet) throws PersistenceException, SQLException {
		Empresa empresa = new Empresa();
		EmpresaDao miEmpresaDao = DaoFactory.getEmpresaDao();
		
		empresa = miEmpresaDao.findById(resultSet.getInt("id_empresa"));
		
		//List<Agente> seguidores = findSeguidoresByEmpresa(empresa);
		//empresa.setSeguidores(seguidores);
		
		return empresa;
	}

	@Override
	public List<Agente> findSeguidoresByEmpresa(Empresa empresa) throws PersistenceException {
		List<Agente> seguidores = new LinkedList<Agente>();
		try {
			Connection c = ConnectionProvider.getInstance().getConnection();
			String query = "select id_agente from AgenteEmpresa where id_empresa = ?";
			PreparedStatement statement = c.prepareStatement(query);
			statement.setInt(1, empresa.getId());
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				seguidores.add(convertAgente(resultSet));
			}
		} catch (SQLException sqlException) {
			throw new PersistenceException(sqlException);
		}
		return seguidores;
	}

	private Agente convertAgente(ResultSet resultSet) throws PersistenceException, SQLException {
		Agente agente = new Agente();
		
		AgenteDao miAgenteDao = DaoFactory.getAgenteDao();
		agente = miAgenteDao.findById(resultSet.getInt("id_agente"));
		
		return agente;
	}

	@Override
	public void saveSolicitud(Empresa empresa, Agente agente) throws PersistenceException {
		try {
			Connection c = ConnectionProvider.getInstance().getConnection();
			String query = "insert into AgenteEmpresa values (?,?)";
			PreparedStatement statement = c.prepareStatement(query);
			statement.setInt(1, agente.getId());
			statement.setInt(2, empresa.getId());
			c.setAutoCommit(true);
			statement.executeUpdate();
		} catch (SQLException sqlException) {
			throw new PersistenceException(sqlException);
		}
	}

	@Override
	public void deleteSolicitud(Empresa empresa, Agente agente) throws PersistenceException {
		try {
			Connection c = ConnectionProvider.getInstance().getConnection();
			String query = "delete from AgenteEmpresa where id_agente = ? and id_empresa = ?";
			PreparedStatement statement = c.prepareStatement(query);
			statement.setInt(1, agente.getId());
			statement.setInt(2, empresa.getId());
			c.setAutoCommit(true);
			statement.executeUpdate();
		} catch (SQLException sqlException) {
			throw new PersistenceException(sqlException);
		}
	}

}
