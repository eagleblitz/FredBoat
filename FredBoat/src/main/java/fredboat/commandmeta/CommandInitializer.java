/*
 * MIT License
 *
 * Copyright (c) 2017 Frederik Ar. Mikkelsen
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package fredboat.commandmeta;

import fredboat.command.admin.*;
import fredboat.command.config.*;
import fredboat.command.fun.*;
import fredboat.command.fun.img.*;
import fredboat.command.info.*;
import fredboat.command.moderation.*;
import fredboat.command.music.control.*;
import fredboat.command.music.info.*;
import fredboat.command.music.seeking.*;
import fredboat.command.util.*;
import fredboat.perms.PermissionLevel;
import fredboat.util.AsciiArtConstant;
import fredboat.util.rest.OpenWeatherAPI;
import fredboat.util.rest.SearchUtil;

import java.util.Arrays;
import java.util.Collections;

public class CommandInitializer {

    public static void initCommands() {

        // Administrative Module - always on (as in, essential commands for BOT_ADMINs and BOT_OWNER)
        CommandRegistry adminModule = new CommandRegistry(CommandRegistry.Module.ADMIN);
        adminModule.registerCommand(new AnnounceCommand("announce"));
        adminModule.registerCommand(new BotRestartCommand("botrestart"));
        adminModule.registerCommand(new DisableCommandsCommand("disable"));
        adminModule.registerCommand(new EnableCommandsCommand("enable"));
        adminModule.registerCommand(new EvalCommand("eval"));
        adminModule.registerCommand(new ExitCommand("exit"));
        adminModule.registerCommand(new GetNodeCommand("getnode"));
        adminModule.registerCommand(new LeaveServerCommand("leaveserver"));
        adminModule.registerCommand(new NodeAdminCommand("node"));
        adminModule.registerCommand(new PlayerDebugCommand("playerdebug"));
        adminModule.registerCommand(new ReviveCommand("revive"));
        adminModule.registerCommand(new SentryDsnCommand("sentrydsn"));
        adminModule.registerCommand(new SetAvatarCommand("setavatar"));
        adminModule.registerCommand(new TestCommand("test"));
        adminModule.registerCommand(new UnblacklistCommand("unblacklist", "unlimit"));


        // Informational / Debugging / Maintenance - always on
        CommandRegistry infoModule = new CommandRegistry(CommandRegistry.Module.INFORMATIONAL);
        infoModule.registerCommand(new AudioDebugCommand("adebug"));
        infoModule.registerCommand(new CommandsCommand("commands", "comms", "cmds"));
        infoModule.registerCommand(new DebugCommand("debug"));
        infoModule.registerCommand(new FuzzyUserSearchCommand("fuzzy"));
        infoModule.registerCommand(new GetIdCommand("getid"));
        infoModule.registerCommand(new GitInfoCommand("gitinfo", "git"));
        infoModule.registerCommand(new HelpCommand("help", "info"));
        infoModule.registerCommand(new InviteCommand("invite"));
        infoModule.registerCommand(new MusicHelpCommand("music", "musichelp"));
        infoModule.registerCommand(new NodesCommand("nodes"));
        infoModule.registerCommand(new PingCommand("ping"));
        infoModule.registerCommand(new ShardsCommand("shards"));
        infoModule.registerCommand(new StatsCommand("stats", "uptime"));
        infoModule.registerCommand(new VersionCommand("version"));
        infoModule.registerCommand(new TextCommand("https://github.com/Frederikam", "github"));
        infoModule.registerCommand(new TextCommand("https://github.com/Frederikam/FredBoat", "repo"));


        // Configurational stuff - always on
        CommandRegistry configModule = new CommandRegistry(CommandRegistry.Module.CONFIG);
        configModule.registerCommand(new ConfigCommand("config", "cfg"));
        configModule.registerCommand(new LanguageCommand("language", "lang"));
        configModule.registerCommand(new PrefixCommand("prefix", "pre"));
        /* Perms */
        configModule.registerCommand(new PermissionsCommand(PermissionLevel.ADMIN, "admin"));
        configModule.registerCommand(new PermissionsCommand(PermissionLevel.DJ, "dj"));
        configModule.registerCommand(new PermissionsCommand(PermissionLevel.USER, "user"));


        // Moderation Module - Anything related to managing Discord guilds
        CommandRegistry moderationModule = new CommandRegistry(CommandRegistry.Module.MODERATION);
        moderationModule.registerCommand(new ClearCommand("clear"));
        moderationModule.registerCommand(new HardbanCommand("hardban", "hb"));
        moderationModule.registerCommand(new KickCommand("kick"));
        moderationModule.registerCommand(new SoftbanCommand("softban", "sb"));


        // Utility Module - Like Fun commands but without the fun ¯\_(ツ)_/¯
        CommandRegistry utilityModule = new CommandRegistry(CommandRegistry.Module.UTILITY);
        utilityModule.registerCommand(new AvatarCommand("avatar", "ava"));
        utilityModule.registerCommand(new BrainfuckCommand("brainfuck"));
        utilityModule.registerCommand(new MALCommand("mal"));
        utilityModule.registerCommand(new MathCommand("math"));
        utilityModule.registerCommand(new ServerInfoCommand("serverinfo", "guildinfo"));
        utilityModule.registerCommand(new UserInfoCommand("userinfo", "memberinfo"));
        utilityModule.registerCommand(new WeatherCommand(new OpenWeatherAPI(), "weather"));


        // Fun Module - mostly ascii, memes, pictures, games
        CommandRegistry funModule = new CommandRegistry(CommandRegistry.Module.FUN);
        funModule.registerCommand(new AkinatorCommand("akinator", "aki"));
        funModule.registerCommand(new DanceCommand("dance"));
        funModule.registerCommand(new JokeCommand("joke", "jk"));
        funModule.registerCommand(new RiotCommand("riot"));
        funModule.registerCommand(new SayCommand("say"));

        /* Other Anime Discord, Sergi memes or any other memes
           saved in this album https://imgur.com/a/wYvDu        */
        funModule.registerCommand(new RemoteFileCommand("http://i.imgur.com/DYToB2e.jpg", "ram"));
        funModule.registerCommand(new RemoteFileCommand("http://i.imgur.com/utPRe0e.gif", "welcome"));
        funModule.registerCommand(new RemoteFileCommand("http://i.imgur.com/j8VvjOT.png", "rude"));
        funModule.registerCommand(new RemoteFileCommand("http://i.imgur.com/oJL7m7m.png", "fuck"));
        funModule.registerCommand(new RemoteFileCommand("http://i.imgur.com/BrCCbfx.png", "idc"));
        funModule.registerCommand(new RemoteFileCommand("http://i.imgur.com/jjoz783.png", "beingraped"));
        funModule.registerCommand(new RemoteFileCommand("http://i.imgur.com/93VahIh.png", "anime"));
        funModule.registerCommand(new RemoteFileCommand("http://i.imgur.com/w7x1885.png", "wow"));
        funModule.registerCommand(new RemoteFileCommand("http://i.imgur.com/GNsAxkh.png", "what"));
        funModule.registerCommand(new RemoteFileCommand("http://i.imgur.com/sBfq3wM.png", "pun"));
        funModule.registerCommand(new RemoteFileCommand("http://i.imgur.com/pQiT26t.jpg", "cancer"));
        funModule.registerCommand(new RemoteFileCommand("http://i.imgur.com/YT1Bkhj.png", "stupidbot"));
        funModule.registerCommand(new RemoteFileCommand("http://i.imgur.com/QmI469j.png", "escape"));
        funModule.registerCommand(new RemoteFileCommand("http://i.imgur.com/qz6g1vj.gif", "explosion"));
        funModule.registerCommand(new RemoteFileCommand("http://i.imgur.com/eBUFNJq.gif", "gif"));
        funModule.registerCommand(new RemoteFileCommand("http://i.imgur.com/mKdTGlg.png", "noods"));
        funModule.registerCommand(new RemoteFileCommand("http://i.imgur.com/84nbpQe.png", "internetspeed"));
        funModule.registerCommand(new RemoteFileCommand("http://i.imgur.com/i65ss6p.png", "powerpoint"));
        
        /* Text Faces & Unicode 'Art' & ASCII 'Art' and Stuff */
        funModule.registerCommand(new TextCommand("¯\\_(ツ)_/¯", "shrug", "shr"));
        funModule.registerCommand(new TextCommand("ಠ_ಠ", "faceofdisapproval", "fod", "disapproving"));
        funModule.registerCommand(new TextCommand("༼ つ ◕_◕ ༽つ", "sendenergy"));
        funModule.registerCommand(new TextCommand("(•\\_•) ( •\\_•)>⌐■-■ (⌐■_■)", "dealwithit", "dwi"));
        funModule.registerCommand(new TextCommand("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ ✧ﾟ･: *ヽ(◕ヮ◕ヽ)", "channelingenergy"));
        funModule.registerCommand(new TextCommand("Ƹ̵̡Ӝ̵̨̄Ʒ", "butterfly"));
        funModule.registerCommand(new TextCommand("(ノಠ益ಠ)ノ彡┻━┻", "angrytableflip", "tableflipbutangry", "atp"));
        funModule.registerCommand(new TextCommand(AsciiArtConstant.DOG, "dog", "cooldog", "dogmeme"));
        funModule.registerCommand(new TextCommand("T-that's l-lewd, baka!!!", "lewd", "lood", "l00d"));
        funModule.registerCommand(new TextCommand("This command is useless.", "useless"));
        funModule.registerCommand(new TextCommand("¯\\\\(°_o)/¯", "shrugwtf", "swtf"));
        funModule.registerCommand(new TextCommand("ヽ(^o^)ノ", "hurray", "yay", "woot"));
        /* Lennies */
        funModule.registerCommand(new TextCommand("/╲/╭( ͡° ͡° ͜ʖ ͡° ͡°)╮/╱\\", "spiderlenny"));
        funModule.registerCommand(new TextCommand("( ͡° ͜ʖ ͡°)", "lenny"));
        funModule.registerCommand(new TextCommand("┬┴┬┴┤ ͜ʖ ͡°) ├┬┴┬┴", "peeking", "peekinglenny", "peek"));
        funModule.registerCommand(new TextCommand(AsciiArtConstant.MAGICAL_LENNY, "magicallenny", "lennymagical"));
        funModule.registerCommand(new TextCommand(AsciiArtConstant.EAGLE_OF_LENNY, "eagleoflenny", "eol", "lennyeagle"));

        /* Random images / image collections */
        funModule.registerCommand(new CatgirlCommand("catgirl", "neko", "catgrill"));
        funModule.registerCommand(new FacedeskCommand("https://imgur.com/a/I5Q4U", "facedesk"));
        funModule.registerCommand(new HugCommand("https://imgur.com/a/jHJOc", "hug"));
        funModule.registerCommand(new PatCommand("https://imgur.com/a/WiPTl", "pat"));
        funModule.registerCommand(new RollCommand("https://imgur.com/a/lrEwS", "roll"));


        // Music Module

        CommandRegistry musicModule = new CommandRegistry(CommandRegistry.Module.MUSIC);
        /* Control */
        musicModule.registerCommand(new DestroyCommand("destroy"));
        musicModule.registerCommand(new JoinCommand("join", "summon", "jn", "j"));
        musicModule.registerCommand(new LeaveCommand("leave", "lv"));
        musicModule.registerCommand(new PauseCommand("pause", "pa", "ps"));
        musicModule.registerCommand(new PlayCommand(Arrays.asList(SearchUtil.SearchProvider.YOUTUBE, SearchUtil.SearchProvider.SOUNDCLOUD),
                "play", "p"));
        musicModule.registerCommand(new PlayCommand(Collections.singletonList(SearchUtil.SearchProvider.YOUTUBE),
                "youtube", "yt"));
        musicModule.registerCommand(new PlayCommand(Collections.singletonList(SearchUtil.SearchProvider.SOUNDCLOUD),
                "soundcloud", "sc"));
        musicModule.registerCommand(new PlaySplitCommand("split"));
        musicModule.registerCommand(new RepeatCommand("repeat", "rep"));
        musicModule.registerCommand(new ReshuffleCommand("reshuffle", "resh"));
        musicModule.registerCommand(new SelectCommand("select", buildNumericalSelectAliases("sel")));
        musicModule.registerCommand(new ShuffleCommand("shuffle", "sh", "random"));
        musicModule.registerCommand(new SkipCommand("skip", "sk", "s"));
        musicModule.registerCommand(new StopCommand("stop", "st"));
        musicModule.registerCommand(new UnpauseCommand("unpause", "unp", "resume"));
        musicModule.registerCommand(new VolumeCommand("volume", "vol"));
        musicModule.registerCommand(new VoteSkipCommand("voteskip", "vsk", "v"));

        /* Info */
        musicModule.registerCommand(new ExportCommand("export", "ex"));
        musicModule.registerCommand(new GensokyoRadioCommand("gensokyo", "gr", "gensokyoradio"));
        musicModule.registerCommand(new HistoryCommand("history", "hist", "h"));
        musicModule.registerCommand(new ListCommand("list", "queue", "q", "l"));
        musicModule.registerCommand(new NowplayingCommand("nowplaying", "np"));

        /* Seeking */
        musicModule.registerCommand(new ForwardCommand("forward", "fwd"));
        musicModule.registerCommand(new RestartCommand("restart", "replay"));
        musicModule.registerCommand(new RewindCommand("rewind", "rew"));
        musicModule.registerCommand(new SeekCommand("seek"));
    }


    /**
     * Build a string array that consist of the max number of searches.
     *
     * @param extraAliases Aliases to be appended to the rest of the ones being built.
     * @return String array that contains string representation of numbers with addOnAliases.
     */
    private static String[] buildNumericalSelectAliases(String... extraAliases) {
        String[] selectTrackAliases = new String[SearchUtil.MAX_RESULTS + extraAliases.length];
        int i = 0;
        for (; i < extraAliases.length; i++) {
            selectTrackAliases[i] = extraAliases[i];
        }
        for (; i < SearchUtil.MAX_RESULTS + extraAliases.length; i++) {
            selectTrackAliases[i] = String.valueOf(i - extraAliases.length + 1);
        }
        return selectTrackAliases;
    }

}