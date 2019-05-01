package pl.kamol84.giveawaystuff.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import pl.kamol84.giveawaystuff.entity.User;
import pl.kamol84.giveawaystuff.exceptions.BadRequestException;
import pl.kamol84.giveawaystuff.exceptions.NotFoundException;
import pl.kamol84.giveawaystuff.repository.UserRepository;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final Validator validator;

    @Autowired
    public UserService(UserRepository userRepository, Validator validator) {
        this.userRepository = userRepository;
        this.validator = validator;
    }

    public User save (User user){
        Set<ConstraintViolation<User>> violations =validator.validate(user);
        if(!violations.isEmpty()) {
            throw new BadRequestException("wprowadzono niepoprawne dane");
        }
        userRepository.save(user);
        return user;
    }

    public User checkLogin(String email, String password){
        User user = userRepository.findByEmail(email);
        if(user== null){
            throw new NotFoundException ("Nie znaleziono użytkownika - @");     //TODO: delete -@
        }
        if(BCrypt.checkpw(password, user.getPassword())){
            return user;
        } else {
            throw new NotFoundException ("Nie znaleziono użytkownika - P"); //TODO: delete -P
        }
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public User getUserById(Long id){
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()) {
            throw new NotFoundException("Nie znaleziono użytkownika");
        }
        return user.get();
    }

    public void delete (Long id){
        userRepository.delete(getUserById(id));
    }
}

