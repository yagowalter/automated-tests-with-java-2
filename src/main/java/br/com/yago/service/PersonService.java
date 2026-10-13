package br.com.yago.service;

import br.com.yago.model.Person;

public class PersonService implements IPersonService{

    @Override
    public Person createPerson(Person person){
        return new Person();
    }
}
