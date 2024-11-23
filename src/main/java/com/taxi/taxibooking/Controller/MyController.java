package com.taxi.taxibooking.Controller;

import com.taxi.taxibooking.model.BookingForm;
import com.taxi.taxibooking.model.ContactForm;
import com.taxi.taxibooking.model.ServiceForm;
import com.taxi.taxibooking.service.BookingFormService;
import com.taxi.taxibooking.service.ContactFormService;
import com.taxi.taxibooking.service.ContactFormServiceImpl;
import com.taxi.taxibooking.service.ServiceFormService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private ContactFormService contactFormService;

    @Autowired
    private BookingFormService bookingFormService;

    @Autowired
    private ServiceFormService serviceFormService;

    @GetMapping(path = {"/","home","welcome","index"})
    public String welcomeView(HttpServletRequest req, Model model){
        String requestURI= req.getRequestURI();
        model.addAttribute("mycurrentpage",requestURI);
        model.addAttribute("bookingForm", new BookingForm());
        return "index";
    }

    @GetMapping(path = {"info","about"})
    public String aboutView(HttpServletRequest req, Model model){
        String requestURI= req.getRequestURI();
        model.addAttribute("mycurrentpage",requestURI);
        return "about";
    }
    @GetMapping(path = {"cars"})
    public String carsView(HttpServletRequest req, Model model){
        String requestURI= req.getRequestURI();
        model.addAttribute("mycurrentpage",requestURI);
        return "cars";
    }
    @GetMapping("services")
    public String servicesView(HttpServletRequest req, Model model){
        String requestURI= req.getRequestURI();
        model.addAttribute("mycurrentpage",requestURI);

        List<ServiceForm> allServices = serviceFormService.readAllServices();
        model.addAttribute("allservices",allServices);

        return "services";
    }

    @GetMapping("/login")
    public String adminLongView(HttpServletRequest request,Model model){
      ServletContext servletContext =  request.getServletContext();
      Object attribute = servletContext.getAttribute("logout");
      if(attribute instanceof Boolean){
          model.addAttribute("logout",attribute);
          servletContext.removeAttribute("logout");
      }
        return "adminlogin";
    }

    @GetMapping(path = {"phone","contacts"})
    public String contactsView(HttpServletRequest req, Model model){
        String requestURI= req.getRequestURI();
        model.addAttribute("mycurrentpage",requestURI);
        model.addAttribute("contactForm",new ContactForm());
        return "contacts";
    }

    @PostMapping("contactform")
    public String contactForm(@Valid @ModelAttribute ContactForm contactForm, RedirectAttributes redirectAttributes, BindingResult result, Model model){
        System.out.println(contactForm);

        if (result.hasErrors()){
            model.addAttribute("bindingResult",result);
            return "contacts";
        }
        ContactForm saved = contactFormService.saveContactFormService(contactForm);

        if (saved != null){
            redirectAttributes.addFlashAttribute("message","message sent successfully!");
        }else {
            redirectAttributes.addFlashAttribute("message","Something went wrong!");
        }

        return "redirect:/contacts";
    }


    @PostMapping("bookingform")
    public String bookingForm(@Valid @ModelAttribute BookingForm  bookingForm, RedirectAttributes redirectAttributes, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()){
            model.addAttribute("bindingResult",bindingResult);
            return "index";
        } else if (bookingForm.getAdult() + bookingForm.getChildren() > 4) {
            model.addAttribute("message","total numbers of adult and children cannot exceed 4");
            return "index";
        }
        BookingForm savedForm =   bookingFormService.saveBookingFormService(bookingForm);
        if (savedForm != null){
            redirectAttributes.addFlashAttribute("message","Taxi booked successfully");
        }else {
            redirectAttributes.addFlashAttribute("message","Something went wrong");

        }

        return "redirect:/index";
    }




}

