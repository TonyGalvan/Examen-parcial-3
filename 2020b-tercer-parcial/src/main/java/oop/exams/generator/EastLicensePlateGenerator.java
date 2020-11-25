package oop.exams.generator;

import oop.exams.exception.BadRegionException;

import java.util.Random;

public class EastLicensePlateGenerator implements LicensePlateGenerator {

    @Override
    public String generate(String state) {

        String licensePlate = "3";
        Random random = new Random();

        if (state.startsWith("X")) {
            throw new BadRegionException("Allowed state codes: CAM, ROO, TAB, VER, YUC");
        } else
            for (int i = 1; i < 3; i++) {
                licensePlate += random.nextInt(10);
            }
            licensePlate+="Z";
        return licensePlate;

    }
}
