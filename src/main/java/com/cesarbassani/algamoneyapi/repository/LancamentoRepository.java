package com.cesarbassani.algamoneyapi.repository;

import com.cesarbassani.algamoneyapi.model.Lancamento;
import com.cesarbassani.algamoneyapi.model.Pessoa;
import com.cesarbassani.algamoneyapi.repository.lancamento.LancamentoRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {
}
