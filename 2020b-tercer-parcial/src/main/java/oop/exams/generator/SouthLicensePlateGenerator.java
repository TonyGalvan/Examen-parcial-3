package oop.exams.generator;

import oop.exams.exception.BadRegionException;

import java.util.Random;

public class SouthLicensePlateGenerator implements LicensePlateGenerator {
    @Override
    public String generate(String state) {

        String licensePlate = "4";
        Random random = new Random();
        int statePosition = 0;

        if (state.startsWith("X")) {
            throw new BadRegionException("Allowed state codes: CHP, GRO, MIC, OAX");
        } else
            statePosition = 1+random.nextInt(4);

            switch (statePosition){
                case 1: licensePlate+=state;
                        licensePlate += random.nextInt(10);
                        licensePlate += random.nextInt(10);
                        licensePlate += random.nextInt(10);
                        break;
                case 2: licensePlate += random.nextInt(10);
                        licensePlate+=state;
                        licensePlate += random.nextInt(10);
                        licensePlate += random.nextInt(10);
                        break;
                case 3: licensePlate += random.nextInt(10);
                        licensePlate += random.nextInt(10);
                        licensePlate+=state;
                        licensePlate += random.nextInt(10);
                        break;
                case 4: licensePlate += random.nextInt(10);
                        licensePlate += random.nextInt(10);
                        licensePlate += random.nextInt(10);
                        licensePlate+=state;
                        break;

            }
        return licensePlate;

    }
}
