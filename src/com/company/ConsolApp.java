package com.company;

import javax.mail.internet.AddressException;
import java.io.IOException;
import java.util.Scanner;

public class ConsolApp
{
    public static String COMMAND = (char) 27 + "[92m";
    public static String END = (char) 27 + "[0m";
    private static String timeOfRequest = "13:00";
    private static String mailFromSend = "molllall901@gmail.com";
    private static String mailToSend = "katomachin@mail.ru ";
    private String host = "127.0.0.1";

    public void ConsolApp ()
    {
        System.out.println("ConsolApp for working whith .... ");
        System.out.println("Type "+ COMMAND + "help" + END + " for list of commands; " +
                            COMMAND + "quit" + END + " to quit.");
        inputPreWrite();
    }

    private void inputPreWrite ()
    {
        try (Scanner in = new Scanner(System.in))
        {
            do
            {
                System.out.print("KatSender> ");
            }while (isCommand(in.nextLine(),in));
        }catch (Exception e)
        {
            System.out.println("Something went wrong :(");
        }finally
        {
            System.out.println("End of KatSender");
        }
    }

    private boolean isCommand (String input,Scanner in) throws IOException, AddressException {
        Settings settings = new Settings();
        MailSender mailSender = new MailSender();
        ToCalender toCalender = new ToCalender();
        HTMLParser htmlParser = new HTMLParser();
        String[] command = input.split(" ");
        switch(command[0])
        {
            case "help":
                helper();
                return true;
            case "chHost":
                host = settings.Host(in);
                return  true;
            case "chTime":
                timeOfRequest = settings.Time(in);
                return true;
            case "chMailTo":
                mailToSend = settings.MailToSend(in);
                return true;
            case "chMailFrom":
                mailFromSend = settings.MailFromSend(in);
                return true;
            case "start":
                mailSender.MailSender(mailFromSend,mailToSend,host);
                htmlParser.HTMLParser();
                toCalender.ToCalender(htmlParser.text,htmlParser.secondComand);
                return true;
            case "quit":
            case "exit":
                return false;
            default:
                System.out.println("Unknown command, try again ;)");
                return true;
        }
    }

    private void helper ()
    {
        System.out.println("Command " + COMMAND + "start" + END + " for STARTING the program KatSender");
        System.out.println("Command " + COMMAND + "quit" + END + " or " + COMMAND + "exit" + END
                + " for ENDING the program KatSender");
        System.out.println("Command " + COMMAND + "chTime" + END + " for chang Time of updating");
        System.out.println("Command " + COMMAND + "chHost" + END + " for chang Host of connection");
        System.out.println("Command " + COMMAND + "chMailTo" + END + " for chang address of Mail ON which will sending Mails");
        System.out.println("Command " + COMMAND + "chMailFrom" + END + " for chang address of Mail FROM which will sending Mails");
    }
}
