public class Employee{
    // Attributes
    private int empId;
    private String empName;
    private String empAddress;
    private String empPhone;
    private String empPost;

    //constructor
    public Employee(int empId, String empName, String empAddress, String empPhone, String empPost){
        this.empId = empId;
        this.empName = empName;
        this.empAddress = empAddress;
        this.empPhone = empPhone;
        this.empPost = empPost;
    }
    // Getters
    public String getEmpName(){
        return empName;
    }
    public String getEmpAddress(){
        return empAddress;
    }
    public String getEmpPhone(){
        return empPhone;
    }
    public String getEmpPost(){
        return empPost;
    }
    public int getEmpId(){
        return empId;
    }

    // setters
    public void setEmpId(int empId){
        this.empId = empId;
    }

    public void setEmpName(String empName){
        this.empName = empName;
    }

    public void setEmpAddress(String empAddress){
        this.empAddress = empAddress;
    }
    public void setEmpPhone(String empPhone){
        this.empPhone = empPhone;
    }

    public void setEmpPost(String empPost){
        this.empPost = empPost;
    }

    // method to display employee details
    @Override
    public String toString(){
        return "Employee ID: " + empId +
                "\nName: " + empName +
                "\nAddress: " + empAddress +
                "\nPhone: " + empPhone +
                "\nPost: " + empPost +
                "\n" + "-".repeat(30);
    }
}

