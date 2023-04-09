package com.appliance.AFAPP.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Data
 @Table
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String libele;
    private String secteur;
    private String activite ;
    @OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE)
    public List<Contact> Contact;
    @OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE)
    public List<Pov> povs;










}
