package com.prasant.spring.mvc.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.prasant.spring.mvc.model.Offer;
import com.prasant.spring.mvc.service.OfferService;

@Controller
public class OffersController {

	/*@RequestMapping("/")
	public String showHome(HttpSession session) {
		session.setAttribute("name", "Shaktimaan....");
		return "home";
	}*/
	
	/*@RequestMapping("/")
	public ModelAndView showHome() {
		ModelAndView mv = new ModelAndView();
		Map<String, Object> map = mv.getModel();
		map.put("name", "Kallu Ram");
		mv.setViewName("home");
		return mv;
	}*/
	
	/*@RequestMapping("/")
	public String showHome(Model model) {
		model.addAttribute("name", "Halla bol");
		return "home";
	}*/
	
	@Autowired
	private OfferService offerService;
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String test(@RequestParam("id") String id) {
		System.out.println("Id = " + id);
		return "home";
	}
	
	@RequestMapping("/offers")
	public String showOffers(Model model) {
		
		//offerService.throwTestException();
		
		List<Offer> offers = offerService.getOffers();
		model.addAttribute("offers", offers);
		return "offers";
	}
	
	@RequestMapping("/createoffer")
	public String createOffer(Model model) {
		model.addAttribute("offer", new Offer());
		return "createoffer";
	}
	
	@RequestMapping(value="/offercreated", method=RequestMethod.POST)
	public String offerCreated(Model model, @Valid Offer offer, BindingResult bindingResult) {
		/*if (bindingResult.hasErrors()) {
			List<ObjectError> errors = bindingResult.getAllErrors();
			for (ObjectError oe : errors) {
				System.out.println(oe.getDefaultMessage());
			}
			return "createoffer";
		}*/
		if (bindingResult.hasErrors()) {
			return "createoffer";
		}
		offerService.createOffer(offer);
		return "offercreated";
	}
	
	/*@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseException(DataAccessException e, Model model) {
		model.addAttribute("errorMsg", "Error - " + e.getMessage());
		return "error";
	}*/
	
}
