import java.util.ArrayList;
import java.util.List;

public class Player {
    final private String name;
    private List<Doctor> doctors = new ArrayList<>();

    public Player (String name) {
        this.name = name;
        Doctor doctor = new MinisterDoctor(name);
        doctors.add(doctor);
    }

    public String getName() {
        return name;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public boolean allDoctorOccupied() {
        for (Doctor doctor: getDoctors()) {
            if (!doctor.isOccupied()) return false;
        }
        return true;
    }

    public void addNewlyRecruitedDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.printf("Newly recruited %s\n", doctor);
    }

    @Override
    public String toString() {
        return String.format("Player: %s | doctors: %d",
                name, getDoctors().size());
    }
}
