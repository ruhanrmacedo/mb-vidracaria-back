package macedos.mbvidracaria.service;

import jakarta.persistence.EntityNotFoundException;
import macedos.mbvidracaria.dto.cliente.CadastroClienteDTO;
import macedos.mbvidracaria.dto.cliente.EditarclienteDTO;
import macedos.mbvidracaria.entity.cliente.Cliente;
import macedos.mbvidracaria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cadastrarCliente(CadastroClienteDTO cadastroClienteDTO) {
        Cliente cliente = new Cliente(
                null,
                cadastroClienteDTO.nome(),
                cadastroClienteDTO.telefone(),
                cadastroClienteDTO.email(),
                cadastroClienteDTO.endereco()
        );
        clienteRepository.save(cliente);
        return cliente;
    }

    public Page<Cliente> listarClientes(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    public Cliente editarCliente(EditarclienteDTO editarclienteDTO) {
        Cliente cliente = clienteRepository.findById(editarclienteDTO.id())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        cliente.setNome(editarclienteDTO.nome());
        cliente.setTelefone(editarclienteDTO.telefone());
        cliente.setEmail(editarclienteDTO.email());
        cliente.setEndereco(editarclienteDTO.endereco());
        clienteRepository.save(cliente);
        return cliente;
    }
}
