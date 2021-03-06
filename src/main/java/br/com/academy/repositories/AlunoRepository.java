package br.com.academy.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.com.academy.model.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO tb_aluno (cd_matricula, nm_aluno, cd_curso, cd_status, cd_turno, ts_inclusao, ts_alteracao, id_usuario) "
			+ " VALUES (:matricula, :nome, :curso, :status, :turno, current_timestamp, current_timestamp, :id_usuario)", nativeQuery = true)
	public void insert(
			@Param("matricula") String matricula,
			@Param("nome") String nome,
			@Param("curso") Integer curso,
			@Param("status") Integer status,
			@Param("turno") Integer turno,
			@Param("id_usuario") Long id);

	@Modifying
	@Transactional
	@Query(value = "UPDATE tb_aluno "
			+ "SET cd_matricula = :matricula, "
			+ "nm_aluno = :nome, "
			+ "cd_curso = :curso, "
			+ "cd_status = :status, "
			+ "cd_turno = :turno, "
			+ "ts_alteracao = current_timestamp, "
			+ "id_usuario = :id_usuario "
			+ "WHERE id_aluno = :id", nativeQuery = true)
	public void update(
			@Param("id") Long id,
			@Param("matricula") String matricula,
			@Param("nome") String nome,
			@Param("curso") Integer curso,
			@Param("status") Integer status,
			@Param("turno") Integer turno,
			@Param("id_usuario") Long id_usuario);
	
	
	@Query(value = "SELECT a FROM Aluno a WHERE a.status=1")
	public Page<Aluno> findByStatusAtivo(Pageable pageable);

	@Query(value = "SELECT a FROM Aluno a WHERE a.status=2")
	public Page<Aluno> findByStatusInativo(Pageable pageable);
	
	@Query(value = "SELECT a FROM Aluno a WHERE a.status=3")
	public Page<Aluno> findByStatusTrancado(Pageable pageable);
	
	@Query(value = "SELECT a FROM Aluno a WHERE a.status=4")
	public Page<Aluno> findByStatusCancelado(Pageable pageable);

	@Query(value = "SELECT a FROM Aluno a WHERE lower(a.nome) "
			+ "LIKE lower(concat('%',:nome,'%')) "
			+ "ORDER BY a.nome")
	public Page<Aluno> findByNome(String nome, Pageable pageable);
}