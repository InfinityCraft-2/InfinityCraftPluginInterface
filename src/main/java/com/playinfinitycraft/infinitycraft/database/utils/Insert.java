package com.playinfinitycraft.infinitycraft.database.utils;

import com.playinfinitycraft.infinitycraft.database.Postgres;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {

    public void player(Postgres psql, Player player) throws SQLException {

        PreparedStatement ps;
        Bukkit.getLogger().info("test inside insert");
        ps = psql.getConnection().prepareStatement("INSERT INTO player (uuid) VALUES(?) " +
                "ON CONFLICT (uuid) DO NOTHING");
        ps.setString(1, player.getPlayer().getUniqueId().toString());
        ps.executeUpdate();
        Bukkit.getLogger().info("test inside insert after");

    }
}

// INSERT INTO player (uuid)
// VALUES(UUID)
// ON CONFLICT (uuid)
// DO NOTHING