package Constructor;
class Employee
{
 double Empno,hra,da,it,gp,salary;
 String Name;
  Employee(String nam,int no,int basic)
 {
     Name=nam;
     Empno=no;
     salary=basic;
    }
     
  void calc()
  {
      hra=(0.1f)*salary;
      da=(5.55f)*salary;
      it=(0.06f)*salary;
      gp=(salary+hra+da)-it;
    }
    void unit()
    {
    }
    void Display()
    {
        System.out.println("\t\t\tSALARY SLIP\t\t");
        System.out.println("Employee Number  "+Empno);
        System.out.println("Name  "+Name);
        System.out.println("Basic Pay  "+salary);
        System.out.println("House Rent Allowance(HRA) "+hra);
        System.out.println("Dearness Allowance(DA) "+da);
        System.out.println("Income Tax Deduction(IT) "+it);
        System.out.println("Gross Pay(GP) "+gp);
    }
}
        
     
