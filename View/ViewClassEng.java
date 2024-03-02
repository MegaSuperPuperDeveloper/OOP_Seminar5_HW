package View;

import Controller.Interfaces.*;
import Model.Domain.Student;

import java.util.List;
import java.util.Scanner;

public class ViewClassEng implements iGetView{
    public void printAllStudent(List<Student> students) { // Out a List of Students
        System.out.println("-----List of Students-----");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("--------------------------");
    }

    public String prompt(String msg) { // Получение команды
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg);
        return scanner.next();
    }
}
