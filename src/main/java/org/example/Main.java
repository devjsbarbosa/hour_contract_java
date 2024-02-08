package org.example;

import org.example.entities.Department;
import org.example.entities.HourContract;
import org.example.entities.Order;
import org.example.entities.Worker;
import org.example.entities.enums.OrderStatus;
import org.example.entities.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        //        Order order = new Order(1080, new Date(), OrderStatus.PENDING_PAYMENT);
//        System.out.println(order);
//
//
//        OrderStatus orderStatus = OrderStatus.DELIVERED;
//        OrderStatus orderStatus2 = OrderStatus.valueOf("DELIVERED");
//        System.out.println(orderStatus2);

        String departmentName;
        String workerName;
        String workerLevel = null;
        double workerSalary;
        double valuePerHour;
        int contractsQuantity;
        int durationHour;

        System.out.println("Empresa Ragnarook Developer");
        System.out.println("----------------------*------------------------");
        System.out.print("Enter department's name: ");
        departmentName = sc.nextLine();
        System.out.println();

        // Dados para instanciar trabalhador
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(">Enter worker data: ");
        System.out.print("Name: ");
        workerName = sc.nextLine();
        System.out.print("Level: ");
        workerSalary = sc.nextDouble();

        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel),workerSalary,new Department(departmentName));

        System.out.print("How many contracts to this worker?");
        contractsQuantity = sc.nextInt();

        // Dados para instanciar contrato
      for(int i=0; i < contractsQuantity; i++){
          System.out.printf("Enter contract #%d data:%n", i+1);
          System.out.print("Date (DD/MM/YYY): ");
          Date contractDate = simpleDateFormat.parse(sc.next());
          System.out.print("Value per hour: ");
          valuePerHour = sc.nextDouble();
          System.out.print("Duration(hours): ");
          durationHour = sc.nextInt();

          HourContract hourContract = new HourContract(contractDate,valuePerHour,durationHour);
      }

        System.out.println("Enter");
        sc.close();
    }


}