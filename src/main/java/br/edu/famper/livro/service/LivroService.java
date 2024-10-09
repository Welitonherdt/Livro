package br.edu.famper.livro.service;

import br.edu.famper.livro.model.Livro;
import br.edu.famper.livro.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public Livro save(Livro livro) {
        return livroRepository.save(livro);
    }

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public Optional<Livro> findById(Long id) {
        return livroRepository.findById(id);
    }

    public Livro update(Livro livro) {
        Livro salvo = livroRepository.findById(livro.getCodigo())
                .orElseThrow(() ->
                        new RuntimeException("Livro não encontrado!")
                );
        salvo.setAutor(livro.getAutor());
        salvo.setTitulo(livro.getTitulo());
        salvo.setDataPublicacao(livro.getDataPublicacao());
        salvo.setPreco(livro.getPreco());
        return livroRepository.save(salvo);
    }

    public void deleteById(Long id) {
        livroRepository.deleteById(id);
    }

}
