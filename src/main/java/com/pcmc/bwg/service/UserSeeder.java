package com.pcmc.bwg.service;

import com.pcmc.bwg.entity.Agency;
import com.pcmc.bwg.entity.AppUser;
import com.pcmc.bwg.entity.enums.AgencyStatus;
import com.pcmc.bwg.entity.enums.Role;
import com.pcmc.bwg.entity.enums.UserStatus;
import com.pcmc.bwg.repository.AgencyRepository;
import com.pcmc.bwg.repository.AppUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@Component
@Order(2)
@ConditionalOnProperty(name = "app.user-seed.enabled", havingValue = "true", matchIfMissing = true)
public class UserSeeder implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(UserSeeder.class);

    private final AgencyRepository agencyRepository;
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final AadhaarService aadhaarService;

    public UserSeeder(AgencyRepository agencyRepository,
                      AppUserRepository appUserRepository,
                      PasswordEncoder passwordEncoder,
                      AadhaarService aadhaarService) {
        this.agencyRepository = agencyRepository;
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.aadhaarService = aadhaarService;
    }

    @Override
    public void run(String... args) {
        try {
            // 1. Seed Default Agency if not exists
            Agency agency = agencyRepository.findByAgencyCode("AGENCY-PCMC-01").orElseGet(() -> {
                Agency a = new Agency();
                a.setAgencyName("PCMC Solid Waste Management");
                a.setAgencyCode("AGENCY-PCMC-01");
                a.setContactPersonName("PCMC Nodal Officer");
                a.setMobileNo("9822000001");
                a.setEmail("swm@pcmcindia.gov.in");
                a.setAddress("PCMC Headquarters, Mumbai-Pune Road, Pimpri, Pune");
                a.setPinCode("411018");
                a.setStatus(AgencyStatus.ACTIVE);
                Agency saved = agencyRepository.save(a);
                log.info("Seeded default agency 'AGENCY-PCMC-01'");
                return saved;
            });

            // 2. Seed Default Survey Officers
            seedUser(agency, "Rajesh Patil", "9822000000", "rajesh.patil@pcmcindia.gov.in",
                    "123456789012", "pcmc@2026", "PCMC Colony, Pimpri, Pune", "411018");

            seedUser(agency, "Amit Shinde", "9876543210", "amit.shinde@pcmcindia.gov.in",
                    "234567890123", "pcmc@2026", "Sector 24, Pradhikaran, Akurdi, Pune", "411033");

            seedUser(agency, "Sneha Kulkarni", "9890000000", "sneha.k@pcmcindia.gov.in",
                    "345678901234", "pcmc@2026", "Kaspate Vasti, Wakad, Pune", "411057");
        } catch (Exception e) {
            log.error("Failed to seed default agency/users during startup: {}", e.getMessage(), e);
        }
    }

    private void seedUser(Agency agency, String fullName, String mobileNo, String email,
                          String aadhaarNo, String password, String address, String pinCode) {
        try {
            if (appUserRepository.existsByMobileNo(mobileNo)) {
                return;
            }

            AppUser user = new AppUser();
            user.setAgency(agency);
            user.setFullName(fullName);
            user.setMobileNo(mobileNo);
            user.setEmail(email);
            user.setAadhaarNoEncrypted(aadhaarService.encrypt(aadhaarNo));
            user.setAadhaarNoHash(aadhaarService.hash(aadhaarNo));
            user.setPasswordHash(passwordEncoder.encode(password));
            user.setAddress(address);
            user.setPinCode(pinCode);
            user.setRole(Role.SURVEY_OFFICER);
            user.setStatus(UserStatus.ACTIVE);
            user.setMobileVerified(true);
            user.setAadhaarVerified(true);

            appUserRepository.save(user);
            log.info("Seeded default survey officer '{}' with mobile: {}", fullName, mobileNo);
        } catch (Exception e) {
            log.warn("Failed to seed user {} ({}): {}", fullName, mobileNo, e.getMessage());
        }
    }
}
