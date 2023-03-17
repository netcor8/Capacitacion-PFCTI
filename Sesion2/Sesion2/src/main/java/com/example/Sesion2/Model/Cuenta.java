import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Setter
@Getter


public class Cuenta{


    @Id
    private int id;

    @Column (name = "nombre")
    private String numero;
    @Column ( lenght = 30)
    private String tipo;

    @ManytoOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;

}