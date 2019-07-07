package ru.job4j.parser;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Parser implements Job {
    private static final Logger LOGGER = LoggerFactory.getLogger(Parser.class);

    public static void main(String[] args) throws SchedulerException {
        ConfigPars configPars = new ConfigPars();
        LOGGER.info("create a connection to this database");
        String expression = configPars.get("CronTrigger");
        JobDetail job = JobBuilder.newJob(Parser.class).build();
        Trigger t1 = TriggerBuilder.newTrigger()
                .withIdentity("CronTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule(expression)).build();
        Scheduler sc = StdSchedulerFactory.getDefaultScheduler();
        sc.start();
        sc.scheduleJob(job, t1);
        LOGGER.info("Run the application using cron trigger");
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        ConfigPars config = new ConfigPars();
        DBVacancy dbVacancy = new DBVacancy(config);
        dbVacancy.createDB();
        dbVacancy.createTable();
        List<Vacancy> vacancies = new SqlParser().parse();
        for (Vacancy vacancy : vacancies) {
            dbVacancy.add(vacancy);
        }
    }
}



