package lab3;

class Lab3 {

    public static void main(String[] args){

        String [] strs=new String[3]; // for holding retrieved hospital name (String), established year (String), and whether it is subsidized

        System.out.println("There are a total of "+Hospital.getNumOfHospitals()+" hospital(s) in the city:\n");

        Hospital h1=new Hospital("The Grantham Hospital","1957",true);
        Hospital h2=new Hospital("The Queen Mary Hospital","1937",true);
        Hospital h3=new Hospital("The Hong Kong Adventist Hospital","1970",false);

        h1.createAndAddDept(0,"Department of Speech Therapy",30,0);
        h1.createAndAddDept(1,"Department of Medical Social Work",15,0);
        h1.createAndAddDept(2,"Department of Occupational Therapy",8,0);

        h2.createAndAddDept(0,"Department of Accident and emergency",120,20);
        h2.createAndAddDept(1,"Department of Clinical Oncology",37,85);
        h2.createAndAddDept(2,"Department of Cardiothoracic Anaesthesiology",200,20);
        h2.createAndAddDept(3,"Department of Ophthalmology",47, 0);
        h2.createAndAddDept(2,"Department of Cardiothoracic Anaesthesiology",100,10);
        h2.createAndAddDept(4,"Department of Orthopaedics and Traumatology",170,200);
        h2.createAndAddDept(5,"Department of Infectious Diseases",350,200);

        h3.createAndAddDept(0,"Department of Microbiology",20,10);
        h3.createAndAddDept(1,"Department of Radiology",25,0);
        h3.createAndAddDept(2,"Department of Neurosurgery",17,30);
        h3.createAndAddDept(3,"Department of Orthopaedics and Traumatology",47,30);
        h3.createAndAddDept(3,"Department of Orthopaedics and Traumatology",27,1000);

        System.out.println("There are a total of "+Hospital.getNumOfHospitals()+" hospital(s) in the city:\n");
        strs=h1.getInfo();
        System.out.println("<<"+strs[0]+">>");
        System.out.println(strs[2]+", established in "+strs[1]+".");
        h1.listAllDepts();

        strs=h2.getInfo();
        System.out.println("<<"+strs[0]+">>");
        System.out.println(strs[2]+", established in "+strs[1]+".");
        h2.listAllDepts();

        strs=h3.getInfo();
        System.out.println("<<"+strs[0]+">>");
        System.out.println(strs[2]+", established in "+strs[1]+".");
        h3.listAllDepts();


    }
}
