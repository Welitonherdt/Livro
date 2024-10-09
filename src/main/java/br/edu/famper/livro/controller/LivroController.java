package br.edu.famper.livro.controller;

import br.edu.famper.livro.model.Livro;
import br.edu.famper.livro.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("api/livro")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<Livro>> findALL() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(livroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Livro>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(livroService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Livro> create(@RequestBody Livro livro) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(livroService.save(livro));
    }

    @PutMapping
    public ResponseEntity<Livro> update(@RequestBody Livro livro) {
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(livroService.update(livro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        livroService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();

    }
}
