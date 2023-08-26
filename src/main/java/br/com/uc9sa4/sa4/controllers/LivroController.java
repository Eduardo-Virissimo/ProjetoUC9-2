package br.com.uc9sa4.sa4.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.uc9sa4.sa4.models.Livro;
import br.com.uc9sa4.sa4.repository.LivroRepository;
import br.com.uc9sa4.sa4.DTO.LivroDTO;


@Controller
//@RequestMapping("/uc9sa4")
public class LivroController {

    private final LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }
    
    @GetMapping("/livros")
    public ModelAndView listLivros() {
        Iterable<Livro> livros = livroRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("livros");
        modelAndView.addObject("livros", livros);
        modelAndView.addObject("livroDTO", new LivroDTO());
        return modelAndView;
    }

    @PostMapping("/livros/create")
    public String createLivro(@ModelAttribute LivroDTO livroDTO) {
        Livro livro = new Livro();
        livro.setNome(livroDTO.getNome());
        livro.setAutor(livroDTO.getAutor());
        livro.setEditora(livroDTO.getEditora());
        livro.setIsbn(livroDTO.getIsbn());
        livroRepository.save(livro);
        return "redirect:/livros";
    }

    @GetMapping("/livros/edit/{id}")
    public ModelAndView editLivroForm(@PathVariable Long id) {
        Livro livro = livroRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid livro Id: " + id));
        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setId(livro.getId());
        livroDTO.setNome(livro.getNome());
        livroDTO.setAutor(livro.getAutor());
        livroDTO.setEditora(livro.getEditora());
        livroDTO.setIsbn(livro.getIsbn());

        ModelAndView modelAndView = new ModelAndView("edit-form-row");
        modelAndView.addObject("livroDTO", livroDTO);
        return modelAndView;
    }

    @PostMapping("/livros/edit/{id}")
    public String editLivro(@PathVariable Long id, @ModelAttribute LivroDTO livroDTO) {
        Livro livro = livroRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid livro Id: " + id));
        livro.setNome(livroDTO.getNome());
        livro.setAutor(livroDTO.getAutor());
        livro.setEditora(livroDTO.getEditora());
        livro.setIsbn(livroDTO.getIsbn());
        livroRepository.save(livro);
        return "redirect:/livros";
    }

    @GetMapping("/livros/delete/{id}")
    public String deleteLivro(@PathVariable Long id) {
        livroRepository.deleteById(id);
        return "redirect:/livros";
    }
}
