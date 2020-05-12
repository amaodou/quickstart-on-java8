package xyz.mdou.quickstart.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzMain {

    public static void main(String[] args) throws SchedulerException {

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        JobDetail job = JobBuilder.newJob(MyJob.class)
                .withIdentity("myJob", "abc")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "myTriggerGroup")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))
                .build();

        scheduler.scheduleJob(job, trigger);
        scheduler.start();
    }

    class MyJob implements Job {

        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {
            System.out.println("execute myJob");
        }
    }

}
