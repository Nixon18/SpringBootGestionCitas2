package com.nixondinho.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.nixondinho.model.Paciente;

@Repository
public interface RepoPaciente extends JpaRepository<Paciente, String>, PagingAndSortingRepository<Paciente, String> {
	public Page<Paciente> findAll(Pageable pageable);
}
