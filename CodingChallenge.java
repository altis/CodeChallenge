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
                if(job.length()==6){
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
        System.out.println("The final job sequence -)");
        System.out.println(toPrint);
    }
    public void scheduleJobs(){
        int pointer = 0;
        while(pointer < jobs_list.size()){
            for(int handle = pointer; handle < jobs_list.size(); handle++){
                if(jobs_list.get(pointer).dependancy == jobs_list.get(handle).job ){
                    System.out.println(handle);
                    JobClass jobToAdvance = jobs_list.remove(handle);
                    jobs_list.add(pointer, new JobClass(jobToAdvance.job,jobToAdvance.dependancy));
                    pointer--;
                    break;
                }
            }
            pointer++;
        }
    }
    public boolean checkCyclicDependancy(){
        int pointer = 0; char start; char visit;
        while(pointer < jobs_list.size()){
            //Code to check dependant on itself
            start = jobs_list.get(pointer).job;
            visit = jobs_list.get(pointer).dependancy;
            if(start == visit){  System.out.println("Error ! Jobs can't depend themselves"); return true;} // If not check for any circular depandancy
            else {
                for (int handle = 0; handle < jobs_list.size(); handle++) {
                    if (pointer != handle) {
                        if (jobs_list.get(handle).job == visit) {
                            visit = jobs_list.get(handle).dependancy;
                        }
                    }
                }
                if(start == visit) {  System.out.println("Error ! Detected Circular Dependancy"); return  true;}
            }
            pointer ++;
        }
        return false;
    }

    public static void main(String args[]){
        CodingChallenge codeCh = new CodingChallenge();
        codeCh.inputJobs();

        if(codeCh.checkCyclicDependancy()){
            System.out.println("Jobs Terminated !");

        } else{
            codeCh.scheduleJobs();
            codeCh.printJobs();
        }

    }
}