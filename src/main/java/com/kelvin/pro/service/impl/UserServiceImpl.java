package com.kelvin.pro.service.impl;

import com.kelvin.pro.exceptions.UserServiceException;
import com.kelvin.pro.io.repository.UserRepository;
import com.kelvin.pro.service.UserService;
import com.kelvin.pro.shared.Utils;
import com.kelvin.pro.shared.dto.AddressDTO;
import com.kelvin.pro.shared.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;



    @Override
    public UserDto createUser(UserDto user) {
        if (userRepository.findByEmail(user.getEmail()) != null)
            throw new UserServiceException("Record already exists");

        for(int i=0;i<user.getAddresses().size();i++)
        {
            AddressDTO address = user.getAddresses().get(i);
            address.setUserDetails(user);
            address.setAddressId(utils.generateUserId(30));
            user.getAddresses().set(i, address);
        }

        //BeanUtils.copyProperties(user, userEntity);
      //  ModelMapper modelMapper = new ModelMapper();
       // UserEntity userEntity = modelMapper.map(user, UserEntity.class);

//        String publicUserId = utils.generateUserId(30);
//        userEntity.setUserId(publicUserId);
//        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        userEntity.setEmailVerificationToken(utils.generateEmailVerificationToken(publicUserId));
//
//        UserEntity storedUserDetails = userRepository.save(userEntity);

        //BeanUtils.copyProperties(storedUserDetails, returnValue);
//        UserDto returnValue  = modelMapper.map(storedUserDetails, UserDto.class);
//
//        // Send an email message to user to verify their email address
//        amazonSES.verifyEmail(returnValue);

       // return returnValue;
        return null;
    }
}
