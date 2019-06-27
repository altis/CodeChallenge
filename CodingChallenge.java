import java.util.*;

class JobClass{
    char job;
    char dependancy;
    JobClass(char a, char d){
        job = a;
        dependancy = d;
    }
}
class CodingChallenge {
    ArrayList<JobClass> jobs_list;
    CodingChallenge(){
       jobs_list = new ArrayList<JobClass>();
    }
    public void inputJobs(){
        Scanner scanner = new Scanner(System. in);
        String job = "";
        do{
            job = scanner. nextLine();
            if(!new String("submit").equals(job)) {

                System.out.println(job.charAt(0));

                if(job.length()==6){
                    System.out.println(job.charAt(5));
                    jobs_list.add(new JobClass(job.charAt(0),job.charAt(5)));
                }else jobs_list.add(new JobClass(job.charAt(0),' '));
            }
            else
                break;
        }while(true);
    }
    public void printJobs(){
        int count = 0;
        StringBuilder toPrint = new StringBuilder("");

        while(jobs_list.size() > count ){

            toPrint.append(jobs_list.get(count).job + " => " + jobs_list.get(count).dependancy + "\n");
            count++;
        }
        System.out.println("The final job sequence -)")
        System.out.println(toPrint);
    }
    public static void main(String args[]){

        CodingChallenge codeCh = new CodingChallenge();

        System.out.println("Hello");
        codeCh.inputJobs();
        codeCh.printJobs();

    }
}