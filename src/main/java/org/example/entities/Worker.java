package org.example.entities;

import org.example.entities.enums.WorkerLevel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Worker {

    private String name;

    private WorkerLevel level;
    private Double baseSalary;
    private Department department;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker() {
    }

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    /**
     * Este método não deve ser utilizado em listas, pois ao atribuir uma nova lista,
     * estaríamos substituindo completamente a lista existente, o que não é a intenção.
     * O propósito deve ser adicionar ou remover elementos na lista existente.
     *
     * @param contracts A lista de contratos a ser atribuída
     */
    public void setContracts(List<HourContract> contracts) {
        this.contracts = contracts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }


    public void addContract(HourContract contract) {
        contracts.add(contract);
    }

    public void removeContract(HourContract contract) {
        contracts.remove(contract);
    }

    /**
     * Calcula a renda total para um determinado ano e mês.
     *
     * @param year  O ano para o qual a renda será calculada.
     * @param month O mês para o qual a renda será calculada.
     * @return A renda total para o ano e mês especificados.
     */
    public Double income(Integer year, Integer month) {

        // Inicializa a soma com o salário base
        double sum = baseSalary;

        // Obtém uma instância do calendário para manipular datas
        Calendar calendar = Calendar.getInstance();

        // Itera sobre todos os contratos
        for (HourContract contract : contracts) {

            // pegando a data do contrato e definido dentro da variavel do tipo Calender
            calendar.setTime(contract.getDate());
            int contract_year = calendar.get(Calendar.YEAR);
            int contract_month = 1 + calendar.get(Calendar.MONTH);

            // Verifica se o contrato é do ano e mês especificados
            if (contract_year == year && contract_month == month) {

                // Adiciona o valor do contrato à soma total
                sum += contract.getValuePerHour();

            }
        }
        return sum;
    }
}

