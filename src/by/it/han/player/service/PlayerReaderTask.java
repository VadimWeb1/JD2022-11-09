package by.it.han.player.service;

import by.it.han.jd01_15.PatchFinder;
import by.it.han.player.model.Player;

import java.util.List;

public class PlayerReaderTask extends Thread {
    private static final int MIN_AGE = 24;
    private static final int MAX_AGE = 31;
    public static final int MAX_COUNT_PLAYERS = 5;
    private static int countName = 0;

    private final PlayerGeneratorTask playerGeneratorTask;

    public PlayerReaderTask(PlayerGeneratorTask playerGeneratorTask) {
        this.playerGeneratorTask = playerGeneratorTask;
    }

    @Override
    public void run() {
        List<Player> playersFromFile = getPlayersFromFile();
        List<Player> sortedPlayer = getSortedPlayer(playersFromFile);
        printFirstPlayers(sortedPlayer);
    }

    public List<Player> getPlayersFromFile() {
        String filePath = PatchFinder.getFilePath(++countName + "", PlayerReaderTask.class);
        return playerGeneratorTask.getPlayerList();
    }

    private List<Player> getSortedPlayer(List<Player> playerList) {
        return playerList.stream()
                .filter(player -> player.getAge() > MIN_AGE && player.getAge() < MAX_AGE)
                .toList();
    }

    public void printFirstPlayers(List<Player> playerList) {
        playerList.stream()
                .limit(MAX_COUNT_PLAYERS)
                .map(p -> String.valueOf(p.getName()).toUpperCase())
                .forEach(p -> System.out.print(p + " "));
    }
}
