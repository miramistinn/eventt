//package com.example.event.services;
//
//import com.example.event.repository.AdminRepository;
//import com.example.event.repository.ClientRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class CustomUserDetailService implements UserDetailsService {
//    private final AdminRepository adminRepository;
//    private final ClientRepository clientRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        if (adminRepository.findByEmail(email)!=null)
//            return adminRepository.findByEmail(email);
//        return clientRepository.findByEmail(email);
//    }
//}
