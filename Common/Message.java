package Common;

import java.io.Serializable;

public class Message implements Serializable
{
    User user;
    String message;

    public Message(User user, String message)
    {
        this.user = user;
        this.message = message;
    }
}