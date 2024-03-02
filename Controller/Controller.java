package Controller;

import Model.ModelClass;
import Model.Domain.Student;
import Controller.Interfaces.*;
import View.ViewClass;
import View.ViewClassEng;

import java.util.*;

public class ControllerClass {

    private iGetModel modelClass;
    private iGetView viewClass;
    private List<Student> students = new ArrayList<>();
    private HashMap<String, iGetView> languageViewMap = new HashMap<>();


    public ControllerClass(iGetModel modelClass, iGetView viewClass ) {
        this.modelClass = modelClass;
        this.viewClass = viewClass;
    }


    private boolean testData(List<Student> students) { // Проверка на наличие элементов в списке
        if (students.size() > 0) return true;
        return false;
    }

    public void update() { // Запуск без Command
        // MVC
        // viewClass.printAllStudent(modelClass.getStudents());

        //MVP
        students = modelClass.getAllStudent();
        if (testData(students)) viewClass.printAllStudent(modelClass.getAllStudent());
        else System.out.println("Список пуст!");
    }

    public void run() { // Запуск с Command
        Command com = Command.NONE;
        boolean getNewIteration = true;
        while (getNewIteration) {
            String command = viewClass.prompt("Введи команду: ");
            com = Command.valueOf(command.toUpperCase());
            switch (com) {
                case EXIT:
                    getNewIteration = false;
                    System.out.println("Выход из программы!");
                    break;
                case LIST:
                    viewClass.printAllStudent(modelClass.getAllStudent());
                    break;
                case DELETE:
                    Scanner scanner = new Scanner(System.in);
                    int number = scanner.nextInt();
                    try {
                        modelClass.removeFromList(number);
                    } catch(ArrayIndexOutOfBoundsException e) {
                        System.out.println("Такого студента нет в списке!");
                    }
            }
        }
    }

}