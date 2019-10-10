package br.com.tr.employee.controller.form;

import br.com.tr.employee.model.Client;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ClientForm {
    @NotNull @NotEmpty @Length(min = 5)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Client converter() {
        return new Client(name);
    }
}
