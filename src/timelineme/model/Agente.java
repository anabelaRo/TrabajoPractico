package timelineme.model;

import java.util.List;

public class Agente {
	private Integer id;
	private String userName;
	private String password;
	private Empresa empresa;
	private List<Empresa> misEmpresas;

	public Agente() {
		super();
	}
	
	public void addEmpresa(Empresa empresa){
		this.misEmpresas.add(empresa);
	}
	
	public List<Empresa> getMisEmpresa() {
		return this.misEmpresas;
	}
	
	public void setMisEmpresas(List<Empresa> misEmpresas) {
		this.misEmpresas = misEmpresas;
	}
	
	public Empresa getEmpresa() {
		return this.empresa;
	}
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUsername() {
		return this.userName;
	}
	
	public void setUsername(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String string) {
		this.password = string;
	}

}
