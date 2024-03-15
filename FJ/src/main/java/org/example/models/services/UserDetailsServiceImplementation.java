package org.example.models.services;

import org.example.dto.RequestDTO;
import org.example.models.UsersDetails;
import org.example.models.entities.RoleModel;
import org.example.models.entities.UserInfoModel;
import org.example.repositories.RoleRepository;
import org.example.repositories.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImplementation implements UserDetailsService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    @Lazy
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfoModel user = userInfoRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("could not found user..!!");
        }
        return new UsersDetails(user);
    }

    public RequestDTO registerNewUser(RequestDTO userDTO, String typeOfUser) {
        UserInfoModel newUser = addNewUser(userDTO, typeOfUser);
        return new RequestDTO(newUser.getUsername(), newUser.getPassword());
    }

    public UserInfoModel addNewUser(RequestDTO userDTO, String typeOfUser) {
        if (userInfoRepository.findByUsername(userDTO.getUsername()) != null) {
            throw new IllegalArgumentException("User already exists");
        }
        UserInfoModel newUser = new UserInfoModel();
        newUser.setUsername(userDTO.getUsername());
        newUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        RoleModel userRole = new RoleModel();
        if(typeOfUser.equalsIgnoreCase("user")) {
            userRole.setName("ROLE_USER");
        } else {
            userRole.setName("ROLE_COACH");
        }
        roleRepository.save(userRole);
        newUser.getRoles().add(userRole);
        UserInfoModel savedUser = userInfoRepository.save(newUser);

        return savedUser;
    }
}
