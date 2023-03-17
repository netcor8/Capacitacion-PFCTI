
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
@Setter
@Getter
public class Cliente{

    @Column (name = "nombre")
    private String Nombre;
    @Column ( lenght = 30)
    private String Apellidos;
    @Id
    private int id;
    @Column ( columnDefinition = "varchar(15)" )
            private String Cedula;
    private String Telefono;

}