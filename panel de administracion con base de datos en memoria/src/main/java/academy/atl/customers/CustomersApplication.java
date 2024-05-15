package academy.atl.customers;

import academy.atl.customers.entities.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootApplication
public class CustomersApplication {

	public static void main(String[] args) {
		Customer c = Customer.builder()
				.id(1)
				.email("lucasmoy@gmail.com")
				.address("siempre viva 123")
				.build();

	}


}
