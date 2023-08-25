package br.com.uc9sa4.sa4.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import br.com.uc9sa4.sa4.models.Livro;
import br.com.uc9sa4.sa4.repository.LivroRepository;


@Controller
//@RequestMapping("/uc9sa4")
public class LivroController {

    private final LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @GetMapping("/livros")
    public String listLivros(Model model) {
        Iterable<Livro> livros = livroRepository.findAll();
        model.addAttribute("livros", livros);
        return "livros";
    }

    @PostMapping("/livros/create")
    public String createLivro(
            @RequestParam String nome,
            @RequestParam String autor,
            @RequestParam String editora,
            @RequestParam long isbn) {
        Livro livro = new Livro();
        livro.setNome(nome);
        livro.setAutor(autor);
        livro.setEditora(editora);
        livro.setIsbn(isbn);
        livroRepository.save(livro);
        return "redirect:/livros";
    }
    
    
    @GetMapping("/livros/edit/{id}")
    public String editLivroForm(@PathVariable Long id, Model model) {
        System.out.println("Fetching livro for editing with id: " + id);
        Livro livro = livroRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid livro Id: " + id));   
        model.addAttribute("livro", livro);        
        System.out.println("Livro fetched: " + livro);
        return "edit-form"; // Use the correct name of your edit form template
    }

    @PostMapping("/livros/edit/{id}")
    public String editLivro(
            @PathVariable Long id,
            @RequestParam String nome,
            @RequestParam String autor,
            @RequestParam String editora,
            @RequestParam long isbn) {
        Livro livro = livroRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid livro Id: " + id));
        livro.setNome(nome);
        livro.setAutor(autor);
        livro.setEditora(editora);
        livro.setIsbn(isbn);
        livroRepository.save(livro);
        return "redirect:/livros"; // Change this line to redirect to the correct URL
    }

    @GetMapping("/livros/delete/{id}")
    public String deleteLivro(@PathVariable Long id) {
        livroRepository.deleteById(id);
        return "redirect:/livros";
    }
}
