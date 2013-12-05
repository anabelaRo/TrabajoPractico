package timelineme.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import timelineme.dao.PersistenceException;
import timelineme.model.Empresa;
import timelineme.model.Mensaje;
import timelineme.service.AgenteService;
import timelineme.service.EmpresaService;
import timelineme.service.LoginService;
import timelineme.service.MensajeService;

@Controller
public class AgenteController {

	EmpresaService empresaService = new EmpresaService();
	AgenteService agenteService = new AgenteService();
	MensajeService mensajeService = new MensajeService();
	
	@RequestMapping("/empresas")
	public ModelAndView getEmpresas(HttpServletRequest request, HttpSession session) throws PersistenceException {
		ModelAndView dispatch = null;
		
		List<Empresa> empresas = empresaService.findAll();
		
		dispatch = new ModelAndView("empresas", "empresas", empresas);
		
		return dispatch;
	}
	
	@RequestMapping("/misEmpresas")
	public ModelAndView getMisEmpresas(HttpServletRequest request, HttpSession session) throws PersistenceException {
		ModelAndView dispatch = null;
		String username = (String) session.getAttribute("username");
		List<Empresa> empresas = agenteService.findMisEmpresas(username);
		
		dispatch = new ModelAndView("misEmpresas", "empresas", empresas);
		
		return dispatch;
	}
	
	@RequestMapping("/seguir")
	public ModelAndView seguir(HttpServletRequest request, HttpSession session) throws PersistenceException {
		ModelAndView dispatch = null;
		
		Integer idEmpresa = Integer.parseInt(request.getParameter("idEmpresa"));
		String username = (String) session.getAttribute("username");
		
		agenteService.saveSolicitud(idEmpresa, username);
		
		dispatch = new ModelAndView("welcome", "message", "Bienvenido, @" + username);
		
		return dispatch;
	}
	
	@RequestMapping("/publicaciones")
	public ModelAndView publicaciones(HttpServletRequest request, HttpSession session) throws PersistenceException {
		ModelAndView dispatch = null;
		
		Integer idEmpresa = Integer.parseInt(request.getParameter("idEmpresa"));
		String username = (String) session.getAttribute("username");
		
		
		List<Mensaje> mensajes = mensajeService.findMensajesByEmpresa(idEmpresa);
		agenteService.saveSolicitud(idEmpresa, username);
		
		dispatch = new ModelAndView("publicaciones", "mensajes", mensajes);
		
		return dispatch;
	}
	
}
