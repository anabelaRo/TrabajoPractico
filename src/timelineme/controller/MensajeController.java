package timelineme.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import timelineme.dao.PersistenceException;
import timelineme.model.Agente;
import timelineme.model.Mensaje;
import timelineme.service.AgenteService;
import timelineme.service.MensajeService;

@Controller
public class MensajeController {
	
	MensajeService mensajeService = new MensajeService();
	AgenteService agenteService = new AgenteService();
	
	@RequestMapping("/misMensajes")
	public ModelAndView getMisMensajes(HttpServletRequest request, HttpSession session) throws PersistenceException{
		
		ModelAndView dispatch = null;
		
		String username = (String)session.getAttribute("username");
		
		List<Mensaje> misMensajes = mensajeService.getMensajesByAgenteName(username);
		
		dispatch = new ModelAndView("misMensajes", "misMensajes", misMensajes);
		
		return dispatch;
	}
	
	@RequestMapping("/publicar")
	public ModelAndView publicar(HttpServletRequest request, HttpSession session) throws PersistenceException{
		ModelAndView dispatch = null;
		
		String username = (String)session.getAttribute("username");
		String contenido = (String) request.getParameter("contenido");
		
		Agente agente = agenteService.findByName(username);
		
		mensajeService.saveMensaje(contenido, agente.getEmpresa());
		
		dispatch = new ModelAndView("misMensajes");
		
		return dispatch;
	}

}
