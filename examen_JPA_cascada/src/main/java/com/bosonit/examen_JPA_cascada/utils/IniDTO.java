package com.bosonit.examen_JPA_cascada.utils;

import com.bosonit.examen_JPA_cascada.dto.ClientDTO;
import com.bosonit.examen_JPA_cascada.dto.InvoiceHeaderDTO;
import com.bosonit.examen_JPA_cascada.dto.InvoiceLinesDTO;
import com.bosonit.examen_JPA_cascada.entities.ClientEntity;
import com.bosonit.examen_JPA_cascada.entities.InvoiceHeaderEntity;
import com.bosonit.examen_JPA_cascada.entities.InvoiceLinesEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IniDTO {
    public static ClientDTO iniClientDTO(ClientEntity client){
        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setId(client.getId());
        clientDTO.setNombre(client.getName());

        return clientDTO;
    }

    public static List<ClientDTO> iniClientDTO(List<ClientEntity> client){
        List<ClientDTO> clientDTO = new ArrayList<>();

        for(ClientEntity i : client){
            clientDTO.add(iniClientDTO(i));
        }

        return clientDTO;
    }

    public static InvoiceHeaderDTO iniInvoiceHeaderDTO(InvoiceHeaderEntity invoiceHeader){
        InvoiceHeaderDTO invoiceHeaderDTO = new InvoiceHeaderDTO();

        invoiceHeaderDTO.setId(invoiceHeader.getId());
        invoiceHeaderDTO.setImporteFra(invoiceHeader.getAmount());
        invoiceHeaderDTO.setClientDTO(iniClientDTO(invoiceHeader.getClient()));
        invoiceHeaderDTO.setInvoiceLinesDTOList(iniInvoiceLinesDTO(invoiceHeader.getInvoiceLines()));

        return invoiceHeaderDTO;
    }

    public static List<InvoiceHeaderDTO> iniInvoiceHeaderDTO(List<InvoiceHeaderEntity> invoiceHeader){
        List<InvoiceHeaderDTO> invoiceHeaderDTO = new ArrayList<>();

        for(InvoiceHeaderEntity i : invoiceHeader){
            invoiceHeaderDTO.add(iniInvoiceHeaderDTO(i));
        }

        return invoiceHeaderDTO;
    }

    public static InvoiceLinesDTO iniInvoiceLinesDTO(InvoiceLinesEntity invoiceLines){
        InvoiceLinesDTO invoiceLinesDTO = new InvoiceLinesDTO();

        invoiceLinesDTO.setId(invoiceLines.getId());
        invoiceLinesDTO.setCantidad(invoiceLines.getAmount());
        invoiceLinesDTO.setImporte(invoiceLines.getPrice());
        invoiceLinesDTO.setProducto(invoiceLines.getProName());

        return invoiceLinesDTO;
    }

    public static List<InvoiceLinesDTO> iniInvoiceLinesDTO(List<InvoiceLinesEntity> invoiceLines){
        List<InvoiceLinesDTO> invoiceLinesDTO = new ArrayList<>();

        for(InvoiceLinesEntity i : invoiceLines){
            invoiceLinesDTO.add(iniInvoiceLinesDTO(i));
        }

        return invoiceLinesDTO;
    }
}
