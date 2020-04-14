package lab4;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class MedicalStaff {

    // in the variables below, replace ??? with the "static" keyword or an empty space
    private static Departments departments = Departments.getDepartmentsObj();
    private int medicalStaffID;
    private String name;
    private Date joinDate;
    private static Date currentDate;
    private int assignedDepartmentNumber=0;
    private static int numOfMedicalStaffs=0;
    private static final int maxDepartmentNumber=1;//One medical staff can only be assigned to a max of one department



    public MedicalStaff(String name, String joinDate) {//construct new MedicalStaff obj, medicalStaffID equals to numOfMedicalStaffs, after that add 1 to numOfMedicalStaffs to update it
        medicalStaffID=numOfMedicalStaffs;            // joinDate = the date/time the medical staff joined the hospital, set medicalStaffID of that staff to be the same as the current numOfMedicalStaffs
        numOfMedicalStaffs++;
        this.name=name;
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss"); // tells Java the format of the Date information being stored in a String
        try{// ignore this part at this point, we add this because the parse method of Dateformat class would generate an exception, and in Java we need to use try-catch to enclose any method that would generate this kind of exception
            this.joinDate=df.parse(joinDate);


        } catch (ParseException e){
            e.printStackTrace();
        }

        currentDate=new Date();
        int joinedDays=(int)((currentDate.getTime()-this.joinDate.getTime())/(24*60*60*1000)); //when you do the division (long)/(int), the result will be long, so we need to cast it to int


        System.out.printf("MedicalStaff %s joined the hospital on %s, he/she has joined the hospital for %d days.\n",this.name,this.joinDate,joinedDays);

    }


    public static int returnNumOfMedicalStaffs() {
        return numOfMedicalStaffs;
    }

    public Integer returnID() {
        return medicalStaffID;
    }


    public void addToDepartment(String departmentName) {
        // assume a *department in the hospital is uniquely identified by its "departmentName"*
        // First check to see if this medical staff has been assigned one department (i.e. assignedDepartmentNumber==maxDepartmentNumber)
        // if this is the case, then return immediately without running the addMedicalStaff() method of the departments object.
        // otherwise try to add him/her to the department using the provided addMedicalStaff() method of the departments object
        // the provided addMedicalStaff() method will return true if the medical staff is successfully added to the department
        // otherwise the addMedicalStaff() method will return false (i.e. the medical staff has already joined the department).
        // Use the return value from addMedicalStaff() to output proper sentence (see the lab description)
        // if the medical staff is successfully added to a department, remember to increase his/her assignedDepartmentNumber by 1.
        if (this.assignedDepartmentNumber == maxDepartmentNumber){
            System.out.println("MedicalStaff " + this.name + " not added to the " + departmentName + ", max number of departments assigned");
            return;
        }
        else{
            if(this.departments.addMedicalStaff(this, departmentName)) {
                System.out.println("MedicalStaff " + this.name + " joins the " + departmentName +".");
                this.assignedDepartmentNumber += 1;
                return;
            }

            else{
                System.out.println("Medical Staff " + this.name + " not added to the " + departmentName + ", max number of departments assigned");
                return;
            }
        }



    }

    public void leaveDepartment(String departmentName) {
        // remove the medical staff from the department with its name equals to departmentName using the provided removeMedicalStaff() method of the departments object
        // the removeMedicalStaff() method will remove the medical staff only if he/she is found in the department, otherwise it will return false
        // use this return value to decide what to be outputted (see the lab description)
        // if a medicalStaff successfully left a department remember to decrease his/her assignedDepartmentNumber by 1.
        if (this.departments.removeMedicalStaff(this, departmentName)){
            System.out.println("Medical Staff " + this.name + " has left the " + departmentName +".");
            this.assignedDepartmentNumber -= 1;
            return;
        }
        else {
            System.out.println("Medical Staff " + this.name + " is not in the " + departmentName + ", not left!");
            return;
        }

    }

    public static void printAllMedicalStaffs(String departmentName) {

        // get all the medical staffs working for the department (name of the department being departmentName) using the getAllMedicalStaffs() method provided in the departments object
        // the getAllMedicalStaffs() method will return an array of medical staffs. You need to output the proper message according to the return value from getAllMedicalStaffs() method
        // see the lab description for what to be outputted.
        // hint,:if you wish to concatenate a string, for example if you wish to concatenate the String "output" with a message, you can do that:
        // output=output+"adding new content to output";
        System.out.println("The following is/are all the medicalStaff(s) of the department "+ departmentName + ":");
        if (departments.getAllMedicalStaffs(departmentName).length == 0){
            System.out.println("No medicalStaff!");
            return;
        }

        else{
            String output = "";
            MedicalStaff[] med = departments.getAllMedicalStaffs(departmentName);
            for(int i= 0; i < med.length; i++ ) {
                output += med[i].name + ", ";
            }
            System.out.println(output);
        }


    }

    public static void printMedicalStaffAllocation() { // print the staff allocation of each of the departments
        String strs[] = departments.getAllDepartmentNames(); // keep this
        // remember for an arbitrary array a[], a.length indicates the number of elements in a[], in the case here it indicates the number of different departments in the "departments" object
        // print the total number of medical staff(s) that has been assigned to each of the departments,
        // you may find getAllMedicalStaffs() of the departments object useful.
        // when there is no department (i.e. strs[] above is empty) output ""No department in the system!"
        // output message according to the size of strs[].
        // again see the lab description to see what to output.
        if (strs.length == 0){
            System.out.println("No department in the system!");
        }
        else {
            for (int i = 0; i < strs.length; i++){
                System.out.println("The "+ strs[i] + ", has a total of " + departments.getAllMedicalStaffs(strs[i]).length + " medicalStaff(s).");
            }
        }

    }
}
