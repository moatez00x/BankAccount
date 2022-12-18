package exalt.bankaccount.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import org.springframework.data.annotation.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    private Long id;

    private String name;

    private float  balance;
    
	@OneToMany(mappedBy = "account", cascade = CascadeType.REMOVE)
	private List<Operation> lineItems;

}

