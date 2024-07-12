package com.foxelyss.maththemright;

import java.io.InputStream;
import java.util.Random;

import javax.microedition.lcdui.*;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;


public class Game extends MIDlet implements CommandListener {

    private static final String START_FORM_TITLE = "Math Them Right";

    private static final String START_MESSAGE = "Пожалуйста нажмите Далее";

    private static final String CONTENT_TYPE = "audio/x-wav";

    private static final String WIN_SOUND = "/com/foxelyss/maththemright/res/win.wav";
    private static final String LOSE_SOUND = "/com/foxelyss/maththemright/res/lose.wav";
    private static final String MUSIC_SOUND = "/com/foxelyss/maththemright/res/music.wav";

    Display display;

    ChoiceGroup answers;

    Command startCommand = new Command("Далее", Command.OK, 1);
    Command exitCommand = new Command("Выход", Command.EXIT, 2);

    Player win_player;
    Player lose_player;
    Player music_player;

    InputStream win_sound_stream;
    InputStream lose_sound_stream;
    InputStream music_sound_stream;

    Form startForm;

    int win_strike = 0;
    int right_answer_index = -3;


    public Game() {
        display = Display.getDisplay(this);
    }

    public void startApp() throws MIDletStateChangeException {
        initAudio();
        startForm = new Form(START_FORM_TITLE);
        startForm.append(START_MESSAGE);
        startForm.addCommand(startCommand);
        startForm.addCommand(exitCommand);
        startForm.setCommandListener(this);

        answers = new ChoiceGroup("Ответы", Choice.EXCLUSIVE);
        startForm.append(answers);
        display.setCurrent(startForm);

        try {
            music_player.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
        try {
            win_player.stop();
            lose_player.stop();
            music_player.stop();
            win_player = null;
            lose_player = null;
            music_player = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void initAudio() {
        try {
            win_sound_stream = getClass().getResourceAsStream(WIN_SOUND);
            lose_sound_stream = getClass().getResourceAsStream(LOSE_SOUND);
            music_sound_stream = getClass().getResourceAsStream(MUSIC_SOUND);

            win_player = Manager.createPlayer(win_sound_stream, CONTENT_TYPE);

            win_player.realize();
            win_player.prefetch();

            lose_player = Manager.createPlayer(lose_sound_stream, CONTENT_TYPE);

            lose_player.realize();
            lose_player.prefetch();

            music_player = Manager.createPlayer(music_sound_stream, CONTENT_TYPE);

            music_player.setLoopCount(-1);
            music_player.realize();
            music_player.prefetch();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void commandAction(Command c, Displayable d) {
        if (c == startCommand) {
            if (checkAnswer()) {
                win_strike++;
                try {
                    win_player.start();
                } catch (Exception e) {
                }
            } else {
                win_strike = 0;
                try {
                    lose_player.start();
                } catch (Exception e) {
                }
            }

            generateExercise();
        } else if (c == exitCommand) {
            destroyApp(true);
            notifyDestroyed();
        }
    }

    public boolean checkAnswer() {
        return right_answer_index == answers.getSelectedIndex();
    }

    public void generateExercise() {
        Random random = new Random();

        int a = random.nextInt(200);
        int b = random.nextInt(200);

        int operation = random.nextInt(4);

        int right_result =  a / b;

        char operand = '/';
        switch (operation) {
            case 0:
                operand = '+';
                right_result = a + b;
                break;
            case 1:
                operand = '-';
                right_result = a - b;
                break;
            case 2:
                operand = '*';
                right_result = a * b;
                break;
        }

        String question = a + " " + operand + " " + b + "\t=";
        ((StringItem) startForm.get(0)).setText(question + "\n" + "Серия побед:\t" + win_strike);

        right_answer_index = random.nextInt(4);

        answers.deleteAll();
        for (int i = 0; i < 4; i++) {
            int offset = random.nextInt(24);
            String answer = (right_result + offset < 12 ? -1 * (1 + offset) : offset) + "";
            if (i == right_answer_index) {
                answer = "" + right_result;
            }
            answer = answer.substring(0, answer.length() > 6 ? 6 : answer.length());

            answers.append(answer, null);
        }
    }

}
