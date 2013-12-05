package timelineme.model;

import java.util.List;

public class Empresa {
	private Integer id;
	private String nombre;
	private List<Mensaje> mensajes;
	private List<Agente> seguidores;
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Agente> getSeguidores(){
		return this.seguidores;
	}
	
	public void setSeguidores(List<Agente> seguidores){
		this.seguidores = seguidores;
	}
}
