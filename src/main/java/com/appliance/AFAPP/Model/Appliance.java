package com.appliance.AFAPP.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appliance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libele;

    private String dbid;

    private Boolean disponibilite;

    private String reference;

   @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_app_id", referencedColumnName = "id")
    private Type type;



}
