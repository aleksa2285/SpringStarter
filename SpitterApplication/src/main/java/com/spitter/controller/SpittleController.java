package com.spitter.controller;

import com.spitter.repository.repositoryDefinition.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/spittles")
public class SpittleController
{
    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository){
        this.spittleRepository = spittleRepository;
    }
    @RequestMapping(method = RequestMethod.GET)
//    public String spittles(@RequestParam(value = "max") long max, @RequestParam(value = "count", defaultValue = "20") int count, Model model){
//        model.addAttribute(spittleRepository.findSpittles(max, count));
//        return "Spittles";
//    }
    public String spittles(Model model){
        model.addAttribute("spittle", spittleRepository.findAll());
        return "Spittles";
    }
    @RequestMapping(value="/{spittleId}", method = RequestMethod.GET)
    public String showSpittle(@PathVariable("spittleId") long spittleId, Model model){
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "Spittle";
    }
}
