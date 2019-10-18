package test;

import company.*;

public class Utility {
    public static String toString(Customers customer) {
        return String.format("[%d] | Название: %s | Адрес: %s | Всего проектов: %s | Завершенных проектов: %s", customer.getId(),customer.getName(),customer.getAddress(),customer.getTotal_pnumber(),customer.getComplet_pnumber());
    }
    
    public static String toString(Managers manager) {
        return String.format("[%d] %s %s %s", manager.getId(),manager.getSurname(),manager.getName(),manager.getPatronymic());
    }

    public static String toString(Projects project) {
        return String.format("[%d] %s %s %s %s заказчик %s менеджер %s успех %s", project.getId(),project.getProject_name(),project.getStart_date(),project.getPlan_end_date(),project.getEnd_date(), project.getCustomer() != null ? toString(project.getCustomer()) : null, project.getManager() != null ? toString(project.getManager()) : null, project.getSuccess());
    }
}
