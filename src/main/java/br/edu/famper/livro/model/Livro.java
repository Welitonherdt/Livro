package br.edu.famper.livro.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_livro")
@Data
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "livro_id")
    private Long codigo;

    @Column(name = "titulo", length = 100)
    private String titulo;

    @Column(name = "autor", length = 150)
    private String autor;

    @Column(name = "ano publicacao", length = 8)
    private Number dataPublicacao;

    @Column(name = "preco")
    private Double preco;
}
