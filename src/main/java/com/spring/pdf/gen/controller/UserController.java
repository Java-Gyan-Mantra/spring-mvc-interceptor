package com.spring.pdf.gen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.pdf.gen.model.User;
import com.spring.pdf.gen.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * Handle request to download a PDF document
	 */
	@RequestMapping(value = "/downloadPDF", method = RequestMethod.GET)
	public ModelAndView downloadExcel() {
		List<User> users = userService.getUsers();
		return new ModelAndView("pdfView", "users", users);
	}

}
