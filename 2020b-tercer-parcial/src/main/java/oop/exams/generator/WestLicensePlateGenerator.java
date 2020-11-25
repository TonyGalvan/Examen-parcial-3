package oop.exams.generator;

import oop.exams.exception.BadRegionException;

import java.util.Random;

public class WestLicensePlateGenerator implements LicensePlateGenerator {
    @Override
    public String generate(String state) {

        String licensePlate = "2";
        Random random = new Random();

        if (state.startsWith("X")) {
            throw new BadRegionException("Allowed state codes: COL, JAL, NAY, SIN");
        } else
            licensePlate += random.nextInt(10);
            licensePlate += state;

        return licensePlate;

    }
}
