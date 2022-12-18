package exalt.bankaccount.domain;

import java.util.Date;
import javax.persistence.ManyToOne;
import org.springframework.data.annotation.Id;
import com.fasterxml.jackson.annotation.JsonIgnore;


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
