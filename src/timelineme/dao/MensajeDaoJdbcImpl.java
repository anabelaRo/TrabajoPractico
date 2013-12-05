package timelineme.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import timelineme.model.Empresa;
import timelineme.model.Mensaje;

public class MensajeDaoJdbcImpl implements MensajeDao {
	
	private static MensajeDao instance = new MensajeDaoJdbcImpl();

	public static MensajeDao getInstance() {
		return instance;
	}

	@Override
	public void saveMensaje(Mensaje mensaje) throws PersistenceException {
		try {
			Connection c = ConnectionProvider.getInstance().getConnection();
			String query = "insert into Mensaje values (?,?,?,?)";
			PreparedStatement statement = c.prepareStatement(query);
			statement.setInt(1, mensaje.getId());
			statement.setString(2, mensaje.getContenido());
			statement.setInt(3, mensaje.getEmpresa().getId());
			statement.setString(4, mensaje.getFecha().toString());
			c.setAutoCommit(true);
			statement.executeUpdate(query);
		} catch (SQLException sqlException) {
			throw new PersistenceException(sqlException);
		}
	}

	@Override
	public List<Mensaje> findMensajesByEmpresa(Empresa empresa) throws PersistenceException {
		List<Mensaje> misMensajes = new LinkedList<Mensaje>();
		try {
			Connection c = ConnectionProvider.getInstance().getConnection();
			String query = "select * from Mensaje where id_empresa = ?";
			PreparedStatement statement = c.prepareStatement(query);
			statement.setInt(1, empresa.getId());
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Mensaje miMensaje = convertMensaje(resultSet);
				miMensaje.setEmpresa(empresa);
				misMensajes.add(miMensaje);
			}
		} catch (SQLException sqlException) {
			throw new PersistenceException(sqlException);
		}
		return misMensajes;
	}

	private Mensaje convertMensaje(ResultSet resultSet) throws SQLException {
		Mensaje miMensaje = new Mensaje();
		
		miMensaje.setContenido(resultSet.getString("contenido"));
		miMensaje.setId(resultSet.getInt("id_mensaje"));
		miMensaje.setFecha(resultSet.getDate("fecha"));
		
		return miMensaje;
	}

	@Override
	public Integer getMaxId() throws PersistenceException {
		Integer id = null;
		
		try {
			Connection c = ConnectionProvider.getInstance().getConnection();
			String query = "select MAX(id_mensaje) as maxId from Mensaje;";
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
