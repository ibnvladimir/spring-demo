package su.ibn.springdemo.services;

import org.springframework.stereotype.Service;

@Service
public class HorseSound implements SoundAnimals{

    @Override
    public String sound() {
        return "иго-го";
    }
}
