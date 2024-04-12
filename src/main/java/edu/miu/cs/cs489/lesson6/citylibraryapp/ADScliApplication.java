package edu.miu.cs.cs489.lesson6.citylibraryapp;

import edu.miu.cs.cs489.lesson6.citylibraryapp.models.*;
import edu.miu.cs.cs489.lesson6.citylibraryapp.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ADScliApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(ADScliApplication.class, args);
    }

    private final DentistService dentistService;
    private final PatientService patientService;
    private final SurgeryService surgeryService;
    private final AppointmentService appointmentService;
    private final AddressService addressService;
    private final UserService userService;


    public ADScliApplication(DentistService dentistService, PatientService patientService,
                             SurgeryService surgeryService, AppointmentService appointmentService, AddressService addressService, UserService userService) {
        this.dentistService = dentistService;
        this.patientService = patientService;
        this.surgeryService = surgeryService;
        this.appointmentService = appointmentService;
        this.addressService = addressService;
        this.userService= userService;
    }

    @Override
    public void run(String... args) {
        // Create addresses
        Address address1 = new Address(null, "389 vernon", "Oakland", "CA", "94610");
        Address address2 = new Address(null, "2008 Ranchwood", "Wylie", "TX", "90021");
        Address address3 = new Address(null, "473 Buena vista ave", "Almeda", "CA", "94501");
        Address address4 = new Address(null, "1000 N 4th St", "Fairfield", "IA", "52557");

        // Save addresses
        addressService.save(address1);
        addressService.save(address2);
        addressService.save(address3);
        addressService.save(address4);
        // Create surgeries
        Surgery surgery1 = new Surgery(null, "Surgery 1", address1, new ArrayList<>());
        Surgery surgery2 = new Surgery(null, "Surgery 2", address2, new ArrayList<>());

        // Save surgeries
        surgeryService.save(surgery1);
        surgeryService.save(surgery2);

        // Create dentists
        Dentist dentist1 = new Dentist(null, "Chris Andrew", new ArrayList<>());
        Dentist dentist2 = new Dentist(null, "Sarah Abraham", new ArrayList<>());

        // Save dentists
        dentistService.save(dentist1);
        dentistService.save(dentist2);

        // Create patients
        Patient patient1 = new Patient(null, "John", "Brian", "john@example.com", "1234567890", address1, new ArrayList<>());
        Patient patient2 = new Patient(null, "Steve", "George", "steve@example.com", "2345678910", address2, new ArrayList<>());
        Patient patient3 = new Patient(null, "Stella", "Mike", "stella@example.com", "3456789120", address3, new ArrayList<>());
        Patient patient4 = new Patient(null, "Peter", "Trump", "peter@example.com", "4567891230", address4, new ArrayList<>());

        // Save patients
        patientService.save(patient1);
        patientService.save(patient2);
        patientService.save(patient3);
        patientService.save(patient4);

        // Create appointments
        Appointment appointment1 = new Appointment(null, LocalDate.of(2023, 8, 11), surgery1, patient1, dentist1);
        Appointment appointment2 = new Appointment(null, LocalDate.of(2023, 8, 12), surgery1, patient2, dentist1);
        Appointment appointment3 = new Appointment(null, LocalDate.of(2023, 8, 13), surgery2, patient3, dentist2);
        Appointment appointment4 = new Appointment(null, LocalDate.of(2023, 8, 14), surgery2, patient3, dentist2);
        Appointment appointment5 = new Appointment(null, LocalDate.of(2023, 8, 15), surgery1, patient2, dentist1);
        Appointment appointment6 = new Appointment(null, LocalDate.of(2023, 8, 15), surgery2, patient4, dentist2);

        // Save appointments
        appointmentService.save(appointment1);
        appointmentService.save(appointment2);
        appointmentService.save(appointment3);
        appointmentService.save(appointment4);
        appointmentService.save(appointment5);
        appointmentService.save(appointment6);

        // List all appointments
        List<Appointment> appointmentList = appointmentService.findAll();
        System.out.println(appointmentList);

        //Save user
        Users users = new Users(null, "Sewit", "password", new ArrayList<>());
        System.out.println(userService.save(users));

    }

}
