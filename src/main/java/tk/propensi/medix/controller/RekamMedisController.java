package tk.propensi.medix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.propensi.medix.models.KunjunganModel;
import tk.propensi.medix.models.ResumeMedisModel;
import tk.propensi.medix.models.UserModel;
import tk.propensi.medix.service.*;

import java.util.List;

@Controller
public class RekamMedisController {

    @Autowired
    private UserService userService;

    @Autowired
    private KunjunganService kunjunganService;

    @Autowired
    private RekamMedisService rekamMedisService;


    @RequestMapping("/rekamMedis")
    public String viewAllRekamMedis(
            Model model,
            Authentication auth,
            @RequestParam(value = "filter", required = false) String filter,
            @RequestParam(value = "keyword", required = false) String keyword
    ){
        UserModel authUser = userService.getUserByUsername(auth.getName());
        List<String> namaRS = kunjunganService.getnamaRS();
        List<KunjunganModel> listPasien = kunjunganService.getPasienList(keyword);
        List<KunjunganModel> listFilter = kunjunganService.filterList(filter);
        listPasien.retainAll(listFilter);
        model.addAttribute("keywordnya", keyword);
        model.addAttribute("filternya", filter);
        model.addAttribute("listNamaRS", namaRS);
        model.addAttribute("listPasien", listPasien);
        model.addAttribute("authuser", authUser);
        return "viewall-RM";
    }

    @GetMapping("/rekamMedis/{personId}")
    public String detailRM(@PathVariable("personId") String personId, Authentication auth, Model model){
        UserModel authUser = userService.getUserByUsername(auth.getName());
        List<KunjunganModel> listKunjungan = kunjunganService.getKunjunganById(personId);
        KunjunganModel kunjungan = listKunjungan.get(0);
        List<ResumeMedisModel> listRM = rekamMedisService.getRekamMedisByPersonId(personId);
        model.addAttribute("listRM", listRM);
        model.addAttribute("kunjungan", kunjungan);
        model.addAttribute("authuser", authUser);
        return "detailRM";
    }
}
