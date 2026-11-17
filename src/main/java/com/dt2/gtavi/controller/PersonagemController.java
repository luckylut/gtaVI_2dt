package com.dt2.gtavi.controller;

import com.dt2.gtavi.entities.Personagem;
import com.dt2.gtavi.repositories.PersonagemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/personagem")
public class PersonagemController {
    private final PersonagemRepository repository;
    public PersonagemController(PersonagemRepository repository){
        this.repository = repository;
    }

    @PostMapping
    public String criarPersonagem(Personagem lucas){
        try {
            repository.save(lucas);
            return  "Calvo com sucesso ✅";
        } catch (Exception e){
        return "Dados incorretos ❌";
        }
    }

    @GetMapping
    public List<Personagem> mostrar(){
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id){
        repository.deleteById(id);
    }

    @GetMapping("/{id}")
    public void buscarId(@PathVariable int id){
        repository.findById(id);
    }

    // alterar
    @PutMapping("/{id}")
    public void atualizar(@PathVariable int id,
                          @RequestBody Personagem p) {
        Personagem personagem = repository.getReferenceById(id);
        personagem.setNome(p.getNome());
        personagem.setApelido(p.getApelido());
        personagem.setCategoria(p.getCategoria());
        personagem.setDescricao(p.getDescricao());
        personagem.setImagem(p.getImagem());
    }
}
