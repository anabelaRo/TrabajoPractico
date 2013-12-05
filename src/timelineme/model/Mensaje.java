package timelineme.model;

import java.util.Date;
import java.util.List;

public class Mensaje {
		private Integer idMensaje;
		private String contenido;
		private Date fecha;
		private Empresa empresa;

		public Integer getId() {
			return this.idMensaje;
		}
		
		public void setId(Integer idMensaje) {
			this.idMensaje = idMensaje;
		}
		
		
		public String getContenido() {
			return this.contenido;
		}
		
		public void setContenido(String contenido) {
			this.contenido = contenido;
		}
		
		
		
		public Date getFecha() {
			return this.fecha;
		}
		
		public void setFecha(Date string) {
			this.fecha = string;
		}
		
		public Empresa getEmpresa() {
			return this.empresa;
		}
		
		public void setEmpresa(Empresa empresa) {
			this.empresa = empresa;
		}

}
