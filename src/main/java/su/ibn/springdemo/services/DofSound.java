package su.ibn.springdemo.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
@Profile("dog")
public class DofSound implements SoundAnimals{

    @Override
    public String sound() {
        return "гав";
    }
}
