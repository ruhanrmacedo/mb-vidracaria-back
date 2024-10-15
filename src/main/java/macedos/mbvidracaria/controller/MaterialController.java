package macedos.mbvidracaria.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import macedos.mbvidracaria.dto.material.CadastroMaterialDTO;
import macedos.mbvidracaria.dto.material.DetalhamentoMaterialDTO;
import macedos.mbvidracaria.dto.material.EditarMaterialDTO;
import macedos.mbvidracaria.entity.material.Material;
import macedos.mbvidracaria.enums.CategoriaMaterial;
import macedos.mbvidracaria.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("api/material")
@SecurityRequirement(name = "bearer-key")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @PostMapping("/cadastrarMaterial")
    @Transactional
    public ResponseEntity<DetalhamentoMaterialDTO> cadastrarMaterial(@RequestBody @Valid CadastroMaterialDTO cadastroMaterialDTO, UriComponentsBuilder uriBuilder) {
        try {
            Material material = materialService.criarMaterial(cadastroMaterialDTO);
            var uri = uriBuilder.path("/material/detalharMaterial/{id}").buildAndExpand(material.getId()).toUri();
            return ResponseEntity.created(uri).body(new DetalhamentoMaterialDTO(material));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/listarMaterialAtivos")
    public ResponseEntity<Page<Material>> listarMaterialAtivos(@PageableDefault (sort = "descricao") Pageable paginacao) {
        Page<Material> materialAtivos = materialService.listarMaterialAtivos(paginacao);
        return ResponseEntity.ok(materialAtivos);
    }

    @GetMapping("/listarMaterial")
    public ResponseEntity<Page<Material>> listagemMaterial(@PageableDefault (sort = "id") Pageable paginacao) {
        Page<Material> material = materialService.listagemMaterial(paginacao);
        return ResponseEntity.ok(material);
    }

    @DeleteMapping("/excluirMaterial/{id}")
    @Transactional
    public ResponseEntity excluirMaterial (@PathVariable Long id) {
        Material materialExcluir = materialService.excluirMaterial(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/detalharMaterial/{id}")
    public ResponseEntity detalharServico (@PathVariable Long id) {
        Material materialDetalhar = materialService.detalharMaterial(id);
        DetalhamentoMaterialDTO detalhamentoMaterialDTO = new DetalhamentoMaterialDTO(materialDetalhar);
        return ResponseEntity.ok(detalhamentoMaterialDTO);
    }
    @GetMapping("/tipo-material")
    public ResponseEntity<?> getTipoMaterial() {
        return ResponseEntity.ok(CategoriaMaterial.values());
    }
}
