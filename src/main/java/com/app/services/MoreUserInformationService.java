package com.app.services;

import com.app.dto.CompleteMoreUserInfo;
import com.app.entities.FavouriteSubject;
import com.app.entities.MoreUserInfo;
import com.app.entities.Skill;
import com.app.entities.User;
import com.app.repositories.FavouriteSubjectRepository;
import com.app.repositories.MoreUserInfoRepository;
import com.app.repositories.SkillRepository;
import com.app.repositories.UserRepository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class MoreUserInformationService {
    private final UserRepository userRepository;
    private final MoreUserInfoRepository moreUserInfoRepository;
    private final FavouriteSubjectRepository favouriteSubjectRepository;
    private final SkillRepository skillRepository;

    public MoreUserInformationService(UserRepository userRepository, MoreUserInfoRepository moreUserInfoRepository, FavouriteSubjectRepository favouriteSubjectRepository, SkillRepository skillRepository) {
        this.userRepository = userRepository;
        this.moreUserInfoRepository = moreUserInfoRepository;
        this.favouriteSubjectRepository = favouriteSubjectRepository;
        this.skillRepository = skillRepository;
    }

    public CompleteMoreUserInfo saveUserInfo(CompleteMoreUserInfo completeMoreUserInfo,Integer userId) {
        completeMoreUserInfo.getMoreUserInfo().setUserId(userId);
        MoreUserInfo moreUserInfo = moreUserInfoRepository.save(completeMoreUserInfo.getMoreUserInfo());
        List<Skill> returnedSkills = new ArrayList<>();
        List<FavouriteSubject> returnedSubjects = new ArrayList<>();
        for (FavouriteSubject subject : completeMoreUserInfo.getSubjects()) {
            subject.setUserId(userId);
            returnedSubjects.add(favouriteSubjectRepository.save(subject));
        }
        for (Skill skill : completeMoreUserInfo.getSkills()) {
            skill.setUserId(userId);
            returnedSkills.add(skillRepository.save(skill));
        }
        return new CompleteMoreUserInfo(moreUserInfo, returnedSkills, returnedSubjects);
    }

    public CompleteMoreUserInfo getMoreUserInfoByUserId(int userId) {
        MoreUserInfo moreUserInfo = moreUserInfoRepository.findByUserId(userId);
        List<Skill> returnedSkills = skillRepository.findByUserId(userId);
        List<FavouriteSubject> returnedSubjects = favouriteSubjectRepository.findByUserId(userId);
        User user =userRepository.findById(userId).orElse(null);
        if(user!=null) {
            return new CompleteMoreUserInfo(moreUserInfo, returnedSkills, returnedSubjects,user.getName(),user.getMail());
        }else{
            return new CompleteMoreUserInfo(moreUserInfo, returnedSkills, returnedSubjects);
        }
    }

}
