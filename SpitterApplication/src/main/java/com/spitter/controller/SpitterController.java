package com.spitter.controller;


import com.spitter.repository.repositoryDefinition.SpitterRepository;
import com.spitter.repository.repositoryDefinition.SpittleRepository;
import com.spitter.util.Spitter;
import com.spitter.util.exceptions.DuplicateSpitterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/spitter")
public class SpitterController {


    private SpitterRepository spitterRepository;
    private SpittleRepository spittleRepository;
    @Autowired
    public SpitterController(SpittleRepository spittleRepository){
        this.spittleRepository = spittleRepository;
    }
    @RequestMapping(value="/nesto", method = RequestMethod.GET)
    public String test(Model model){
        model.addAttribute("spitter", spitterRepository.findAll());
        return "Spitter";
    }
    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model){
        model.addAttribute(new Spitter());
        return "RegisterForm";
    }
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String processRegistration(@RequestPart("profilePicture") MultipartFile profilePicture, @Valid Spitter spitter, BindingResult errors, RedirectAttributes model) throws IOException, DuplicateSpitterException {
        if(errors.hasErrors()) {
            return "RegisterForm";
        }
        else{
            spitterRepository.saveSpitter(spitter);
            model.addFlashAttribute(spitter);
            profilePicture.transferTo(new File("/data/spittr/" + profilePicture.getOriginalFilename()));
            spitterRepository.addSpitter(spitter);
            return "redirect:/spitter/" + spitter.getUsername();
        }
    }
    @RequestMapping(value = "/{spitter}", method = RequestMethod.GET)
    public String showProfilePage(@PathVariable("spitter") Long spitter, Model model){
        if(!model.containsAttribute("spitter"));
        model.addAttribute("spitter", spitterRepository.findOne(spitter));
//        spitterRepository.saveSpitter(new Spitter("drugo@gmail.com", "username", "ludilce", "najvece"));
        return "Profile";
    }
    @RequestMapping(value="/asd", method = RequestMethod.GET)
    public String showTestPage(Model model){
        model.addAttribute("spittle", spittleRepository.findAll());
        return "SpitterProfile";
    }
}
