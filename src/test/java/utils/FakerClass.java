package utils;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class FakerClass {

    private static final Faker faker = new Faker();
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMddyyyy"); // Format MMddyyyy


    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getStreetAddress() {
        return faker.address().streetAddress();
    }

    public static String getCity() {
        return faker.address().city();
    }

    public static String getStateAbbreviation() {
        return faker.address().stateAbbr(); // Returns state in 2-letter format (e.g., "GA")
    }

    public static String getZipCode() {
        return faker.address().zipCode();
    }

    public static String getDateOfBirth() {
        LocalDate today = LocalDate.now();
        LocalDate minDOB = today.minusYears(65); // Oldest possible DOB (65 years ago)
        LocalDate maxDOB = today.minusYears(18); // Youngest possible DOB (18 years ago)

        long minEpochDay = minDOB.toEpochDay();
        long maxEpochDay = maxDOB.toEpochDay();

        // Generate a random date within the range
        long randomDay = ThreadLocalRandom.current().nextLong(minEpochDay, maxEpochDay);
        LocalDate randomDOB = LocalDate.ofEpochDay(randomDay);

        return randomDOB.format(dateFormatter); // Returns date in MMddyyyy format
    }

    public static String getLoanAmount() {
        return String.valueOf(faker.number().numberBetween(1000, 35000)); // Loan amount between 1,000 and 50,000
    }
}
