package org.example.models.services;

import org.example.dto.CoachModelDTO;
import org.example.dto.RequestDTO;
import org.example.mapper.CoachMapper;
import org.example.models.entities.CoachModel;
import org.example.models.entities.UserInfoModel;
import org.example.repositories.CoachRepository;
import org.springframework.stereotype.Service;

@Service
public class CoachService {
    private final CoachRepository coachRepository;
    private final CoachMapper coachMapper;
    private final UserDetailsServiceImplementation userDetailsServiceImplementation;
    public CoachService(CoachRepository coachRepository, CoachMapper coachMapper, UserDetailsServiceImplementation userDetailsServiceImplementation) {
        this.coachRepository = coachRepository;
        this.coachMapper = coachMapper;
        this.userDetailsServiceImplementation = userDetailsServiceImplementation;
    }

    public CoachModelDTO getCoach(String firstName){
        CoachModel coachModel = coachRepository.findCoachModelByFirstName(firstName);
        if(coachModel == null) {
            throw new IllegalArgumentException();
        }
        return coachMapper.coachMapper(coachModel);
    }

    public CoachModelDTO addNewCoach(CoachModelDTO coachModelDTO) {
        UserInfoModel newUser = userDetailsServiceImplementation.addNewUser(
                new RequestDTO(coachModelDTO.getUsername(), coachModelDTO.getPassword()), "coach");
        CoachModel coachModel = new CoachModel();
        coachModel.setFirstName(coachModelDTO.getFirstName());
        coachModel.setSecondName(coachModelDTO.getSecondName());
        coachModel.setLastName(coachModelDTO.getLastName());
        coachModel.setEmail(coachModelDTO.getEmail());
        coachModel.setPhoneNumber(coachModelDTO.getPhoneNumber());
        coachModel.setUserInfoModel(newUser);
        coachRepository.save(coachModel);

        CoachModelDTO newCoachDTO = coachMapper.coachMapper(coachModel);
        newCoachDTO.setUsername(coachModel.getUserInfoModel().getUsername());
        newCoachDTO.setPassword(coachModel.getUserInfoModel().getPassword());
        return newCoachDTO;
    }

    public CoachModelDTO updateCoach(CoachModelDTO coachModelDTO, int id) {
        CoachModel existingCoach = coachRepository.findById(id).orElse(null);
        if (existingCoach == null) {
            throw new IllegalArgumentException("Coach does not exist!");
        }
        UserInfoModel newUser = userDetailsServiceImplementation.addNewUser(
                new RequestDTO(coachModelDTO.getUsername(), coachModelDTO.getPassword()), "coach");
        CoachModel coachModel = new CoachModel();
        coachModel.setFirstName(coachModelDTO.getFirstName());
        coachModel.setSecondName(coachModelDTO.getSecondName());
        coachModel.setLastName(coachModelDTO.getLastName());
        coachModel.setEmail(coachModelDTO.getEmail());
        coachModel.setPhoneNumber(coachModelDTO.getPhoneNumber());
        coachModel.setUserInfoModel(newUser);
        coachRepository.save(coachModel);

        CoachModelDTO newCoachDTO = coachMapper.coachMapper(coachModel);
        newCoachDTO.setUsername(coachModel.getUserInfoModel().getUsername());
        newCoachDTO.setPassword(coachModel.getUserInfoModel().getPassword());
        return newCoachDTO;
    }

    public void deleteCoach(int id) {

        coachRepository.deleteById(id);
    }
}
