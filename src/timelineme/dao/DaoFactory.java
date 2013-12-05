package timelineme.dao;

public class DaoFactory {

	public static AgenteDao getAgenteDao(){
		return AgenteDaoJdbcImpl.getInstance();
	}

	public static EmpresaDao getEmpresaDao() {
		return EmpresaDaoJdbcImpl.getInstance();
	}

	public static SolicitudDao getSolicitudDao() {
		return SolicitudDaoJdbcImpl.getInstance();
	}

	public static MensajeDao getMensajeDao() {
		return MensajeDaoJdbcImpl.getInstance();
	}

}
