package gov.va.escreening.controller;

import gov.va.escreening.security.CurrentUser;
import gov.va.escreening.security.EscreenUser;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/dashboard")
public class SystemConfigurationController {

	private static final Logger logger = LoggerFactory.getLogger(SystemConfigurationController.class);

	@RequestMapping(value = "/systemConfiguration", method = RequestMethod.GET)
	public ModelAndView login(Locale locale, Model model) {
		logger.trace("In systemConfiguration");
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("systemConfiguration");
		return modelAndView;
	}

	@RequestMapping(value = "/sessionTimeout", method = RequestMethod.GET)
	@ResponseBody
	public int getSessionTimeout(HttpServletRequest request,
			@CurrentUser EscreenUser escreenUser) {
		logger.trace("returning sessionTimeout");
		return request.getSession(false).getMaxInactiveInterval();
	}

	@RequestMapping(value = "/requestHrtBeat", method = RequestMethod.GET)
	@ResponseBody
	public String requestHrtBeat(HttpServletRequest request,
			@CurrentUser EscreenUser escreenUser) {
		logger.trace("returning requestHrtBeat");
		HttpSession session = request.getSession(false);
		if (session!=null) {
			return String.format("session id %s returned at %s", session.getId(), ISODateTimeFormat.dateTime().print(new DateTime()));
		} else {
			return String.format("out of session at %s", ISODateTimeFormat.dateTime().print(new DateTime()));
		}
	}
}
