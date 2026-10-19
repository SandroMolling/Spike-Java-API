package fullstack.API.service;

import fullstack.API.model.Aluno;
import fullstack.API.repository.AlunoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public List<Aluno> listarTodos(){
        return repository.findAll();
    }

    public Aluno buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Aluno não encontrado"));
    }

    public Aluno cadastrar(Aluno aluno){
        if (aluno.getNome() == null || aluno.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome é obrigatório");
        }

        if (aluno.getCurso() == null || aluno.getCurso().isBlank()) {
            throw  new IllegalArgumentException("O curso é obrigatório");
        }

        return repository.save(aluno);
    }

    public Aluno atualizar(Long id, Aluno dados) {
        Aluno aluno = buscarPorId(id);

        if (aluno.getNome() == null || aluno.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome é obrigatório");
        }

        if (aluno.getCurso() == null || aluno.getCurso().isBlank()) {
            throw  new IllegalArgumentException("O curso é obrigatório");
        }

        aluno.setNome(dados.getNome());
        aluno.setCurso(dados.getCurso());

        return repository.save(aluno);
    }

    public void excluir(Long id) {
        Aluno aluno = buscarPorId(id);
        repository.delete(aluno);
    }
}
