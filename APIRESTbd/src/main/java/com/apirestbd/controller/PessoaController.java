package com.apirestbd.controller;

import com.apirestbd.model.Pessoa;
import com.apirestbd.repository.PessoaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private PessoaRepository pessoaRepository;

    public PessoaController(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @GetMapping
    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pessoa pesquisarPorId(@PathVariable Long id) {
        return pessoaRepository.findById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa cadastrar(@RequestBody Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizar(@PathVariable Long id, @RequestBody Pessoa pessoaAtualizada) {

        if (!pessoaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Pessoa pessoaExistente = pessoaRepository.findById(id).orElse(null);

        if (pessoaExistente != null) {
            pessoaExistente.setNome(pessoaAtualizada.getNome());
            pessoaExistente.setSexo(pessoaAtualizada.getSexo());
            pessoaExistente.setIdioma(pessoaAtualizada.getIdioma());

            Pessoa pessoaAtualizadaNoBanco = pessoaRepository.save(pessoaExistente);

            return ResponseEntity.ok(pessoaAtualizadaNoBanco);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!pessoaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        pessoaRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    //Desafio Idioma
    @GetMapping("/idioma/{idioma}")
    public List<Pessoa> pesquisarIdioma(@PathVariable String idioma) {
        return pessoaRepository.findByIdioma(idioma);
    }
}
