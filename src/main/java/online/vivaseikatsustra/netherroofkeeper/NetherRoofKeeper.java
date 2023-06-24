package online.vivaseikatsustra.netherroofkeeper;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class NetherRoofKeeper extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getServer().getPluginManager().registerEvents(this,this);
        getLogger().info("プラグインが有効になりました。");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("プラグインが無効になりました。");
    }


    // ブロックが置かれた時
    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent e){

        World w = e.getBlock().getWorld();
        Player p = e.getPlayer();
        Block b = e.getBlockPlaced();

        // ワールドがネザーじゃない場合、終了
        if(w.getEnvironment() != World.Environment.NETHER) return;

        // プレイヤーがOPだった場合、終了
        if(p.isOp()) return;

        // Y座標が128以下だった場合、終了
        if(b.getY() < 128) return;

        // ここまで来たブロック設置をはじく
        e.setCancelled(true);
        // プレイヤーにメッセージを送信
        p.sendMessage(ChatColor.RED +"ネザーの岩盤上は建築禁止です！");

    }




}
