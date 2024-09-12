package alpb.external;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Date;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
@FeignClient(name = "plan", url = "${api.url.plan}")
public interface Service {
    @RequestMapping(method= RequestMethod., path="/undefined/{id}")
    public void plan(@PathVariable("id")   , @RequestBody PlanCommand planCommand );
    @GetMapping(path="//search/findByPlan/{id}")
    public  plan(@PathVariable("userIdx") Integer userIdx, PlanQuery planQuery);
}