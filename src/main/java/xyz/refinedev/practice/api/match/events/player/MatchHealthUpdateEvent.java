package xyz.refinedev.practice.api.match.events.player;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Fired when Bolt refreshes an in-match health display for a player.
 */
@Getter
public class MatchHealthUpdateEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;

    public MatchHealthUpdateEvent(Player player) {
        super(!Bukkit.isPrimaryThread());
        this.player = player;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
