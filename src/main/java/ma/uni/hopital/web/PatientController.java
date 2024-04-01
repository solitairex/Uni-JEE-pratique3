package ma.uni.hopital.web;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import ma.uni.hopital.entities.Patient;
import ma.uni.hopital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import  org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor

public class PatientController {


    @Autowired
    private PatientRepository patientRepository;
    @GetMapping("/index")
    private String index(Model model, @RequestParam(name="page",defaultValue ="0")int p,
                                      @RequestParam(name="size",defaultValue ="5") int s,
                         @RequestParam(name="keyword",defaultValue ="") String kw){
        Page<Patient> pagePatients=patientRepository.findByNomContains(kw,PageRequest.of(p,s));
        model.addAttribute("ListePatients",pagePatients.getContent());
        model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage",p);
        model.addAttribute("keyword",kw);
        return "patients";

    }
    @GetMapping("/delete")
    public String delete(Long id){
        patientRepository.deleteById(id);
        return "redirect:/index";

    }
    @GetMapping("/")
    public String home(){
        return "redirect:/index";
    }
}
