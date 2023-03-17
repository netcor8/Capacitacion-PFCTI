
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Direccion")
@Setter
@Getter
public class Cliente{


    @Id
    private int id;

    @Column (name = "nombre")
    private String direccion;
    private String nomenclatura;

    @ManytoOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;


} )