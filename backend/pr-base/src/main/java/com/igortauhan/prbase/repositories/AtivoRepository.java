package com.igortauhan.prbase.repositories;

import com.igortauhan.prbase.models.Ativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AtivoRepository extends JpaRepository<Ativo, Long> {

    Optional<Ativo> findAtivoByEmail(String email);

    Optional<Ativo> findAtivoByDomain(String domain);
}
