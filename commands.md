# Commands

## Key 
| Symbol      | Meaning                        |
| ----------- | ------------------------------ |
| (Argument)  | Argument is not required.      |
| Argument... | Accepts many of this argument. |
| *Command    | Argument can be in any order.  |

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

## Flexible
| Commands | Arguments                      | Description                                      |
| -------- | ------------------------------ | ------------------------------------------------ |
| *BigFlex | Character, User, Role, Channel | Flexible command that accepts several arguments. |
| *Flex    | Integer, Any                   | Flexible command that accepts 2 arguments        |
| NonFlex  | Integer, Any                   | <No Description>                                 |

## Math
| Commands | Arguments        | Description                    |
| -------- | ---------------- | ------------------------------ |
| Add      | Integer, Integer | Add two numbers together.      |
| Mult     | Integer, Integer | Multiply two numbers together. |
| Sub      | Integer, Integer | Subtract two numbers.          |

## Optional
| Commands    | Arguments          | Description                           |
| ----------- | ------------------ | ------------------------------------- |
| Number      | (Integer)          | Enter any number to see the next one. |
| OptionalAdd | Integer, (Integer) | Add one or two numbers together.      |
| User        | (User)             | Provides the tag of a given user.     |

## Preconditions
| Commands     | Arguments | Description                            |
| ------------ | --------- | -------------------------------------- |
| Precondition |           | Show a command failing a precondition. |

## Utility
| Commands | Arguments | Description          |
| -------- | --------- | -------------------- |
| Help     | (Command) | Display a help menu. |

