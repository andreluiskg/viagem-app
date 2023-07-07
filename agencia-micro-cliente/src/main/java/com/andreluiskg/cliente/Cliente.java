package com.andreluiskg.cliente;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cliente extends PanacheEntityBase {
	
	@Id
	public Long id;
	
	public String nome;

}
