import java.util.Random;

public class SurgicalDoctor extends Doctor {
    /**
     * Calls the superclass' constructor
     * set the specialty of the doctor to "Surgical"
     *
     * @param name
     */
    public SurgicalDoctor(String name) {
        // TODO: 1. initialize the name attribute of this SurgicalDoctor object using super class constructor
        //       2. make the specialty of the doctor to be "Surgical"
        super(name);
        super.specialty = "Surgical";
    }

    /**
     * Surgical doctor has higher training cost, 2 times the normal training cost
     *
     * @return training cost
     */
    @Override
    public int getTrainingCost() {
        // TODO: 1. the training cost of Surgical doctor is 2 * super.getTrainingCost()
        return 2*super.getTrainingCost();
    }

    /**
     * SurgicalDoctor can only recruit surgical doctors.
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
        // TODO 1. create a new SurgicalDoctor object, pass the name to the constructor initialize the name of this newly hired SurgicalDoctor
        //      2. add this new doctor to the player, using addNewlyRecruitDoctor() method
        //      3. once this doctor is hired, he will be occupied, set the boolean variable "occupied" accordingly
        SurgicalDoctor newSurDoc = new SurgicalDoctor(name);
        player.addNewlyRecruitedDoctor(newSurDoc);
        super.occupied = true;
    }

    /**
     * SurgicalDoctor can cure surgical patients with 100% chance. When the patient
     * is in other categories, the chance will drop to 80% (i.e., with 0.2 probability
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
