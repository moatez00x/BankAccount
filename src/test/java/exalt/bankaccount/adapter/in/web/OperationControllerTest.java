package exalt.bankaccount.adapter.in.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import exalt.bankaccount.adapter.out.persistance.AccountRepository;
import exalt.bankaccount.adapter.out.persistance.OperationAdapter;
import exalt.bankaccount.adapter.out.persistance.OperationRepository;
@AutoConfigureMockMvc
@SpringBootTest
public class OperationControllerTest {
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	OperationController  operationController;
	
	@MockBean
	OperationRepository  operationRepository;

	@MockBean
	AccountRepository  accountRepository;
	
	@MockBean
	OperationAdapter operationAdapter;

	
	@Test
	public void GIVEN_URL_WHEN_callApi_THEN_return_operations() throws Exception {
		//GIVEN
		mvc.perform(MockMvcRequestBuilders.get("/operation/all?accountId=1").accept(MediaType.APPLICATION_JSON))
		//RETURN
		.andExpect(status().isOk());
	}

}
