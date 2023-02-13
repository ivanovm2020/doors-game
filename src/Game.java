import java.util.Random;

public class Game {
    private Random random = new Random();
    private Strategy agree = new Strategy();
    private Strategy strong = new Strategy();

    void play(int count) {
        for (int i = 0; i < count; i++) {

            Doors doors = new Doors();
            // 1 - авто 0 - коза
            doors.values[random.nextInt(3)] = 1;
            int selectedDoor = random.nextInt(3);
            int presentedDoor;

            do {
                presentedDoor = random.nextInt(3);
            } while (doors.values[presentedDoor] == 1 || presentedDoor == selectedDoor);

            strong.wins += doors.values[selectedDoor];
            agree.wins += doors.values[3 - selectedDoor - presentedDoor];
        }

        System.out.println("Вероятность выигрыша преременчивой стратегии:  " + ((double) agree.wins * 100 / count) + " %");
        System.out.println("Вероятность выигрыша упрямой стратегии: " + ((double) strong.wins * 100 / count)  + " %");
    }
}
