# Commands

## Key 
| Symbol      | Meaning                        |
| ----------- | ------------------------------ |
| [Argument]  | Argument is not required.      |
| Argument... | Accepts many of this argument. |

## Arguments
| Commands | Arguments                           | Description                  |
| -------- | ----------------------------------- | ---------------------------- |
| Echo     | Text                                | Echo the input back.         |
| Junk     | Integer, Any, User, Channel, Double | Accept a bunch of arguments. |
| Sum      | Integer...                          | Sum a list of integers.      |

## Basics
| Commands | Arguments | Description              |
| -------- | --------- | ------------------------ |
| Embed    |           | Create an embed message. |
| Hello    |           | A 'Hello World' command. |
| Menu     |           | Create a menu message.   |

## Context
| Commands | Arguments | Description                                |
| -------- | --------- | ------------------------------------------ |
| Dm       |           | This command can only be used in a DM.     |
| Global   |           | This command can be used in a guild or DM. |
| Guild    |           | This command can only be used in a guild.  |

## Conversation
| Commands | Arguments | Description                                 |
| -------- | --------- | ------------------------------------------- |
| Private  |           | Starts a conversation in a private channel. |
| Public   |           | Start a conversation in a public channel.   |

## Math
| Commands | Arguments        | Description                    |
| -------- | ---------------- | ------------------------------ |
| Add      | Integer, Integer | Add two numbers together.      |
| Mult     | Integer, Integer | Multiply two numbers together. |
| Sub      | Integer, Integer | Subtract two numbers.          |

## Optional
| Commands    | Arguments          | Description                           |
| ----------- | ------------------ | ------------------------------------- |
| Number      | [Integer]          | Enter any number to see the next one. |
| OptionalAdd | Integer, [Integer] | Add one or two numbers together.      |
| User        | [User]             | Provides the tag of a given user.     |

## Overload
| Commands | Arguments | Description                               |
| -------- | --------- | ----------------------------------------- |
| Overload |           | This command has multiple execute blocks. |
|          | Any       |                                           |
|          | Integer   |                                           |

## Permissions
| Commands   | Arguments | Description                               |
| ---------- | --------- | ----------------------------------------- |
| BotOwner   |           | Command requiring BOT_OWNER permissions   |
| GuildOwner |           | Command requiring GUILD_OWNER permissions |

## Preconditions
| Commands     | Arguments | Description                            |
| ------------ | --------- | -------------------------------------- |
| Precondition |           | Show a command failing a precondition. |

## Slash
| Commands | Arguments                             | Description                |
| -------- | ------------------------------------- | -------------------------- |
| Slash    |                                       | A Hello World command.     |
| SlashAdd | First, Second                         | A simple addition command. |
| SlashAll | Integer, Boolean, User, Role, Channel | Accepts all types          |

## Utility
| Commands | Arguments | Description          |
| -------- | --------- | -------------------- |
| Help     | [Command] | Display a help menu. |

