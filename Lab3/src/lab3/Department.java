package lab3;

public class Department {
    private int deptID;
    private String deptName;
    private int numOfMedicalStaffs;
    private int bedCapacity;

    Department(int deptID,String deptName,int numOfMedicalStaffs, int bedCapacity){
        this.deptID = deptID;
        this.deptName = deptName;
        this.numOfMedicalStaffs = numOfMedicalStaffs;
        this.bedCapacity = bedCapacity;
    }
    int getDepartmentID(){
        return this.deptID;
    }
    String getDepartmentName(){

        return this.deptName;
    }
    int getBedCapacity(){
        return this.bedCapacity;
    }
    int getMedicalStaffNum(){
        return this.numOfMedicalStaffs;
    }
    void printDepartment(){
        System.out.println("["+ this.getDepartmentName()+"],  Medical staff number: " +
                this.getMedicalStaffNum() +", Bed number:  " + this.getBedCapacity());
    }
}
