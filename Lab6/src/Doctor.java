public abstract class Doctor {
    // This is an abstract class, you can think of it as the ABC
    // (Abstract Base Class) of C++
    // This class collects the common attributes (instance variables)
    // of the different categories of doctors.
    // This class also collects the common behaviors (methods)
    // of the different categories of doctors.
    // Attributes
    protected int specialSkillLevel;
    protected String name;
    protected String specialty;
    protected boolean occupied;

    /**
     * Initializes the attributes of a doctor
     * initially doctor has skillLevel 0 and isOccupied is set to true
     *
     * @param name the doctor's name
     */
    protected Doctor(String name) {
        this.name = name;
        this.specialSkillLevel = 0;
        this.occupied = true;
    }

    /**
     * Get name
     *
     * @return the doctor's name
     */
    public String getName() {
        return name;
    }

    /**
     * Get occupied status
     *
     * @return if the doctor has been occupied
     */
    public boolean isOccupied() {
        return occupied;
    }

    /**
     * Get doctor specialty
     *
     * @return the doctor's specialty
     */
    public String getSpecialty() {
        return specialty;
    }

    /**
     * At start of each turn, set occupied to false so as to refresh
     * doctor's status
     */
    public void beginTurn() {
        occupied = false;
    }

    /**
     * By default, the upgrade cost for doctor is 1000 times (level + 1).
     *
     * @return the amount of cost to increase the skillLevel
     */
    public int getTrainingCost() {
        return 1000 * (specialSkillLevel + 1);
    }

    /**
     * By default, doctor can raise 1000 each time.
     *
     * @return the amount of money raised
     */
    public int raiseFund() {
        return 1000;
    }

    /**
     * By default, doctor has no discount when doing hospital upgrading.
     *
     * @return 1.0
     */
    public double getUpgradeDiscountRate() {
        return 1.0;
    }

    /**
     * According to the patient's category and the doctor's specialty,
     * decide if the doctor can successfully cure the patient
     *
     * @param patient
     *
     * @return if the patient is cured
     */
    public abstract boolean seePatient(Patient patient);

    /**
     * According to the doctor's specialty, decide which type of new
     * doctor is recruited, and add the doctor to the player's doctorList
     *
     * @param player the current player
     * @param name the new doctor's name
     */
    public abstract void recruitDoctor(Player player, String name);

    @Override
    public String toString() {
        return String.format("Doctor %s, specialized in %s", name, specialty);
    }
}
