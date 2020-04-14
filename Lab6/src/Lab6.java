import java.util.Random;

public class Lab6 {
    public static String generatePatientCategory() {
        Random rand = new Random();
        int randNum = rand.nextInt(3);
        if (randNum == 0) {
            return "Fever";
        } else if (randNum == 1) {
            return "Medical";
        } else {
            return "Surgical";
        }
    }

    public static String generateDoctorName() {
        Random rand = new Random();
        int digit = rand.nextInt(100);
        return "rand#" + digit;
    }

    public static void printPlayerInfo(Player player) {
        System.out.println(player);
    }

    public static Doctor simulateSelectDoctor(Player player) {
        // select the first available doctor
        for (Doctor doctor: player.getDoctors()) {
            if (!doctor.isOccupied()) return doctor;
        }
        return null;
    }

    public static void simulateDoctorAction(Player player, Doctor doctor) {
        doctor.recruitDoctor(player, generateDoctorName());
    }

    public static void simulatePlayerTurn(Player player) {
        printPlayerInfo(player);

        System.out.printf("\n### Start automatic pre processing for player %s\n", player.getName());
        System.out.printf("### Refresh doctor status... \n");
        for (Doctor doctor: player.getDoctors()) {
            doctor.beginTurn();
        }

        // keep simulate doctor's action until all doctors are occupied
        while(!player.allDoctorOccupied()) {
            Doctor doctor = simulateSelectDoctor(player);
            if (doctor == null) break;
            simulateDoctorAction(player, doctor);
        }

        printPlayerInfo(player);

        // let all doctors see patients
        System.out.printf("\n### Start automatic post processing for player %s\n", player.getName());
        for (Doctor doctor: player.getDoctors()) {
            Patient patient = new Patient(generatePatientCategory());
            boolean success = doctor.seePatient(patient);
            if (success) {
                System.out.printf("%s has cured a %s\n", doctor, patient);
            } else {
                System.out.printf("%s has failed a %s\n", doctor, patient);
            }
        }
    }

    public static void main(String args[]) {
        Player henry = new Player("Henry");
        Player steven = new Player("Steven");

        int numOfTurns = 3;

        for (int i=0; i<numOfTurns; i++) {
            // Henry's turn
            System.out.printf("\n\n\t--- Season %d | %s's turn ---\n\n", i, henry.getName());
            simulatePlayerTurn(henry);

            // Steven's turn
            System.out.printf("\n\n\t--- Season %d | %s's turn ---\n\n", i, steven.getName());
            simulatePlayerTurn(steven);
        }
    }
}
