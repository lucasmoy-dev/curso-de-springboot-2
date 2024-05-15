package academy.atl.webscrapper.jobs;

import academy.atl.webscrapper.services.SpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WebscrapperJob {
    @Autowired
    private SpiderService spiderService;

    @Scheduled(cron = "0 0 4 * * *")
    public void executeJob() {
        spiderService.start();
    }
}
