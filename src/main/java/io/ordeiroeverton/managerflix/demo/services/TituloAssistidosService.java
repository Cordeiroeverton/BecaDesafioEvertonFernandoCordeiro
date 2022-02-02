
package io.ordeiroeverton.managerflix.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.ordeiroeverton.managerflix.demo.models.TituloAssistido;
import io.ordeiroeverton.managerflix.demo.repository.TitutoAssistidosRepository;

@Service
public class TituloAssistidosService {

    @Autowired
    private TitutoAssistidosRepository titulosAssistidosRepository;

    public TituloAssistido obterTtituloAssistido(Long id) {

        TituloAssistido obterTitulosAssistidos = titulosAssistidosRepository.findById(id).get();

        return obterTitulosAssistidos;
    }

    public TituloAssistido atualizarTitulosAssistido(TituloAssistido titulosAssistidos, long id) {

       TituloAssistido atualizarAssistidos = this.obterTtituloAssistido(id);

        atualizarAssistidos.setNome(titulosAssistidos.getNome());
        atualizarAssistidos.setSinopse(titulosAssistidos.getSinopse());
        atualizarAssistidos.setTemporadas(titulosAssistidos.getTemporadas());
        atualizarAssistidos.setEpsodios(titulosAssistidos.getEpsodios());
        atualizarAssistidos.setStatus(titulosAssistidos.getStatus());
        atualizarAssistidos.setDuracao(titulosAssistidos.getDuracao());
        
        titulosAssistidosRepository.save(titulosAssistidos);

        return titulosAssistidos;
    }

    public List<TituloAssistido> listarTitulosAssistidos() {

        List<TituloAssistido> listarTitulosAssistidos = titulosAssistidosRepository.findAll();

        return listarTitulosAssistidos;
    }

    public void deletarTtitulsoAssistidos(long id) {
        titulosAssistidosRepository.deleteById(id);
    }

}

