package macedos.mbvidracaria.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import macedos.mbvidracaria.dto.usuario.CadastroUsuarioDTO;
import macedos.mbvidracaria.dto.usuario.DesligarUsuarioDTO;
import macedos.mbvidracaria.dto.usuario.EditarUsuarioDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;


@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String login;
    private String senha;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataAtivacao;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataInativacao;


    public Usuario(CadastroUsuarioDTO cadastroUsuarioDTO) {
        this.nome = cadastroUsuarioDTO.nome();
        this.cpf = cadastroUsuarioDTO.cpf();
        this.login = cadastroUsuarioDTO.login();
        this.senha = cadastroUsuarioDTO.senha();
        this.dataAtivacao = cadastroUsuarioDTO.dataAtivacao();
        this.dataInativacao = cadastroUsuarioDTO.dataInativacao();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }


    @PrePersist
    private void prePersist() {
        if (dataAtivacao == null) {
            dataAtivacao = LocalDate.now();
        }
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setNome(String nome) {this.nome = nome;}

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setDataAtivacao(LocalDate dataAtivacao) {this.dataAtivacao = dataAtivacao;}

    public void setDataInativacao(LocalDate dataInativacao) {this.dataInativacao = dataInativacao;}

    public void atualizarInformacoes(EditarUsuarioDTO editarUsuarioDTO) {
        if(editarUsuarioDTO.nome() != null) {
            this.nome = editarUsuarioDTO.nome();
        }
        if(editarUsuarioDTO.cpf() != null) {
            this.cpf = editarUsuarioDTO.cpf();
        }
        if(editarUsuarioDTO.login() != null) {
            this.login = editarUsuarioDTO.login();
        }
    }

    public void desligarUsuario(DesligarUsuarioDTO dados) {
        if(dados.dataInativacao() != null) {
            this.dataInativacao = dados.dataInativacao();
        }
    }
}
