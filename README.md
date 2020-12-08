# CVS Password Retriever

If you forgot your password for CVS, there is good news because it is stored under your home directory. The file is called .cvspass and it needs to exist in order for this code to decode the password.

## Pre-requisite

You need to have a Java Development Toolkit installed.

## How to compile

Run the command:

```javac CVSPass.java```

## How to use

Run the command:

```java CVSPass```

Optionally, you can specify a directory path:

```java CVSPass /path/to/.cvspass/file/```

## Disclaimer

Getting the CVS password may give you access to sensitive source code and other data. Be sure it is your password you are retrieving or you have authorization to retrieve that person's password. I am not liable for anything you do with this.

## License

[MIT](https://github.com/shyrwinsia/cvspassword/blob/main/LICENSE)
