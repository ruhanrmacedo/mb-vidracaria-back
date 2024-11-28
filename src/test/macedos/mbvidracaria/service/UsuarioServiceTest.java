package macedos.mbvidracaria.service;

import macedos.mbvidracaria.dto.usuario.DesligarUsuarioDTO;
import macedos.mbvidracaria.dto.usuario.EditarUsuarioDTO;
import macedos.mbvidracaria.entity.Usuario;
import macedos.mbvidracaria.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UsuarioService usuarioService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this); // Inicializa os mocks
    }

    @Test
    void cadastrarUsuario() {
        // Simula um usuário de teste
        Usuario usuario = new Usuario();
        usuario.setNome("João");
        usuario.setCpf("12345678900");
        usuario.setLogin("joao123");
        usuario.setSenha("senha123");

        when(passwordEncoder.encode("senha123")).thenReturn("senhaCriptografada");
        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        Usuario resultado = usuarioService.cadastrarUsuario(usuario);

        // Verificações
        assertNotNull(resultado);
        assertEquals("João", resultado.getNome());
        assertEquals("senhaCriptografada", resultado.getSenha());
        verify(usuarioRepository, times(1)).save(usuario);
    }

    @Test
    void editarUsuario() {
        // Mock do DTO e do usuário existente
        Usuario usuarioExistente = new Usuario();
        ReflectionTestUtils.setField(usuarioExistente, "id", 1L); // Simula o ID
        usuarioExistente.setNome("João");

        EditarUsuarioDTO editarDTO = new EditarUsuarioDTO(1L, "João Silva", "12345678900", "joao123");

        when(usuarioRepository.getReferenceById(1L)).thenReturn(usuarioExistente);

        Usuario resultado = usuarioService.editarUsuario(editarDTO);

        // Verificações
        assertNotNull(resultado);
        assertEquals("João Silva", resultado.getNome());
        verify(usuarioRepository, times(1)).getReferenceById(1L);
    }

    @Test
    void listarTodosUsuarios() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Usuario> usuariosMock = new PageImpl<>(List.of(new Usuario(), new Usuario()));

        when(usuarioRepository.findAllByOrderByNome(pageable)).thenReturn(usuariosMock);

        Page<Usuario> resultado = usuarioService.listarTodosUsuarios(pageable);

        // Verificações
        assertNotNull(resultado);
        assertEquals(2, resultado.getContent().size());
        verify(usuarioRepository, times(1)).findAllByOrderByNome(pageable);
    }

    @Test
    void alterarSenha() {
        // Mock do usuário autenticado
        Usuario usuario = new Usuario();
        usuario.setLogin("joao123");
        usuario.setSenha("senha123");

        Authentication auth = mock(Authentication.class);
        when(auth.getPrincipal()).thenReturn(usuario);
        SecurityContextHolder.getContext().setAuthentication(auth);

        when(passwordEncoder.encode("novaSenha")).thenReturn("novaSenhaCriptografada");
        when(usuarioRepository.findByLogin("joao123")).thenReturn(Optional.of(usuario));

        usuarioService.alterarSenha("novaSenha", "novaSenha");

        // Verificações
        assertEquals("novaSenhaCriptografada", usuario.getSenha());
        verify(usuarioRepository, times(1)).save(usuario);
    }

    @Test
    void desligarUsuario() {
        Usuario usuarioExistente = new Usuario();
        ReflectionTestUtils.setField(usuarioExistente, "id", 1L); // Simula o ID
        usuarioExistente.setNome("João");

        DesligarUsuarioDTO desligarDTO = new DesligarUsuarioDTO(1L, LocalDate.of(2024, 1, 1));

        when(usuarioRepository.getReferenceById(1L)).thenReturn(usuarioExistente);
        when(usuarioRepository.save(usuarioExistente)).thenReturn(usuarioExistente); // Mock do save

        Usuario resultado = usuarioService.desligarUsuario(desligarDTO);

        // Verificações
        assertNotNull(resultado);
        assertEquals(LocalDate.of(2024, 1, 1), resultado.getDataInativacao());
        verify(usuarioRepository, times(1)).getReferenceById(1L);
        verify(usuarioRepository, times(1)).save(usuarioExistente);
    }
}
