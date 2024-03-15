package org.example.models.services;

import org.example.dto.UserModelDTO;
import org.example.dto.RequestDTO;
import org.example.mapper.UserMapper;
import org.example.models.entities.UserModel;
import org.example.models.entities.UserInfoModel;
import org.example.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserDetailsServiceImplementation userDetailsServiceImplementation;
    public UserService(UserRepository userRepository, UserMapper userMapper, UserDetailsServiceImplementation userDetailsServiceImplementation) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userDetailsServiceImplementation = userDetailsServiceImplementation;
    }

    public UserModelDTO getUser(String firstName){
        UserModel userModel = userRepository.findUserModelByFirstName(firstName);
        if(userModel == null) {
            throw new IllegalArgumentException();
        }
        return userMapper.mapperUser(userModel);
    }

    public UserModelDTO addNewUser(UserModelDTO userModelDTO) {
        UserInfoModel newUser = userDetailsServiceImplementation.addNewUser(
                new RequestDTO(userModelDTO.getUsername(), userModelDTO.getPassword()), "user");
        UserModel userModel = new UserModel();
        userModel.setFirstName(userModelDTO.getFirstName());
        userModel.setSecondName(userModelDTO.getSecondName());
        userModel.setLastName(userModelDTO.getLastName());
        userModel.setEmail(userModelDTO.getEmail());
        userModel.setPhoneNumber(userModelDTO.getPhoneNumber());
        userModel.setUserInfoModel(newUser);
        userRepository.save(userModel);

        UserModelDTO newUserDTO = userMapper.mapperUser(userModel);
        newUserDTO.setUsername(userModel.getUserInfoModel().getUsername());
        newUserDTO.setPassword(userModel.getUserInfoModel().getPassword());
        return newUserDTO;
    }

    public UserModelDTO updateUser(UserModelDTO userModelDTO, int id) {
        UserModel existingUser = userRepository.findById(id).orElse(null);
        if (existingUser == null) {
            throw new IllegalArgumentException("User does not exist!");
        }
        UserInfoModel newUser = userDetailsServiceImplementation.addNewUser(
                new RequestDTO(userModelDTO.getUsername(), userModelDTO.getPassword()), "coach");
        UserModel userModel = new UserModel();
        userModel.setFirstName(userModelDTO.getFirstName());
        userModel.setSecondName(userModelDTO.getSecondName());
        userModel.setLastName(userModelDTO.getLastName());
        userModel.setEmail(userModelDTO.getEmail());
        userModel.setPhoneNumber(userModelDTO.getPhoneNumber());
        userModel.setUserInfoModel(newUser);
        userRepository.save(userModel);

        UserModelDTO newCoachDTO = userMapper.mapperUser(userModel);
        newCoachDTO.setUsername(userModel.getUserInfoModel().getUsername());
        newCoachDTO.setPassword(userModel.getUserInfoModel().getPassword());
        return newCoachDTO;
    }

    public void deleteUser(int id) {

        userRepository.deleteById(id);
    }
}
