package br.com.spring.diolabs.springmvcweb.controller;

import br.com.spring.diolabs.springmvcweb.model.Jedi;
import br.com.spring.diolabs.springmvcweb.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class JediController {

    @Autowired
    private JediRepository repository;

    @GetMapping("/list-jedi")
    public ModelAndView jedi() {
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jedi/listar");

        Jedi luke = new Jedi("Luke", "Skywalker");
        modelAndView.addObject("allJedi", repository.getAll());
        return modelAndView;
    }

    @GetMapping("/new-jedi")
    public String novoJedi(Model model) {

        model.addAttribute("jedi", new Jedi());
        return "jedi/incluir";
    }

    @PostMapping("create-jedi")
    public String createJedi(@Valid @ModelAttribute Jedi jedi,
                                   BindingResult result, RedirectAttributes redirect) {

        if (result.hasErrors()) {
            return "jedi/incluir";
        }
        repository.add(jedi);
        redirect.addFlashAttribute("message", jedi.getName()+" cadastrado com sucesso!");

        return "redirect:list-jedi";
    }
}