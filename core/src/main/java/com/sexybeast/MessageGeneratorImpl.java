package com.sexybeast;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component("messageGenerator")
public class MessageGeneratorImpl implements MessageGenerator {

    // == fields ==
    private final GameImpl game;

    // == constructors ==
    @Autowired
    public MessageGeneratorImpl(GameImpl game) {
        this.game = game;
    }

    // == init ==
    @PostConstruct
    public void init() {
        log.info("Game = {}", game);
    }

    // == public methods ==
    @Override
    public String getMainMessage() {
        return "The number is between " +
                game.getSmallest() +
                " and " +
                game.getBiggest() +
                ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if (game.isGameWon()) {
            return "You won!, the number was " + game.getNumber();
        } else if (game.isGameLost()) {
            return "You lost, the number was " + game.getNumber();
        } else if (!game.isValidNumberRange()) {
            return "Invalid number range";
        } else if (game.getRemainingGuesses() == game.getGuessCount()) {
            return "What is your first guess?";
        } else {
            String direction = "Lower";
            if (game.getGuess() < game.getSmallest()) {
                direction = "Higher";
            }
            return direction + ". You have " + game.getRemainingGuesses() + " guesses left.";
        }
    }
}
