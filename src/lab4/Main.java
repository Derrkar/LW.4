package lab4;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Worker worker1 = new Worker.Builder().withSurname("Grod").withName("Eugen").withMiddleName("Volodumurovich").withAge(24).build();
        Worker worker2 = new Worker.Builder().withSurname("Petrov").withName("Ivan").withMiddleName("Stepanovuch").withAge(20).build();
        Worker worker3 = new Worker.Builder().withSurname("Matsuk").withName("Olexandre").withMiddleName("Muhaulovuch").withAge(21).build();
        Worker worker4 = new Worker.Builder().withSurname("Pastyla").withName("Grugoriu").withMiddleName("Eugenovuch").withAge(23).build();
        Worker worker5 = new Worker.Builder().withSurname("Lakysta").withName("Maksum").withMiddleName("Mukolaevuch").withAge(26).build();

        List<Worker> workers = new ArrayList<Worker>();
        workers.add(worker1);
        workers.add(worker2);
        workers.add(worker3);
        workers.add(worker4);
        workers.add(worker5);

        Project project = new Project.Builder().withProjectName("GitHub").withWorkerList(workers).build();
    }
}
