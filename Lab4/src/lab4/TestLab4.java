package lab4;

public class TestLab4 {

    public static void main(String[] args) {

        System.out.println("Main in TestLab4 started\n");

        MedicalStaff.printMedicalStaffAllocation();
        System.out.printf("Total number of medical staff(s) is %d\n\n", MedicalStaff.returnNumOfMedicalStaffs());

        MedicalStaff amy= new MedicalStaff("Amy","10/10/1993 09:00:00");
        MedicalStaff betty= new MedicalStaff("Betty","01/31/1997 09:00:00");
        MedicalStaff christ= new MedicalStaff("Christ","01/22/2008 14:00:00");
        MedicalStaff danny= new MedicalStaff("Danny","07/10/2019 14:00:00");
        MedicalStaff eric= new MedicalStaff("Eric","01/25/2020 10:00:00");
        System.out.printf("Total number of medical staff(s) is %d\n\n", MedicalStaff.returnNumOfMedicalStaffs());
        amy.addToDepartment("Department of Accident and emergency");
        betty.addToDepartment("Department of Clinical Oncology");
        christ.addToDepartment("Department of Clinical Oncology");
        christ.addToDepartment("Department of Clinical Oncology");
        danny.addToDepartment("Department of Clinical Oncology");
        eric.addToDepartment("Department of Cardiothoracic Anaesthesiology");
        System.out.println();
        amy.leaveDepartment("Department of Clinical Oncology");
        amy.leaveDepartment("Department of Accident and emergency");
        amy.addToDepartment("Department of Clinical Oncology");
        System.out.println();
        MedicalStaff.printAllMedicalStaffs("Department of Accident and emergency");
        MedicalStaff.printAllMedicalStaffs("Department of Clinical Oncology");
        MedicalStaff.printAllMedicalStaffs("Department of Cardiothoracic Anaesthesiology");
        System.out.println();
        MedicalStaff.printMedicalStaffAllocation();

    }

}
