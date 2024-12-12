package airlines;


import pojos.Employee;

public class CompareObjects {

    public static void main(String[] args){
        Employee employee1=new Employee(1,"shashank");
        Employee employee2=new Employee(1,"shashank");

       // System.out.println(employee1==employee2);
        System.out.println(employee1.equals(employee2));
    }
}
