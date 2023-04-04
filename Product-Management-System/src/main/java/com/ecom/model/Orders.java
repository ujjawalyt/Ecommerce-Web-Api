package com.ecom.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.apache.catalina.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Orders {

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private Long orderId;
	private Double totalAmount;
	private String address;
	private String paymentType;
	private LocalDateTime timestamp;
	
	@ManyToOne
	private Users users;
	
	
	
}
