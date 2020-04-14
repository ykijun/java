import java.util.Random;

public class MinisterDoctor extends Doctor {
    /**
     * Calls the superclass' constructor
     * set the specialty of the doctor to "Minister"
     *
     * @param name
     */
    public MinisterDoctor (String name) {
        // TODO: 1. initialize the name attribute of this MinisterDoctor object using super class constructor
        //       2. make the specialty of the doctor to be "Minister"
        super(name);
        super.specialty = "Minister";
    }

    /**
     * MinisterDoctor can recruit any type of doctor. So here you have to
     * randomly generate a doctor with equal probability being in each of
     * the four subclasses (Minister, Fever, Medical and Surgical). You may
     * use java.util.random for random generation, refer to generatePatientCategory()
     * for detailed usage.
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
        // TODO 1. Since MinisterDoctor can hire a FeverDoctor, a MedicalDoctor, and SurgicalDoctor and also a MinisterDoctor all with 25% of chance
        //         so you may want to use a Random object to generate a random int from 0-3, and then for each value of the random int, you let this
        //         minister doctor to hire a different kind of doctor (i.e. Doctor dr=new FeverDoctor(name) if that random int is 0, and then
        //         Doctor dr=new MedicalDoctor(name) when the random int is 1, and so on...)
        //         Refer to slides 39-40 of the note set below for the details of using the random object:
        //         https://course.cse.ust.hk/comp3021/notes/2-classes-objects-full.pdf
        //      2. add this new doctor object to the player, using addNewlyRecruitDoctor() method
        //      3. once this doctor is hired, he will be occupied, set the boolean variable "occupied" accordingly
        Random random = new Random();
        int ranNum = random.nextInt(4);
        switch (ranNum){
            case 1:
                MedicalDoctor newMedDoc = new MedicalDoctor(name);
                player.addNewlyRecruitedDoctor(newMedDoc);
                super.occupied = true;
                break;
            case 2:
                SurgicalDoctor newSurDoc = new SurgicalDoctor(name);
                player.addNewlyRecruitedDoctor(newSurDoc);
                super.occupied = true;
                break;
            case 3:
                MinisterDoctor newMinDoc = new MinisterDoctor(name);
                player.addNewlyRecruitedDoctor(newMinDoc);
                super.occupied = true;
                break;
            default:
                FeverDoctor newFevDoc = new FeverDoctor(name);
                player.addNewlyRecruitedDoctor(newFevDoc);
                super.occupied = true;
                break;
        }

    }

    /**
     * Minister doctor is better at raising fund than other types of doctor.
     *
     * @return 1000 times (1 + 0.1 times the skillLevel)
     */
    @Override
    public int raiseFund() {
        // TODO 1. return an int value of  1000 * (1 + 0.1 * specialSkillLevel)
        double returnVal = 1000*(1+0.1*super.specialSkillLevel);
        return (int)returnVal;
    }

    /**
     * The minister doctor is good at getting discount when upgrading the hospital.
     *
     * @return 1.0 - 0.1 times the specialSkillLevel
     */
    @Override
    public double getUpgradeDiscountRate() {
        // TODO 1. return a double value of  1 - 0.1 * specialSkillLevel;
        double returnVal = 1-0.1*super.specialSkillLevel;
        return returnVal;
    }

    /**
     * MinisterDoctor is specialized in administration. So for any type of patient,
     * a minister doctor only has 50% chance to cure them (i.e., with 0.5 probability
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
