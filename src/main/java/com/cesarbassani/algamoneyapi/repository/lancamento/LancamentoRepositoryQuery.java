package com.cesarbassani.algamoneyapi.repository.lancamento;

import com.cesarbassani.algamoneyapi.model.Lancamento;
import com.cesarbassani.algamoneyapi.repository.filter.LancamentoFilter;

import java.util.List;

public interface LancamentoRepositoryQuery {

    public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter);
}
