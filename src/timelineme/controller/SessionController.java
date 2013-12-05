package timelineme.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import timelineme.model.Agente;
import timelineme.dao.PersistenceException;
import timelineme.service.AgenteService;


@Controller
@SessionAttributes("sValue")
@RequestMapping("/perfil")
public class SessionController {

//	LoginService loginService = new LoginService();
	AgenteService agenteService = new AgenteService();

	@RequestMapping("/inicio")
	
		// Pasamos como argumento HttpSession al m�todo que maneja el requerimiento

	public ModelAndView mainPage(HttpSession session) throws PersistenceException {
		ModelAndView mav = new ModelAndView("home"); 
		
		// Se recupera el atributo de la sesi�n
		String name = (String) session.getAttribute("username");
		
		// Se obtiene el usuario/persona logueado/a
		Agente miAgente = agenteService.findByName(name);
		
		// Se obtiene una lista de todos los usuarios/personas
		List<Agente> misAgentes = agenteService.findAll();
		
		// Se obtiene el Id �nico de sesi�n
		String sid = session.getId();
		
		// Colocamos algunos valores en la sesi�n del controlador		
        mav.addObject("sid", sid);  
        mav.addObject("name", name); 
        mav.addObject("miAgente", miAgente); 
        mav.addObject("misAgentes", misAgentes);
        String sValue = "Alg�n valor como String";  
	    mav.addObject("sValue", sValue);  
	    return mav;
	}

}
