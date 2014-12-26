package com.pos.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class PersonRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonRepository.class);

    @PersistenceContext
    private EntityManager entityManager;

//    @PostConstruct
//    public void createMessages() {
//        LOGGER.warn("Creating dummy messages...");
//        save(new Task("Lorem ipsum dolor sit amet.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis tristique metus at risus gravida facilisis. In porta interdum pulvinar. In."));
//        save(new Task("Lorem ipsum dolor sit amet.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse bibendum turpis et venenatis tincidunt. Vivamus tristique tortor vel pretium porttitor."));
//        save(new Task("Lorem ipsum dolor sit amet.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc sed fermentum nisl. Sed elit dui."));
//    }

    @Transactional
    public Person save(Person person) {
        entityManager.persist(person);
        return person;
    }

    public List<Person> findAll() {
        return entityManager.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }

    public Person findById(Long id) {
        return entityManager.find(Person.class, id);
    }
}
