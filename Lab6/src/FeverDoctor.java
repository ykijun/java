import java.util.Random;

public class FeverDoctor extends Doctor {
    /**
     * Calls the superclass' constructor
     * set the specialty of the doctor to "Fever"
     *
     * @param name
     */
    public FeverDoctor(String name) {
        // TODO: 1. initialize the name attribute of this FeverDoctor object using super class constructor
        //       2. make the specialty of the doctor to be "Fever"
        super(name);
        super.specialty= "Fever";
    }

    /**
     * FeverDoctor can only recruit fever doctors.
     *
     * After creating Doctor instance, call player's addNewlyRecruitedDoctor() to add
     * the new doctor to the doctor list.
     *
     * Finally, set occupied to true to end the turn for current doctor.
     *
     * @param name
     */
    @Override
    public void recruitDoctor(Player player, String name) {
        // TODO 1. create a new FeverDoctor object, pass the name to the constructor to initialize the name of this newly hired FeverDoctor
        //      2. add this new doctor to the player, using addNewlyRecruitDoctor() method
        //      3. once this doctor is hired, he will be occupied, set the boolean variable "occupied" accordingly
        FeverDoctor newFeverDoctor = new FeverDoctor(name);
        player.addNewlyRecruitedDoctor(newFeverDoctor);
        super.occupied = true;
    }

    /**
     * FeverDoctor can cure fever patients with 100% chance. When the patient
     * is in other categories, the chance will drop to 50% (i.e., with 0.5 probability
     * the doctor may fail to cure the patient).
     *
     * You may have to use java.util.random to model the probability. Refer to
     * generatePatientCategory() for sample usage.
     *
     * @param patient
     *
     * @return true if the patient is cured, false otherwise.
     */
    @Override
    public boolean seePatient(Patient patient) {
        // TODO 1. check the category of the patient using patient.getCategory() see if the returned string is the same as the specialty of the doctor
        //          if the category of the patient matches with the specialty of the doctor, return true to indicate the patient is cured
        //      2. if the category of the patient does not match with the speciality of the doctor, create a random object, generate a number between 0 and 99,
        //          the patient is cured only when the random number is bigger than 50 (0.5 probability). Refer to slides 39-40 of the note set below for the
        //          details of using the random object:
        //          https://course.cse.ust.hk/comp3021/notes/2-classes-objects-full.pdf
        String category = patient.getCategory();
        if (super.specialty.equals(category)){
            return true;
        }
        else{
            Random random1 = new Random();
            int ranNum = random1.nextInt(100);
            if (ranNum >50){
                return true;
            }
            else return false;
        }
    }
}
