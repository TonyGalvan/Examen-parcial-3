package oop.exams.generator;

import oop.exams.exception.BadRegionException;

import java.util.Random;

public class NorthLicensePlateGenerator implements LicensePlateGenerator {
    @Override
    public String generate(String state) {
        String licensePlate = "1";
        Random random = new Random();

        if (state.startsWith("X")) {
            throw new BadRegionException("Allowed state codes: BCN, BCS, CHH, COA, NLE, SON, TAM");
        } else {
            licensePlate += state;
            for (int i = 0; i<2; i++) {
                licensePlate += random.nextInt(10);
            }
        }

        return licensePlate;

    }
}
