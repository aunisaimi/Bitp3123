package my.edu.utem.ftmk.dad.restoredrapp.controller;

import java.util.List;
import java.util.Arrays;
import java.util.Map;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;


import my.edu.utem.ftmk.dad.restoredrapp.model.OrderType;

//import org.springframework.web.bind.annotation.PathVariable;



//import org.springframework.Controller;

@Controller
public class OrderTypeMenuController 
{
	private String defaultURI = "http://localhost:8080/orderapp/api/ordertypes";	
//	private ResponseEntity<HttpStatus> OrderTypes;
	
	@GetMapping("/ordertype/list")
	public String getOrderTypes(Model model) {
		
		// The URI for GET order types
			String uri = "http://localhost:8080/orderapp/api/ordertypes";
			
			//Get a list order types from the web service
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<OrderType[]> response = restTemplate.getForEntity(uri, OrderType[].class);
			
			// Parse JSON data to array of object
			OrderType orderTypes[] = response.getBody();
			
			// Parse an array to a list object
			List<OrderType> orderTypeList = Arrays.asList(orderTypes);
			
			// Attach list to model as attribute
			model.addAttribute("orderTypes",orderTypeList);
			
			return "ordertypes";
		
		
		
		
	}
	
	/**
	 * This method will update or add an order type.
	 * 
	 * @param orderType
	 * @return
	 */
	@RequestMapping("/ordertype/save")
	public String updateOrderType(@ModelAttribute OrderType orderType)
	{
		// Create new template 
		RestTemplate restTemplate = new RestTemplate();
		
		// Create request body
		HttpEntity<OrderType> request = new HttpEntity<OrderType>(orderType);
		
		String orderTypeResponse = "";
		
		if (orderType.getOrderTypeId()>0) {
			// This Block update a new order type and
			
			// send Request as PUT
			restTemplate.put(defaultURI, request, OrderType.class);
		}
		else {
			// this block add a new order type
			
			// send request as POST 
			orderTypeResponse = restTemplate.postForObject(defaultURI, request, String.class);
		}
		System.out.println(orderTypeResponse);
		
		//Redirect request to display a list of order type
		return "redirect:/ordertype/list";
	}
	
	/**
	 * This method gets an order type
	 * 
	 * @param orderTypeId
	 * @param model
	 * @return
	 */
	@GetMapping("/ordertype/{orderTypeId}")
	public String getOrderType (@PathVariable Integer orderTypeId, Model model)
	{
		
		String pageTitle = "New Order Type";
		OrderType orderType = new OrderType();
		
		//This block get an order type to be updated
		if (orderTypeId > 0)
		{
			
			//Generate new URI and append orderTypeIf to it
			String uri = defaultURI + "/" + orderTypeId;
			
			// Get an order type from the web service
			RestTemplate restTemplate = new RestTemplate();
			orderType = restTemplate.getForObject(uri, OrderType.class);
			
			// Give new title to the page
			pageTitle = "Edit Order Type";
		}
		
		// Attach value to pass to front end
		model.addAttribute("orderType", orderType);
		model.addAttribute("pageTitle", pageTitle);
		
		return "ordertypeinfo";
	}
}

