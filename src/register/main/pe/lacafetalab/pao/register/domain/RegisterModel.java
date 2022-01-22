package pe.lacafetalab.pao.register.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.lacafetalab.base.ddd.domain.AggregateRoot;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegisterModel extends AggregateRoot {

    private String ruc;
    private String razon_social;
    private String estado;
    private String direccion;
    private String ubigeo;
    private String departamento;
    private String provincia;
    private String distrito;


}
