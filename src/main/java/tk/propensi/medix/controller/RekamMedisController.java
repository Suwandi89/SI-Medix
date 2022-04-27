package tk.propensi.medix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tk.propensi.medix.models.RoleModel;
import tk.propensi.medix.models.UserModel;

import java.util.List;

@Controller
public class RekamMedisController {

    @GetMapping("/rekamMedis")
    public String detailRM(Model model){
        return "detailRM";
    }
}
