package timelineme.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import timelineme.model.Agente;
import timelineme.model.Empresa;

public class EmpresaDaoJdbcImpl implements EmpresaDao {

	private static EmpresaDao instance = new EmpresaDaoJdbcImpl();

	public static EmpresaDao getInstance() {
		return instance;
	}

	public List<Empresa> findAll() throws PersistenceException {
		List<Empresa> empresas = new LinkedList<Empresa>();
		try {
			String query = "select * from Empresa";
			PreparedStatement statement = ConnectionProvider.getInstance()
					.getConnection().prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				empresas.add(convertEmpresa(resultSet));
			}
		} catch (SQLException sqlException) {
			throw new PersistenceException(sqlException);
		}
		return empresas;
	}

	private Empresa convertAgente(ResultSet resultSet) throws SQLException, PersistenceException {
		Empresa empresa = new Empresa();
		
		/*agente.setId(resultSet.getInt("id_agente"));
		agente.setUsername(resultSet.getString("nombre"));
		agente.setPassword(resultSet.getString("password"));
		Empresa empresa = new Empresa();
		empresa.setId(resultSet.getInt("id_empresa"));
		empresa.setNombre(resultSet.getString("nombre"));
		agente.setEmpresa(empresa);

		try {
			String query = "select e.* from AgenteEmpresa ae inner join empresa e on e.id_empresa = ae.id_empresa where id_agente = ?";
			PreparedStatement statement = ConnectionProvider.getInstance()
					.getConnection().prepareStatement(query);
			statement.setInt(1, agente.getId());
			ResultSet resultSet2 = statement.executeQuery();
			while (resultSet2.next()) {
				agente.addEmpresa(convertEmpresa(resultSet2));
			}
		} catch (SQLException sqlException) {
			throw new PersistenceException(sqlException);
		}
		*/
		return empresa;
	}

	@Override
	public Empresa findById(Integer idEmpresa) throws PersistenceException {
		Empresa empresa = null;
		try {
			Connection c = ConnectionProvider.getInstance().getConnection();
			String query = "select * from empresa where id_empresa = ?";
			PreparedStatement statement = c.prepareStatement(query);
			statement.setInt(1, idEmpresa);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				empresa = convertEmpresa(resultSet);
			}
		} catch (SQLException sqlException) {
			throw new PersistenceException(sqlException);
		}
		return empresa;
	}

	private Empresa convertEmpresa(ResultSet resultSet) throws SQLException {
		Empresa empresa = new Empresa();

		empresa.setId(resultSet.getInt("id_empresa"));
		empresa.setNombre(resultSet.getString("nombre"));		
		
		return empresa;
	}

	@Override
	public Empresa findByName(String nombreEmpresa) throws PersistenceException {
		Empresa empresa = null;
		try {
			Connection c = ConnectionProvider.getInstance().getConnection();
			String query = "select * from Empresa where nombre = ?";
			PreparedStatement statement = c.prepareStatement(query);
			statement.setString(1, nombreEmpresa);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				empresa = convertEmpresa(resultSet);
			}
		} catch (SQLException sqlException) {
			throw new PersistenceException(sqlException);
		}
		return empresa;
	}

	/*@Override
	public Agente findByName(String agenteName) throws PersistenceException {
		if (agenteName == null) {
			throw new IllegalArgumentException(
					"El nombre de usuario no debe ser nulo");
		}
		Agente agente = null;
		try {
			Connection c = ConnectionProvider.getInstance().getConnection();
			String query = "select * from agente where nombre = ?";
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
	}*/

}
