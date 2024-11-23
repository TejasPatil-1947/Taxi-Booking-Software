package com.taxi.taxibooking.Controller;

import com.taxi.taxibooking.model.ContactForm;
import com.taxi.taxibooking.model.ServiceForm;
import com.taxi.taxibooking.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private ContactFormService contactFormService;
    @Autowired
    private ContactFormServiceImpl contactFormServiceImpl;

    @Autowired
    private BookingFormService bookingFormService;
    @Autowired
    private AdminCredentialService adminCredentialService;

    @Autowired
    private ServiceFormService serviceFormService;
    @GetMapping("dashboard")
    public String adminDashboard(){
        return "admin/dashboard";
    }

    @GetMapping("readAllContacts")
    public String readAllContacts(Model model){
        model.addAttribute("allcontacts",contactFormService.readAllContactService());
        return "admin/readallcontacts";
    }


    @GetMapping("deleteContact/{id}")
    public String deleteContact(@PathVariable int id, RedirectAttributes redirectAttributes){
        contactFormServiceImpl.deleteContact(id);
        redirectAttributes.addFlashAttribute("message","Contact deleted successfully");
       return "redirect:/admin/readAllContacts";
    }

    @GetMapping("changeCredentials")
    public String changeCredentialsView(){
                return "/admin/changeCredentials";
    }


    @PostMapping("changeCredentials")
    public String changeCredentials(@RequestParam String oldusername,
                                    @RequestParam String oldpassword,
                                    @RequestParam String newusername,
                                    @RequestParam String newpassword,
                                    RedirectAttributes redirectAttributes
                                     ){

        String result =  adminCredentialService.checkAdminCredentials(oldusername,oldpassword);
       if(result.equals("SUCCESS")){
          result=  adminCredentialService.updateAdminCredentials(oldusername,newusername,newpassword);
          redirectAttributes.addFlashAttribute("message",result);
       }else {
            redirectAttributes.addFlashAttribute("message",result);
       }
        return "redirect:/admin/dashboard";
    }

    @GetMapping("readAllBookings")
    public String readAllBookings(Model model){
        model.addAttribute("allBookings",bookingFormService.readAllBookingService());
        return "admin/readallbookings";
    }

    @GetMapping("deleteBooking/{id}")
    public String deleteBooking(@PathVariable int id, RedirectAttributes redirectAttributes){
        bookingFormService.deleteBookingService(id);
        redirectAttributes.addFlashAttribute("message","Booking deleted successfully");
        return "redirect:/admin/readAllBookings";
    }

    @GetMapping("addService")
    public String addServiceView(){

        return "admin/addservice";
    }

    @InitBinder
    public void stopBinding(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("image");

    }
    @PostMapping("addService")
    public String addService(@ModelAttribute ServiceForm serviceForm,@RequestParam("image") MultipartFile multipartFile, RedirectAttributes redirectAttributes){
      String originalFileName= multipartFile.getOriginalFilename();
      serviceForm.setImage(originalFileName);
        try {

           ServiceForm serviceForm1 = serviceFormService.addService(serviceForm,multipartFile);
           if(serviceForm1 != null){
               redirectAttributes.addFlashAttribute("msg","Service Added Successfully");
           }else{
               redirectAttributes.addFlashAttribute("msg","Something went wrong");
           }
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("msg","Something went wrong");
        }

        return "redirect:/admin/addService";
    }
}
