
package fullstack.API.service;

import fullstack.API.exception.AlunoNaoEncontradoException;
import fullstack.API.model.Aluno;
import fullstack.API.model.Curso;
import fullstack.API.repository.AlunoRepository;
import fullstack.API.repository.CursoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository repository;
    private final CursoRepository cursoRepository;

    public AlunoService(
            AlunoRepository repository,
            CursoRepository cursoRepository) {
        this.repository = repository;
        this.cursoRepository = cursoRepository;
    }

    public List<Aluno> listarTodos() {
        return repository.findAll();
    }

    public Aluno buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new AlunoNaoEncontradoException(
                        "Aluno não encontrado com ID: " + id));
    }

    public Aluno cadastrar(Aluno aluno) {
        validarAluno(aluno);

        Long cursoId = aluno.getCurso().getId();

        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Curso não encontrado"));

        aluno.setCurso(curso);

        return repository.save(aluno);
    }

    public Aluno atualizar(Long id, Aluno dados) {
        Aluno aluno = buscarPorId(id);

        validarAluno(dados);

        Long cursoId = dados.getCurso().getId();

        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Curso não encontrado"));

        aluno.setNome(dados.getNome());
        aluno.setCurso(curso);

        return repository.save(aluno);
    }

    public void excluir(Long id) {
        Aluno aluno = buscarPorId(id);
        repository.delete(aluno);
    }

    private void validarAluno(Aluno aluno) {
        if (aluno.getNome() == null || aluno.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome é obrigatório");
        }

        if (aluno.getCurso() == null || aluno.getCurso().getId() == null) {
            throw new IllegalArgumentException("O curso é obrigatório");
        }
    }
}