/*
 * Copyright (C) 2016-2018 David Alejandro Rubio Escares / Kodehawa
 *
 * Mantaro is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Mantaro is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Mantaro.  If not, see http://www.gnu.org/licenses/
 */

package net.kodehawa.mantarobot.core.modules.commands.base;

import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.kodehawa.mantarobot.options.core.Option;

/**
 * Interface used for handling commands within the bot.
 */
public interface Command {
    /**
     * The Command's {@link Category}
     *
     * @return a Nullable {@link Category}. Null means that the command should be hidden from Help.
     */
    Category category();

    /**
     * Embed to be used on help command
     *
     * @param event the event that triggered the help
     * @return a Nullable {@link MessageEmbed}
     */
    MessageEmbed help(GuildMessageReceivedEvent event);

    CommandPermission permission();

    /**
     * Invokes the command to be executed.
     *
     * @param event       the event that triggered the command
     * @param commandName the command name that was used
     * @param content     the arguments of the command
     */
    void run(GuildMessageReceivedEvent event, String commandName, String content);

    Command addOption(String call, Option option);
}
