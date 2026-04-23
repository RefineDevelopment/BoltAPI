package xyz.refinedev.practice.api.duel;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

/**
 * A duel invite sent from one player directly to another.
 */
public interface IProfileDuelRequest extends IDuelRequest {

    @Nullable
    Player getSender();

    @Nullable
    Player getTarget();

    @Override
    default DuelRequestType getType() {
        return DuelRequestType.PLAYER;
    }

    @Override
    @Nullable
    default Player getSenderPlayer() {
        return this.getSender();
    }

    @Override
    @Nullable
    default Player getTargetPlayer() {
        return this.getTarget();
    }
}
