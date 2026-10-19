
package fullstack.API.controller;

import fullstack.API.model.Curso;
import fullstack.API.service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Curso> listarTodos() {
        return service.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Curso> cadastrar(@RequestBody Curso curso) {
        Curso novoCurso = service.cadastrar(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCurso);
    }
}
