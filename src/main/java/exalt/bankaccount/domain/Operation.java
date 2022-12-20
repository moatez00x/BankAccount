package exalt.bankaccount.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "operation")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Operation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;

	private String name;

	private float amount;

	private Date date;

	private float balance;

	@JsonIgnore
	@ManyToOne
	private Account account;
}
