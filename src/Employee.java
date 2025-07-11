public class Employee{
    // Attributes
    private int empId;
    private String empName;
    private String empAddress;
    private String empPhone;
    private String empPost;
    private int empAge;
    private long empSalary;

    //constructor
    public Employee(int empId, String empName, String empAddress, String empPhone, String empPost, int empAge, long empSalary){
        this.empId = empId;
        this.empName = empName;
        this.empAddress = empAddress;
        this.empPhone = empPhone;
        this.empPost = empPost;
        this.empAge = empAge;
        this.empSalary = empSalary;
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
    public int getEmpAge(){
        return empAge;
    }
    public long getEmpSalary(){
        return empSalary;
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

    public void setEmpAge(int empAge){
        this.empAge = empAge;
    }
    public void setEmpSalary(long empSalary){
        this.empSalary = empSalary;
    }

    // method to display employee details
    @Override
    public String toString(){
        return "Employee ID: " + empId +
                "\nName: " + empName +
                "\nAddress: " + empAddress +
                "\nPhone: " + empPhone +
                "\nPost: " + empPost +
                "\nAge: " + empAge +
                "\nSalary: " + empSalary +
                "\n" + "-".repeat(30);
    }
}

