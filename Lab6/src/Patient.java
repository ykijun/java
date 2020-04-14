public class Patient {
    private String category;

    public Patient(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return String.format("%s patient", category);
    }
}
