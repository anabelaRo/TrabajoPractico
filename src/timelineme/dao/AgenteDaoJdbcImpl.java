package timelineme.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import timelineme.model.Agente;
import timelineme.model.Empresa;

public class AgenteDaoJdbcImpl implements AgenteDao {

	private static AgenteDao instance = new AgenteDaoJdbcImpl();

	public static AgenteDao getInstance() {
		return instance;
	}

	public List<Agente> findAll() throws PersistenceException {
		List<Agente> agentes = new LinkedList<Agente>();
		try {
			String query = "select * from Agente";
			PreparedStatement statement = ConnectionProvider.getInstance()
					.getConnection().prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				agentes.add(convertAgente(resultSet));
			}
		} catch (SQLException sqlException) {
			throw new PersistenceException(sqlException);
		}
		return agentes;
	}

	private Agente convertAgente(ResultSet resultSet) throws SQLException, PersistenceException {
		Agente agente = new Agente();
		
		agente.setId(resultSet.getInt("id_agente"));
		agente.setUsername(resultSet.getString("username"));
		agente.setPassword(resultSet.getString("password"));
		
		EmpresaDao miEmpresaDao = DaoFactory.getEmpresaDao();		
		agente.setEmpresa(miEmpresaDao.findById(resultSet.getInt("id_empresa")));
		
		//SolicitudDao miSolicitudDao = DaoFactory.getSolicitudDao();		
		//List<Empresa> misEmpresas = miSolicitudDao.findEmpresasByAgente(agente);		
		//agente.setMisEmpresas(misEmpresas);
		
		return agente;
	}

	private Empresa convertEmpresa(ResultSet resultSet2) throws SQLException {
		Empresa empresa = new Empresa();

		empresa.setId(resultSet2.getInt("id"));
		empresa.setNombre(resultSet2.getString("nombre"));		
		
		return empresa;
	}

	@Override
	public Agente findByName(String agenteName) throws PersistenceException {
		if (agenteName == null) {
			throw new IllegalArgumentException(
					"El nombre de usuario no debe ser nulo");
		}
		Agente agente = null;
		try {
			Connection c = ConnectionProvider.getInstance().getConnection();
			String query = "select * from agente where username = ?";
			PreparedStatement statement = c.prepareStatement(query);
			statement.setString(1, agenteName);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				agente = convertAgente(resultSet);
			}
		} catch (SQLException sqlException) {
			throw new PersistenceException(sqlException);
		}
		return agente;
	}

	@Override
	public Agente findById(Integer idAgente) throws PersistenceException {
		Agente agente = null;
		try {
			Connection c = ConnectionProvider.getInstance().getConnection();
			String query = "select * from agente where id_agente = ?";
			PreparedStatement statement = c.prepareStatement(query);
			statement.setInt(1, idAgente);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				agente = convertAgente(resultSet);
			}
		} catch (SQLException sqlException) {
			throw new PersistenceException(sqlException);
		}
		return agente;
	}

	@Override
	public void saveAgente(Agente agente) throws PersistenceException {
		try {
			Connection c = ConnectionProvider.getInstance().getConnection();
			String query = "insert into agente values (?,?,?,?)";
			PreparedStatement statement = c.prepareStatement(query);
			statement.setInt(1, agente.getId());
			statement.setInt(1, agente.getEmpresa().getId());
			statement.setString(1, agente.getUsername());
			statement.setString(1, agente.getPassword());
			c.setAutoCommit(true);
			statement.executeUpdate();
		} catch (SQLException sqlException) {
			throw new PersistenceException(sqlException);
		}
	}

	@Override
	public Integer getMaxId() throws PersistenceException {
Integer id = null;
		
		try {
			Connection c = ConnectionProvider.getInstance().getConnection();
			String query = "select MAX(id_agente) as maxId from Agente;";
			PreparedStatement statement = c.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				id = resultSet.getInt("maxId");
			}
		} catch (SQLException sqlException) {
			throw new PersistenceException(sqlException);
		}
		
		return id;
	}

}
