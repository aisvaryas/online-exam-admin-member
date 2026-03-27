
import java.util.*;



public class Main{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        Questiondao qd= new QuestiondaoImpl();
        Memberdao md = new MemberdaoImpl();

        qd.connect();
        md.connect();

        while (true) {

           System.out.println("menu");
            System.out.println("1. add qs       ADMIN");
            System.out.println("2. view qs      ADMIN");
            System.out.println("3. update qs    ADMIN");
            System.out.println("4. register     MEMBER");
            System.out.println("5. Give Exam    MEMBER");
            System.out.println("6. Exit");

            int ch= sc.nextInt();

            switch(ch){
                case 1:
                    sc.nextLine();

                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Question: ");
                    String text = sc.nextLine();

                    System.out.print("Option A: ");
                    String a = sc.nextLine();

                    System.out.print("Option B: ");
                    String b = sc.nextLine();

                    System.out.print("Option C: ");
                    String c = sc.nextLine();

                    System.out.print("Option D: ");
                    String d = sc.nextLine();

                    System.out.print("Correct Answer: ");
                    char ans = sc.next().charAt(0);

                    Question q = new Question(id, text, a, b, c, d, ans);
                    qd.addq(q);
                    break;

                case 2:
                    qd.viewq();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new question: ");
                    String newqs = sc.nextLine();

                    qd.updateq(uid, newqs);
                    break;

                case 4:
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name1 = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email1 = sc.nextLine();

                    Member m = new Member(name1, email1);
                    md.reg(m);
                    break;

                case 5:
                    qd.qspaper();
                    break;

                case 6:
                    System.out.println("Exit");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }

            
    }
}
