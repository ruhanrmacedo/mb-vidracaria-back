package macedos.mbvidracaria.service;

import jakarta.persistence.EntityNotFoundException;
import macedos.mbvidracaria.dto.material.CadastroMaterialDTO;
import macedos.mbvidracaria.entity.material.*;
import macedos.mbvidracaria.repository.MaterialRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;
    private static final Logger logger = LoggerFactory.getLogger(MaterialService.class);

    public Material criarMaterial(CadastroMaterialDTO cadastroMaterialDTO) {
        Material material;

        if (cadastroMaterialDTO.espessura() != null && cadastroMaterialDTO.temperado() != null && cadastroMaterialDTO.precoPorKg() != null) {
            // Criar Vidro
            material = new Vidro(
                    null,
                    cadastroMaterialDTO.nome(),
                    cadastroMaterialDTO.codigo(),
                    cadastroMaterialDTO.descricao(),
                    cadastroMaterialDTO.quantEstoque(),
                    cadastroMaterialDTO.quantMinEstoque(),
                    true,
                    cadastroMaterialDTO.espessura(),
                    cadastroMaterialDTO.temperado(),
                    cadastroMaterialDTO.precoPorKg()
            );
        } else if (cadastroMaterialDTO.comprimento() != null && cadastroMaterialDTO.largura() != null && cadastroMaterialDTO.espessura() != null && cadastroMaterialDTO.precoPorPeca() != null) {
            // Criar Aluminio
            material = new Aluminio(
                    null,
                    cadastroMaterialDTO.nome(),
                    cadastroMaterialDTO.codigo(),
                    cadastroMaterialDTO.descricao(),
                    cadastroMaterialDTO.quantEstoque(),
                    cadastroMaterialDTO.quantMinEstoque(),
                    true,
                    cadastroMaterialDTO.comprimento(),
                    cadastroMaterialDTO.largura(),
                    cadastroMaterialDTO.espessura(),
                    cadastroMaterialDTO.precoPorPeca()
            );
        } else if (cadastroMaterialDTO.precoPorUnidade() != null) {
            // Verifica se é um Acessório ou Ferragens
            if (cadastroMaterialDTO.nome().toLowerCase().contains("ferragem")) {
                // Criar Ferragens
                material = new Ferragens(
                        null,
                        cadastroMaterialDTO.nome(),
                        cadastroMaterialDTO.codigo(),
                        cadastroMaterialDTO.descricao(),
                        cadastroMaterialDTO.quantEstoque(),
                        cadastroMaterialDTO.quantMinEstoque(),
                        true,
                        cadastroMaterialDTO.precoPorUnidade()
                );
            } else {
                // Criar Acessorio
                material = new Acessorio(
                        null,
                        cadastroMaterialDTO.nome(),
                        cadastroMaterialDTO.codigo(),
                        cadastroMaterialDTO.descricao(),
                        cadastroMaterialDTO.quantEstoque(),
                        cadastroMaterialDTO.quantMinEstoque(),
                        true,
                        cadastroMaterialDTO.precoPorUnidade()
                );
            }
        } else {
            throw new IllegalArgumentException("Os dados fornecidos não correspondem a um tipo de material válido.");
        }

        materialRepository.save(material);
        logger.info("Cadastrar material: {}", material.getNome());
        return material;
    }

    public Page<Material> listarMaterialAtivos(Pageable paginacao) {
        return materialRepository.findByAtivoTrue(paginacao);
    }

    public Page<Material> listagemMaterial(Pageable paginacao) {
        return materialRepository.findAllByOrderByIdDesc(paginacao);
    }

    public Material excluirMaterial(Long id){
        var materialExcluir = materialRepository.getReferenceById(id);
        materialExcluir.marcarComoInativo();

        return materialExcluir;
    }

    public Material detalharMaterial(Long id) {
        return materialRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Material não encontrado com ID." + id));
    }

    public Optional<Material> buscarMaterialPorId(Long id){
        var findMaterial = materialRepository.findById(id);
        return findMaterial;
    }


}
