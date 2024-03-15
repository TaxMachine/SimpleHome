package dev.taxmachine.simplehome.interfaces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Config {
    public int homeLimit = 5;
    public HashMap<String, List<Home>> players;

    public Config() {
        players = new HashMap<>();
    }

    public int getHomeLimit() {
        return homeLimit;
    }

    public void setHomeLimit(int homeLimit) {
        this.homeLimit = homeLimit;
    }

    public void addPlayer(UUID uuid) {
        if (!players.containsKey(uuid.toString())) players.put(uuid.toString(), new ArrayList<>());
    }

    public void addHome(UUID uuid, Home home) {
        if (players.get(uuid.toString()).stream().anyMatch(h -> h.getName().equals(home.getName()))) throw new IllegalArgumentException("this home already exists");
        if (players.get(uuid.toString()).size() >= homeLimit) throw new IllegalArgumentException("You reached the maximum amount of homes");
        players.get(uuid.toString()).add(home);
    }

    public void removeHome(UUID uuid, String name) {
        if (players.get(uuid.toString()).stream().noneMatch(home -> home.getName().equals(name))) throw new IllegalArgumentException("This home does not exists.");
        players.get(uuid.toString()).removeIf(home -> home.getName().equals(name));
    }

    public List<Home> getHomes(UUID uuid) {
        return players.get(uuid.toString());
    }

    public Home getHome(UUID uuid, String name) {
        return players.get(uuid.toString()).stream().filter(home -> home.getName().equals(name)).findFirst().orElseThrow(() -> new IllegalArgumentException("This home does not exists."));
    }
}
