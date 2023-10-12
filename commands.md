# Commands

## Key 
| Symbol      | Meaning                        |
|-------------|--------------------------------|
| [Argument]  | Argument is not required.      |
| /Category   | This is a subcommand group.    |

## /Math
| Commands | Arguments     | Description                   |
|----------|---------------|-------------------------------|
| Add      | First, Second | Add two numbers together      |
| Mult     | First, Second | Multiply two numbers together |
| Sub      | First, Second | Subtract two numbers          |

## /Prompt
| Commands | Arguments | Description |
|----------|-----------|-------------|
| Modal    |           |             |

## Arguments
| Commands | Arguments                           | Description                 |
|----------|-------------------------------------|-----------------------------|
| Choice   | Names                               | Provides a choice UI        |
| Echo     | Text                                | Echo the input back         |
| Junk     | Integer, Any, User, Channel, Double | Accept a bunch of arguments |
| Plus     | First, Second                       | A simple addition command   |

## Basics
| Commands | Arguments | Description             |
|----------|-----------|-------------------------|
| Embed    |           | Create an embed message |
| Hello    |           | A 'Hello World' command |

## Context
| Commands | Arguments | Description                         |
|----------|-----------|-------------------------------------|
| Link     | Message   | Get a message's jump link           |
| UserInfo | User      | Get information for the target user |

## Conversation
| Commands | Arguments | Description                                |
|----------|-----------|--------------------------------------------|
| Private  |           | Starts a conversation in a private channel |
| Public   |           | Start a conversation in a public channel   |
| Slash    |           | Start a conversation from a slash command  |

## Data
| Commands | Arguments | Description                            |
|----------|-----------|----------------------------------------|
| Data     |           | Display the Data from the config file. |
| SetData  | Integer   | Modify the Data from the config file   |

## Math
| Commands | Arguments     | Description                   |
|----------|---------------|-------------------------------|
| Add      | First, Second | Add two numbers together      |
| Mult     | First, Second | Multiply two numbers together |
| Sub      | First, Second | Subtract two numbers          |

## Optional
| Commands    | Arguments       | Description                          |
|-------------|-----------------|--------------------------------------|
| Number      | [Integer]       | Enter any number to see the next one |
| OptionalAdd | First, [Second] | Add one or two numbers together      |
| User        | [User]          | Provides the tag of a given user     |

## Overload
| Commands | Arguments | Description                              |
|----------|-----------|------------------------------------------|
| Overload |           | This command has multiple execute blocks |
|          | Any       |                                          |
|          | Integer   |                                          |

## Permissions
| Commands   | Arguments | Description                               |
|------------|-----------|-------------------------------------------|
| GuildOwner |           | Command requiring GUILD_OWNER permissions |
| Staff      |           | Command requiring STAFF permissions       |

## Preconditions
| Commands     | Arguments | Description                           |
|--------------|-----------|---------------------------------------|
| Precondition |           | Show a command failing a precondition |

## Text
| Commands | Arguments | Description                               |
|----------|-----------|-------------------------------------------|
| Dm       |           | This command can only be used in a DM     |
| Global   |           | This command can be used in a guild or DM |
| Guild    |           | This command can only be used in a guild  |
| Menu     |           | Create a menu message                     |

## Utility
| Commands | Arguments | Description             |
|----------|-----------|-------------------------|
| Help     | [Command] | Display a help menu.    |
| info     |           | Bot info for ExampleBot |

