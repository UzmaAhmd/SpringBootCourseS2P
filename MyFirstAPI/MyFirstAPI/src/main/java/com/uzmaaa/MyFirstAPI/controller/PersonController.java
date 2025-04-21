package com.uzmaaa.MyFirstAPI.controller;

import com.uzmaaa.MyFirstAPI.model.Person;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/person")
public class PersonController {
    Person person1 = new Person(1L, "Uzma", "Ahmad",
            99991, "uzma.ahm@gmail.com", "UZMA");
    Person person2 = new Person(2L, "Faazil", "Parvez",
            99999992, "fzpar@gmail.com", "FAAZIL");
    Person person3 = new Person(3L, "Zaki", "Parvez",
            99999993, "zpar@gmail.com", "Zaki");
    Person person4 = new Person(4L, "Javed", "Iqbal",
            99999994, "jvdiq@gmail.com", "JAVED");
    Person person5 = new Person(5L, "Aayra", "Islah",
            99999995, "aayraislah@gmail.com", "AAYRA");
    Person person6 = new Person(6L, "Fouzia", "Ahmed",
            99999996, "fz.ahm@gmail.com", "FOUZIA");

    public List<Person> personList = new ArrayList<>(List.of(person1, person2, person3,
            person4, person5, person6));


    //  http://localhost:8080/all
    @GetMapping("/all")
    public List<Person> getPersonList() {
        return personList;
    }

    //  http://localhost:8080/person/2
    @GetMapping("/person/{id}")
    public Person getPersonById(@PathVariable("id") Long id) {
        Person person = null;
        for (Person target : personList) {
            if (Objects.equals(target.getPersonID(), id)) {
                person = target;
                break;
            }
        }
        return person;
    }

    // http://localhost:8080/person?firstName=Faazil
    @GetMapping("/person")
    public List<Person> getPersonByName(@RequestParam("firstName") String fName) {
        List<Person> responsePerson = new ArrayList<>();
        for (Person p : personList) {
            if (p.getFirstName().compareTo(fName) == 0) {
                responsePerson.add(p);
            }
        }
        return responsePerson;
    }


    //http://localhost:8080/person/save
    @PostMapping("/save")
    public Person saveData(@RequestBody Person person) {
        personList.add(person);
        return person;
    }



    //http://localhost:8080/person/4
    //SET NEW ID AS 0 AS id should be same in updated data set as well
    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable("id") Long myId, @RequestBody Person person) {
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getPersonID().equals(myId)) {
                Person foundObject = personList.get(i);

                String newName = person.getFirstName();
                foundObject.setFirstName(newName);

                String newLastName = person.getLastName();
                foundObject.setLastName(newLastName);

                foundObject.setMobileNumber(person.getMobileNumber());
                foundObject.setEmail(person.getEmail());
                foundObject.setPwd(person.getPwd());

                return foundObject;
            }
        }
        return null;
    }


    //Patch is used to update any one or two fields and
    // not like put where one field remains same and others are updated
    //http://localhost:8080/person/update/2
    @PatchMapping("/update/{id}")
    public Person updatePersonInstance(@PathVariable("id") Long myId,@RequestBody Person person)
    {
        for (Person target:personList){
            if(target.getPersonID().equals(myId))
            {
                if(null!=person.getFirstName() && !person.getFirstName().isBlank())
                {
                    String firstName=person.getFirstName();
                    target.setFirstName(firstName);
                }

                if(null!=person.getLastName() && !person.getLastName().isBlank())
                {
                    String lastName=person.getLastName();
                    target.setLastName(lastName);
                }

                if(0!=person.getMobileNumber() && person.getMobileNumber()>0)
                {
                    int mobileNumber=person.getMobileNumber();
                    target.setMobileNumber(mobileNumber);

                }
//                if (person.getMobileNumber() != null && person.getMobileNumber() > 0) {
//                    Integer mobileNumber = person.getMobileNumber();
//                    target.setMobileNumber(mobileNumber);
//                }

                if (null!= person.getEmail() && !person.getEmail().isBlank())
                {
                    String email=person.getEmail();
                    target.setEmail(email);
                }

                if(null!=person.getPwd() && !person.getPwd().isBlank())
                {
                    String passwrd=person.getPwd();
                    target.setPwd(passwrd);
                }

                return target;
            }
        }
return  null;
    }

    //http://localhost:8080/person/delete/2
    @DeleteMapping("/delete/{id}")
    public List<Person> deletePersonById(@PathVariable("id") Long id )
    {
        Person foundPerson=null;
        for(int i=0;i<personList.size();i++){
            if(personList.get(i).getPersonID().equals(id)){
                foundPerson=personList.get(i);
                break;
            }
        }
        if(null!=foundPerson)
        {
            personList.remove(foundPerson);
        }
     return personList;
    }

}