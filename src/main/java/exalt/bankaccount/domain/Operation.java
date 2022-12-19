package exalt.bankaccount.domain;

import java.util.Date;
import javax.persistence.ManyToOne;
import org.springframework.data.annotation.Id;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "operation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Operation {

    @Id
    private Long id;

    private String name;

    private float  amount;
    
    private Date  date;

    private float balance;
    
	@JsonIgnore
	@ManyToOne
    private Account account;
}
