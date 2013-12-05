package timelineme.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import timelineme.dao.PersistenceException;
import timelineme.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {

	LoginService loginService = new LoginService();

	@RequestMapping("/auth")
	public ModelAndView authenticate(HttpServletRequest request, HttpSession session) throws PersistenceException {
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		ModelAndView dispatch = null;
		session.setAttribute("username", username);
		if (loginService.authenticate(username, password)) {
			// Se agrega "username a la sesión"
			session.setAttribute("username", username);
			dispatch = new ModelAndView("welcome", "message", "Bienvenido, @" + username); 
		} else {
			dispatch = new ModelAndView("error", "message", "Ingreso incorrecto");
		}
		return dispatch;
	}
	
	@RequestMapping("/welcome")
	public ModelAndView welcome(HttpServletRequest request, HttpSession session) throws PersistenceException {
		String username = (String) session.getAttribute("username");
		ModelAndView dispatch = null;
		dispatch = new ModelAndView("welcome", "message", "Bienvenido, @" + username); 
		return dispatch;
	}

	@RequestMapping("/registrar")
	public ModelAndView registrar(HttpServletRequest request, HttpSession session) throws PersistenceException {
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		String empresa = (String) request.getParameter("empresa");
		ModelAndView dispatch = null;
		session.setAttribute("username", username);
		loginService.registrar(username, password, empresa);
		
		dispatch = new ModelAndView("welcome", "message", "Bienvenido, @" + username);
		
		return dispatch;
	}
	
}

