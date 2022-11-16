package com.bosonit.examen_JPA_cascada;

import com.bosonit.examen_JPA_cascada.entities.ClientEntity;
import com.bosonit.examen_JPA_cascada.entities.InvoiceHeaderEntity;
import com.bosonit.examen_JPA_cascada.entities.InvoiceLinesEntity;
import com.bosonit.examen_JPA_cascada.services.ClientService;
import com.bosonit.examen_JPA_cascada.services.InvoiceHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ExamenJpaCascadaApplication {
	@Autowired
	ClientService clientService;
	@Autowired
	InvoiceHeaderService invoiceHeaderService;

	@Bean
	public void iniSQL() throws SQLException {
		ClientEntity client1 = new ClientEntity("Jose");
		clientService.addClient(client1);

		List<InvoiceLinesEntity> invoiceLinesEntityList = new ArrayList<>();
		invoiceLinesEntityList.add(new InvoiceLinesEntity("Producto",22.22,22.22));
		invoiceLinesEntityList.add(new InvoiceLinesEntity("Producto2",22.22,22.22));

		InvoiceHeaderEntity invoiceHeader = new InvoiceHeaderEntity(client1,22.22, invoiceLinesEntityList);
		invoiceHeaderService.addInvoiceHeader(invoiceHeader);

	}


	public static void main(String[] args) {
		SpringApplication.run(ExamenJpaCascadaApplication.class, args);
	}

}
