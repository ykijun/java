package lab3;

public class Hospital {
    private String name;
    private String startYear;
    private boolean subsidized;
    private static int numOfHospitals;
    private int arraySize;
    private int numOfDepartments;
    private Department[] department;

    Hospital(String name, String startYear, boolean subsidized){
        this.name = name;
        this.startYear = startYear;
        this.subsidized = subsidized;
        this.numOfHospitals++;
        this.arraySize = 2;
        this.department = new Department[this.arraySize] ;
        this.numOfDepartments = 0;
    }
    String[] getInfo(){
        String info[] = new String[3];
        info[0] = this.name;
        info[1] = this.startYear;
        if (this.subsidized){
            info[2] = "Subsidized hospital";
        }
        else{
            info[2] = "Private hospital";
        }
        return info;
    }
    boolean createAndAddDept(int deptID, String deptName, int numOfMedicalStaffs, int bedCapacity){
        if (this.numOfDepartments == 0){
            this.department [0] = new Department(deptID,deptName,numOfMedicalStaffs,bedCapacity);
            this.numOfDepartments++;
            return true;
        }
        for (int i = 0; i < this.numOfDepartments; i++){
            if (this.department[i].getDepartmentID() == deptID){
                return false;
            }
        }
        if (this.numOfDepartments == this.arraySize){
            this.arraySize += 2;
            Department[] depts = new Department[this.arraySize];
            for (int i = 0; i < numOfDepartments; i++){
                depts[i] = this.department[i];
            }
            depts[numOfDepartments++] = new Department(deptID,deptName,numOfMedicalStaffs,bedCapacity);
            this.department = depts;
        }
        else{
            this.department[this.numOfDepartments] = new Department(deptID,deptName,numOfMedicalStaffs,bedCapacity);
            this.numOfDepartments++;
            return true;
        }




        return true;
    }

    void listAllDepts(){
        System.out.println("Here is the list of all the departments of "+ this.name + " :");
        for (int i = 0; i <  this.numOfDepartments; i++) {
            this.department[i].printDepartment();
        }
        System.out.println("This hospital has total of " + this.getTotalMedicalStaffNum() + " staff(s)");
        System.out.println("This hospital has a total capacity of " + this.getTotalBedNum() + " bed(s)");
        System.out.println();

    }
    int getTotalBedNum(){
        int totalBed = 0;
        for (int i = 0; i < this.numOfDepartments; i++){
            totalBed += this.department[i].getBedCapacity();
        }
        return totalBed;
    }
    int getTotalMedicalStaffNum(){
        int totalMStaff = 0;
        for (int i = 0; i <this.numOfDepartments; i++){
            totalMStaff += this.department[i].getMedicalStaffNum();
        }
        return totalMStaff;
    }
    static int getNumOfHospitals(){
        return numOfHospitals;
    }

}
