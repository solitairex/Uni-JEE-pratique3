package ma.uni.hopital;

import ma.uni.hopital.entities.Patient;
import ma.uni.hopital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import java.util.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HopitalApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args)
    {
        SpringApplication.run(HopitalApplication.class, args);
    }
    @Override
    public void run(String... args)throws Exception{
      /*  Patient patient=new Patient();
        patient.setId(null);
        patient.setNom("Adam");
        patient.setDatenaissance(new Date());
        patient.setMalade(false);
        patient.setScore(23);

        Patient patient2=new Patient(null,"Yassine",new Date(),false,123);

        Patient patient3=Patient.builder()
                .nom("imane")
                .datenaissance(new Date())
                .score(56)
                .malade(true)
                .build()*/
        patientRepository.save(new Patient(null,"Mohamed",new Date(),false,34));
        patientRepository.save(new Patient(null,"Adam",new Date(),false,3412));
        patientRepository.save(new Patient(null,"Ammar",new Date(),false,3234));


    }

}
