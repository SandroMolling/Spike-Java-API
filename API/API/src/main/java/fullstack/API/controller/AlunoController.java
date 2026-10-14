package fullstack.API.controller;

import fullstack.API.model.Aluno;
import fullstack.API.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Aluno> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Aluno buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Aluno cadastrar(@RequestBody Aluno aluno) {
        return service.cadastrar(aluno);
    }

    @PutMapping
    public Aluno atualizar(
            @PathVariable Long id,
            @RequestBody Aluno aluno) {
        return service.atualizar(id, aluno);
    }

    @DeleteMapping
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}