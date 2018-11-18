package com.sexybeast.config;

import com.sexybeast.GuessCount;
import com.sexybeast.MaxNumber;
import com.sexybeast.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.sexybeast")
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    // == fields==
    @Value("${game.maxNumber:100}")
    private int maxNumber;

    @Value("${game.minNumber:10}")
    private int minNumber;

    @Value("${game.guessCount:10}")
    private int guessCount;

    // == bean methods ==
    @Bean
    @MaxNumber
    public int maxNumber() {
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }

    @Bean
    @MinNumber
    public int minNumber() {
        return minNumber;
    }
}
