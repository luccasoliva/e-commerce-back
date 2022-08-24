package com.ecommerce.imobiliaria.Services;

import com.ecommerce.imobiliaria.Models.Foto;
import com.ecommerce.imobiliaria.Models.Imovel;
import com.ecommerce.imobiliaria.Repositories.FotoRepository;
import com.ecommerce.imobiliaria.Repositories.ImovelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FotoService {

    private FotoRepository fotoRepository;

    private ImovelRepository imovelRepository;

    public List<Foto> mostrarFotos() {
        return fotoRepository.findAll();
    }

    public Foto mostrarFotoPeloId(Integer idFoto){
        Optional<Foto> foto = fotoRepository.findById(idFoto);
        return foto.orElseThrow( ()-> new EntityNotFoundException("Foto não encontrada"));
    }

    public List<Foto> buscarFotoPorImovel(Integer idImovel){
        Optional<Imovel> imovel = imovelRepository.findById(idImovel);
        return fotoRepository.findByImovel(imovel);
    }

    public Foto salvarFoto(Foto foto, Integer idImovel){
        foto.setId(null);
        Optional<Imovel> imovel = imovelRepository.findById(idImovel);
        foto.setIdImovel(imovel.get());
        return fotoRepository.save(foto);
    }

    public void excluirFoto(Integer idFoto){
        fotoRepository.deleteById(idFoto);
    }
}
