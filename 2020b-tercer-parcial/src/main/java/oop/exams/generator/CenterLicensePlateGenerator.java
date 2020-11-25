package oop.exams.generator;

import oop.exams.exception.BadRegionException;

import java.util.Random;

public class CenterLicensePlateGenerator implements LicensePlateGenerator {

    @Override
    public String generate(String state) {
        String licensePlate = "5";
        Random random = new Random();

        if (state.startsWith("X")) {
            throw new BadRegionException("Allowed state codes: AGU, CMX, DUR, GUA, HID, MEX, PUE, QUE, SLP, TLA, ZAC");
        } else
            for (int i = 1; i < 8; i++) {
                licensePlate += random.nextInt(10);
            }
        return licensePlate;
    }
}
