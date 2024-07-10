
    import java.util.Scanner;
    public class task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        double[] marks = new double[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + "(Between 0 to 100): ");
            marks[i] = scanner.nextDouble();
            if(marks[i]>100  ){


                break;

            }

        }

        double totalMarks = 0;
        for (double mark : marks) { if(mark>100  ){
            String grade="F";
            // System.out.println(grade);



            break;

        }
            totalMarks += mark;
        }

        double averagePercentage = totalMarks / numSubjects;
        System.out.println("Total marks obtain :"+totalMarks);
        System.out.println("average Percentage:"+averagePercentage+" %");


        String grade;
        if (averagePercentage >= 90) {
            grade = "A+";
            System.out.println(grade);
        } else if (averagePercentage >= 80) {
            grade = "A";
            System.out.println(grade);
        } else if (averagePercentage >= 70) {
            grade = "B+";
            System.out.println(grade);
        } else if (averagePercentage >= 60) {
            grade = "B";
            System.out.println(grade);
        } else if (averagePercentage >= 50) {
            grade = "C+";
            System.out.println(grade);

        } else if (averagePercentage >= 40) {
            grade = "C";
            System.out.println(grade);
        } else {
            grade = "F";
            System.out.println("Grade obtain by the student :"+grade);
        }

    }
}
    

