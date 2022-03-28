package su.ibn.springdemo.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/*
Если интерфейс имеет много реализаций можно пометить одну из них ка
@Primary
таким образом избежав разночтений
 */
@Service
@Primary
@Profile("cat")
public class CatSound implements SoundAnimals{

    @Override
    public String sound() {
        return "мяу";
    }
}
