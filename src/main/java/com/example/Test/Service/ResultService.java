package com.example.Test.Service;

import com.example.Test.model.Results;
import com.example.Test.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    private final ResultRepository resultRepository;

    @Autowired
    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public List<Results> getList(){
        return resultRepository.findAll();
    }

    public List<Results> getByGroup(String group){
        return resultRepository.findAllByUserGroup(group);
    }

    public List<Results> getByNameAndLastName(String name, String lastName){
        return resultRepository.findAllByUserNameAndUserLastName(name, lastName);
    }

    public Results create(Results results){
        return resultRepository.save(results);
    }

    public void delete(Integer id){
        resultRepository.deleteById(id);
    }

}
