package macedos.mbvidracaria.entity.cliente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "pessoa_juridica")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PessoaJuridica extends Cliente{
    @Column(name = "cnpj", nullable = false, unique = true)
    private String cnpj;
    @Column(name = "razao_social", nullable = false)
    private String razaoSocial;
    @Column(name = "nome_fantasia", nullable = false)
    private String nomeFantasia;

    public PessoaJuridica(Long id, String nome, String cnpj, String razaoSocial, String nomeFantasia, String telefone, String email, String endereco) {
        super(id, nome, telefone, email, endereco);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
    }
}
