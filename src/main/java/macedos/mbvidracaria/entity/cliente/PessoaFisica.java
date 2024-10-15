package macedos.mbvidracaria.entity.cliente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "pessoa_fisica")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PessoaFisica extends Cliente{
    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;
    @Column(name = "data_nascimento", nullable = false)
    private String dataNascimento;

    public PessoaFisica(Long id, String nome, String cpf, String dataNascimento, String telefone, String email, String endereco) {
        super(id, nome, telefone, email, endereco);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }
}
