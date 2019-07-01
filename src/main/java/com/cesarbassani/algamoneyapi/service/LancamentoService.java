package com.cesarbassani.algamoneyapi.service;

import com.cesarbassani.algamoneyapi.model.Lancamento;
import com.cesarbassani.algamoneyapi.model.Pessoa;
import com.cesarbassani.algamoneyapi.repository.LancamentoRepository;
import com.cesarbassani.algamoneyapi.repository.PessoaRepository;
import com.cesarbassani.algamoneyapi.service.exception.PessoaInexistenteOuInativaException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Lancamento atualizar(Long codigo, Lancamento lancamento) {
        Lancamento lancamentoSalvo = buscarLancamentoPeloCodigo(codigo);
        BeanUtils.copyProperties(lancamento, lancamentoSalvo, "codigo");
        return lancamentoRepository.save(lancamentoSalvo);
    }

    private Lancamento buscarLancamentoPeloCodigo(Long codigo) {
        Lancamento lancamentoSalvo = lancamentoRepository.findOne(codigo);
        if (lancamentoSalvo == null) {
            throw new EmptyResultDataAccessException(1);
        }
        return lancamentoSalvo;
    }

    public Lancamento salvar(Lancamento lancamento) {
        Pessoa pessoa = pessoaRepository.findOne(lancamento.getPessoa().getCodigo());
        if (pessoa == null || pessoa.isInativo()) {
            throw new PessoaInexistenteOuInativaException();
        }
        return lancamentoRepository.save(lancamento);
    }

    public void deletar(Long codigo) {
        Lancamento lancamentoBuscado = buscarLancamentoPeloCodigo(codigo);
        lancamentoRepository.delete(lancamentoBuscado);
    }
}
