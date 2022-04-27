package tk.propensi.medix.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import tk.propensi.medix.models.UserModel;
import tk.propensi.medix.service.DashboardRestService;
import tk.propensi.medix.service.UserService;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ChartDataRestController {
    @Autowired
    private DashboardRestService dashboardRestService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/chartdata")
    private List<HashMap> retrieveChartData(Authentication auth) {
        UserModel authUser = userService.getUserByUsername(auth.getName());
        try {
            return dashboardRestService.getChartData(authUser.getRumahSakit().getId());
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Tidak ada ChartData"
            );
        }
    }
}
