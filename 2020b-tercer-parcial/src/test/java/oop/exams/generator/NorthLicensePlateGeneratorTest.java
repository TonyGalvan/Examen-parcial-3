package oop.exams.generator;

import oop.exams.exception.BadRegionException;
import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NorthLicensePlateGeneratorTest {

    @Test
    public void givenANorthState_whenGenerate_thenLicensePlateStartsWith1() {

        // Given:
        LicensePlateGenerator licensePlateProvider = new NorthLicensePlateGenerator();
        String state = "SON";

        // When:
        String licensePlate = licensePlateProvider.generate(state);

        // Then:
        assertThat(licensePlate).startsWith("1");
        assertThat(licensePlate.substring(1)).startsWith(state);
        assertThat(licensePlate).hasSize(6);
        assertThat(licensePlate.substring(4)).containsOnlyDigits();
    }

    @Test
    public void givenANorthState_whenGenerateTwice_thenLicensesAreDifferent() {

        // Given:
        LicensePlateGenerator licensePlateProvider = new NorthLicensePlateGenerator();

        // When:
        String licensePlate1 = licensePlateProvider.generate("CHH");
        String licensePlate2 = licensePlateProvider.generate("CHH");

        // Then:
        assertThat(licensePlate1).isNotEqualTo(licensePlate2);
    }

    @Test
    public void givenANonNorthState_whenGenerate_thenBadRegionExceptionIsThrown() {

        // Given:
        LicensePlateGenerator licensePlateProvider = new NorthLicensePlateGenerator();
        String randomStateAbbreviation = "X" + RandomString.make(2);

        // When:
        // Then:
        assertThatThrownBy(() -> licensePlateProvider.generate(randomStateAbbreviation))
                .isInstanceOf(BadRegionException.class)
                .hasMessage("Allowed state codes: BCN, BCS, CHH, COA, NLE, SON, TAM");
    }
}
