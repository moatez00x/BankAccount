package exalt.bankaccount.config;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ServerResponse {
	String message;
	LocalDateTime timestamp;
	
	
}
