package com.company;

import java.util.Scanner;

public class Settings
{
    public void Settings(){}

    public String MailToSend(Scanner in)
    {
        System.out.println("Enter E-Mail to send: ");
        return in.nextLine();
    }

    public String MailFromSend(Scanner in)
    {
        System.out.println("Enter E-Mail from will be send: ");
        return in.nextLine();
    }

    public String Time(Scanner in)
    {
        System.out.println("Enter Time to updating: ");
        return in.nextLine();
    }

    public String Host (Scanner in)
    {
        System.out.println("Enter Host to connection: ");
        return in.nextLine();
    }
}
