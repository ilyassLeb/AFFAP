package com.appliance.AFAPP.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Suivi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean offre_commerciale;
    private Float mantant ;

    @ManyToOne
    @JoinColumn(name="pov_id", nullable=false)
    private Pov pov;

    @ManyToOne
    @JoinColumn(name="ty_pres_id", nullable=false)
    private TypePrestation typePrestation;





}
