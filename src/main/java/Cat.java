import javax.swing.*;
import java.util.Random;

public class Cat {

    public static void main(String[] args) {

        Random random = new Random();
        Action[] actions = new  Action[3];

        int distance = random.nextInt(10);
        int heigth = random.nextInt(10);
        actions[0] = new Human ("Ivan", distance, heigth);

        distance = random.nextInt(10);
        heigth = random.nextInt(10);
        actions[0] = new Robot("C3PO", distance, heigth);

        distance = random.nextInt(10);
        heigth = random.nextInt(10);
        actions[0] = new Cat("Uzh", distance, heigth);

        Barrier[] barriers = new Barrier[6];

        boolean isRoad;
        for (int i = 0; i < barriers.length; i++) {
            distance = random.nextInt(10);
            isRoad = random.nextBoolean();
            if (isRoad) {
                barriers[i] = new Road("Road" + i, distance);
            } else {
                barriers[i] = new Wall("Wall" + i, distance);
            }
        }
        for (int i = 0; i < actions.length; i++) {
            boolean result = true;
            for (int j = 0; j < barriers.length; j++) {
                result = barriers[j].moving(actions[i]);

                if (!result) {
                    break;
                }
            }

            if (result) {
                System.out.println("Success");
            } else {
                System.out.println("Unsuccessfully");
            }


        }
    }


}
